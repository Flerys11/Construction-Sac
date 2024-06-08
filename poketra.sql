create database poketra
\c poketra

create table produit(
    idProduit serial primary key,
    nom varchar(50)
);
create table look(
    idLook serial primary key,
    nom varchar(255)
);

create table look_produit

create table type(
    idType serial primary key,
    type varchar(50),
    idProduit int  references produit(idProduit),
    idLook int references look(idLook)
);

create table matiere(
    idMatiere serial primary key,
    nom varchar(255)
);
ALTER table stock_matiere
ADD COLUMN date_reception timestamp;



DROP view v_getmatiere_look;

create table historyMatiere(
    id serial primary key,
    idMatiere int,
    nom varchar(50),
    date_modification date
);


create or replace FUNCTION delete_matiere_history(
    mat_id int
) RETURNS void as $$
DECLARE 
    nomMat varchar(50);
BEGIN 

    select nom into nomMat 
    from matiere
    where idmatiere = mat_id;

    delete from matiere where idmatiere = mat_id;

    insert into historyMatiere(idMatiere,nom,date_modification)
    values(mat_id,nomMat,CURRENT_DATE);
END;
$$ LANGUAGE plpgsql;

select delete_matiere_history(9);

create table lookMatiere(
    idlookMatiere serial primary key,
    idMatiere int references matiere(idMatiere),
    idLook int references look (idLook),
);

create table taille (
    id serial primary key,
    nom varchar(50)
);

create table lookMatiere(
    idlookMatiere serial primary key,
    idMatiere int references matiere(idMatiere),
    idLook int references look (idLook),
    taille int references taille(id),
    quantite integer
);

UPDATE matiere set nom = 'Tissu Brode' where idmatiere = 2;

create table stock_matiere(
    id serial primary key,
    idmatiere int references matiere(idMatiere),
    quantite  double precision,
    prix_unitaire double precision,
    date_entree timestamp
);


ALTER stock_matiere

insert into stock_matiere values(default,3,100,2000);

create table stock_matiere(
    id serial primary key,
    idmatiere int references matiere(idMatiere),
    quantite  double precision,
    prix_unitaire double precision
);

insert into m_sortie values(default,1,5);

create table m_sortie(
    id serial primary key,
    idmatiere int references matiere(idMatiere),
    quantite integer
);

create or replace view v_getQuantite_Reste as
select s.idmatiere,sum(e.quantite-s.quantite) as quantite_finaux, m.nom
from m_sortie as s join stock_matiere as e on s.idmatiere = e.idmatiere
join matiere as m on m.idMatiere = s.idMatiere
group by  s.idmatiere,m.nom;

create or replace view v_get_Quantite_Reste as
select s.idmatiere,(e.quantite-sum(s.quantite)) as quantite_finaux, m.nom, sm.prix_unitaire
from m_sortie as s join stock_matiere as e on s.idmatiere = e.idmatiere
join matiere as m on m.idMatiere = s.idMatiere
join stock_matiere as sm on s.idMatiere = sm.idmatiere
group by  s.idmatiere, e.quantite,m.nom,sm.prix_unitaire;



create table sortie (
    id serial primary key,
    idmatiere int references matiere(idMatiere),
    quantite double precision,
    date_sortie timestamp
);

create table mouvement(
    id serial primary key,
    identree int references stock_matiere(id),
    idsortie int references sortie(id) 
);

create table produitcreer(
    id serial primary key,
    idProduit int references produit(idProduit),
    idLook int references look(idLook),
    idTaille int references taille(id),
    quantite integer
);

insert into produitcreer values(default,1,2,2,10);

create or replace view v_prod_creer_finaux as
SELECT COALESCE(SUM(pc.quantite) - COALESCE(ps.quantite, 0), 0) AS quantitef,
       pc.idproduit,
       pc.idlook,
       pc.idtaille
FROM produitcreer pc
LEFT JOIN v_prod_creer_sortie ps ON ps.idproduitcree = pc.idproduit
GROUP BY pc.idproduit, pc.idlook, pc.idtaille, ps.idproduitcree, ps.quantite;



create or replace view v_prod_creer_finaux1 as
select pf.* , p.nom as nom_produit, l.nom as nom_look, t.nom as nom_taille
from v_prod_creer_finaux as pf join produit as p on p.idproduit = pf.idproduit
join look as l on pf.idlook = l.idlook
join taille as t on pf.idtaille = t.id;

create or replace view v_prod_creer_sortie as 
select idproduitcree,sum(quantite_sortie) as quantite
from prix_vente group by idproduitcree;


create table fonction(
    id serial primary key,
    nom varchar(50),
    salaire double precision
);


insert into fonction values(default,'ouvrier',1000),
(default,'livreur',900);

create table employe(
    idemploye varchar(20) primary key,
    nom varchar(50),
    idfonction int references fonction(id)
);


CREATE table coeffi_enct(
    id serial primary key,
    nom  varchar(20),
    coeff double precision,
    idfonction int references fonction(id)
);

insert INTO coeffi_enct values
(default,'ouvrier',1,1),
(default,'senior',2,1),
(default,'expert',5,1);


ALTER TABLE employe
ADD COLUMN Date_embauche date;

UPDATE employe set date_embauche = '2010-01-01' where idemploye = 'EMP004';

SELECT EXTRACT(YEAR FROM AGE(NOW(), date_embauche)) AS anciennte, e.idemploye, e.nom,
e.idfonction , co.coeff
FROM employe as e 
join coeffi_enct as co on co.idfonction = e.idfonction;

create or replace view v_Get_SalEmp as
SELECT
  EXTRACT(YEAR FROM AGE(NOW(), e.date_embauche)) AS annee,
  e.idemploye,
  e.nom,
  e.idfonction,
  CASE
    WHEN EXTRACT(YEAR FROM AGE(NOW(), e.date_embauche)) >= (SELECT coeff FROM coeffi_enct WHERE nom = 'expert') THEN 
      (SELECT (coeff - 2) FROM coeffi_enct WHERE nom = 'expert') * f.salaire
    WHEN EXTRACT(YEAR FROM AGE(NOW(), e.date_embauche)) BETWEEN (SELECT coeff FROM coeffi_enct WHERE nom = 'ouvrier') AND 
      (SELECT coeff FROM coeffi_enct WHERE nom = 'senior') THEN (SELECT coeff FROM coeffi_enct WHERE nom = 'senior') * f.salaire
    ELSE (SELECT coeff FROM coeffi_enct WHERE nom = 'ouvrier') * f.salaire
  END AS salaire,
  CASE
    WHEN EXTRACT(YEAR FROM AGE(NOW(), e.date_embauche)) >= (SELECT coeff FROM coeffi_enct WHERE nom = 'expert') THEN 
      (SELECT nom FROM coeffi_enct WHERE nom = 'expert')
    WHEN EXTRACT(YEAR FROM AGE(NOW(), e.date_embauche)) BETWEEN (SELECT coeff FROM coeffi_enct WHERE nom = 'ouvrier') AND 
      (SELECT coeff FROM coeffi_enct WHERE nom = 'senior') THEN (SELECT nom FROM coeffi_enct WHERE nom = 'senior') 
    ELSE (SELECT nom FROM coeffi_enct WHERE nom = 'ouvrier')
  END AS nom_coeffi
FROM employe e
JOIN coeffi_enct co ON e.idfonction = co.idfonction
JOIN fonction f ON f.id = e.idfonction
GROUP BY annee, e.idemploye, e.nom, e.idfonction, salaire, nom_coeffi;


select * from v_Get_SalEmp as sal join coeffi_enct as co on co.idfonction = sal.idfonction;


insert into employe values('EMP001','Jean',1),
('EMP002','Doe',2);
('EMP003','Jhon',2);
('EMP004','Kanto',1);

insert into employe values
('EMP003','Jhon',2),
('EMP004','Kanto',1);


-- create table salaire(
--     id serial primary key,
--     type varchar(50),
--     salaire double precision
-- );

create table prix_vente(
    id serial primary key,
    idproduitcree int references produitcreer(id),
    prix_vente double precision,
    quantite_sortie integer,
    idclient int references client(id),
    date_achat date
);


insert into prix_vente values
(default,1,1000,1,1,'2022-12-01'),
(default,1,1000,1,2,'2022-12-01'),
(default,1,1000,1,2,'2022-12-01'),
(default,1,1000,1,2,'2022-12-01'),
(default,1,1000,1,2,'2022-12-01'),
(default,1,1000,1,1,'2022-12-01');

create or replace view v_get_Stat_Produit as
select sum(quantite_sortie)as quantite_par_genre, pv.idproduitcree, pv.prix_vente, c.nom, c.nom_genre,c.genre
, pv.date_achat
from prix_vente as pv join v_getClient as c on pv.idclient = c.id
group by c.genre,pv.idproduitcree, pv.prix_vente, c.nom, c.nom_genre,pv.date_achat;


create or replace view v_get_Stat_Global as
SELECT
  nom_genre,
  genre,
  SUM(quantite_par_genre) AS total_quantite,
  (SUM(quantite_par_genre) * 100.0 / SUM(SUM(quantite_par_genre)) OVER ()) AS pourcentage_total
FROM v_get_Stat_Produit
GROUP BY genre,nom_genre;

create or replace view v_get_Stat_Pro as
SELECT
  nom_genre,
  genre,
  idproduitcree,
  SUM(quantite_par_genre) AS total_quantite,
  (SUM(quantite_par_genre) * 100.0 / SUM(SUM(quantite_par_genre)) OVER (PARTITION BY idproduitcree)) AS pourcentage_produit
FROM v_get_Stat_Produit
GROUP BY genre, idproduitcree,nom_genre;


ALTER table prix_vente 
add COLUMN date_achat date;


create table genreClient(
    id serial primary key,
    nom varchar(20)
);
insert into genreClient values(default,'homme'),
(default,'femme');

create table client(
    id serial primary key,
    nom varchar(20),
    genre int references genreClient(id)
);

create or replace view v_getClient as 
select c.id, c.nom, c.genre,g.nom as nom_genre
 from client as c join genreClient as g on c.genre = g.id;

insert into client values
(default, 'fetra',1),
(default, 'felena',2);


create table parametre_employer (
    id serial primary key,
    idemploye varchar(20) references employe(idemploye),
    ididproduitcree int references produitcreer(id),
    tempsdefinition double precision
);

insert into parametre_employer values (default,'EMP002',1,2),
(default,'EMP002',1,2);

insert into parametre_employer values (default,'EMP001',1,2);
delete from parametre_employer where id = 2;


select *
from parametre_employer as pe join produitcreer as pc on pe.ididproduitcree = pc.id
left join employe as e on e.idemploye = pe.idemploye
join fonction as f on e.idfonction = f.id;


create or replace view get_SalaireEmploye as 
select sum(salaire*tempsdefinition)*pc.quantite as salaire_produit_fini, pe.idemploye,idtaille,pe.ididproduitcree, pc.quantite
from parametre_employer as pe join produitcreer as pc on pe.ididproduitcree = pc.id
left join employe as e on e.idemploye = pe.idemploye
join fonction as f on e.idfonction = f.id
group by pe.idemploye,idtaille,pe.ididproduitcree,pc.quantite;


create or replace view v_produit_type as 
select p.idProduit, p.nom as nom_produit, t.idlook
from produit  as p join type as t on p.idProduit = t.idProduit;


-- create or replace view v_getMouvement as  
-- select m.id,ma.nom as nom_matiere, st.quantite as quantite_entree, 
-- st.date_entree, st.prix_unitaire, s.quantite as quantite_sortie, s.date_sortie
-- from mouvement as m join stock_matiere as st on m.identree = st.id 
-- join sortie as s on m.idsortie = s.id
-- left join matiere as ma on st.idmatiere = ma.idMatiere;


-- eliminer les repetitions
SELECT DISTINCT * FROM ;

create or replace view v_getMatiere_look as
select lm.idMatiere, lm.idLook, lm.taille, lm.quantite, t.nom as taille_sac, l.nom as nom_look, m.nom as nom_matiere, m.prix_unitaire, pt.idproduit, pt.nom_produit
from lookMatiere as lm join look as l on lm.idLook = l.idLook
join matiere as m on lm.idMatiere = m.idMatiere
join taille as t on lm.taille = t.id
join v_produit_type as pt on pt.idLook = lm.idLook ;

create or replace view v_Produit_Look as
select lm.idMatiere, lm.idLook, lm.taille, lm.quantite, t.nom as taille_sac, l.nom as nom_look, m.nom as nom_matiere,pt.idproduit, pt.nom_produit, st.prix_unitaire
from lookMatiere as lm join look as l on lm.idLook = l.idLook
join matiere as m on lm.idMatiere = m.idMatiere
join taille as t on lm.taille = t.id
join v_produit_type as pt on pt.idLook = lm.idLook 
join stock_matiere as st on st.idmatiere = lm.idMatiere;

create or replace view v_get_Produit_Matiere as
select lm.idMatiere, lm.idLook, lm.taille, lm.quantite,lm.idlookmatiere ,t.nom as taille_sac, l.nom as nom_look, m.nom as nom_matiere,pt.idproduit, pt.nom_produit, st.prix_unitaire
from lookMatiere as lm join look as l on lm.idLook = l.idLook
join matiere as m on lm.idMatiere = m.idMatiere
join taille as t on lm.taille = t.id
join v_produit_type as pt on pt.idLook = lm.idLook 
join stock_matiere as st on st.idmatiere = lm.idMatiere;

select * from v_getProduit_Matiere where idLook = 1 and taille_sac = 'PM';

create or replace view v_total
select sum(quantite*prix_unitaire) as prix_total,idproduit
from v_getProduit_Matiere where idproduit = 1 and taille =1 and idlook =1
group by idproduit;

create or replace view v_prix_produit as
select sum(quantite*prix_unitaire) as prix_total,idproduit,taille
from v_getProduit_Matiere 
group by idproduit, taille;

create or replace view v_total_Sal as
select sum(salaire_produit_fini) as total_salaire_employer,ididproduitcree,idtaille
from get_SalaireEmploye group by ididproduitcree,idtaille;

create or replace view v_depense_entre as
SELECT
    pp.idproduit,
    pp.prix_total,
    pp.taille,
    sal.total_salaire_employer,
    (CASE WHEN pp.taille = 2 THEN (sal.total_salaire_employer + pp.prix_total) * 2
          ELSE sal.total_salaire_employer + pp.prix_total END) as depense
FROM
    v_prix_produit as pp
JOIN
    v_total_Sal as sal ON pp.idproduit = sal.ididproduitcree
GROUP BY
    pp.taille, pp.idproduit, pp.prix_total, sal.total_salaire_employer;



select * from prix_vente;

insert into prix_vente values(default,1,10000,5);


create or replace view v_prix_look as
select sum(quantite*prix_unitaire) as prix_total, nom_look , taille_sac,nom_produit  
from v_getMatiere_look  group by nom_look,taille_sac, nom_produit;

create or replace view v_GetBenefice as
select (pv.prix_vente * pv.quantite_sortie)- de.depense as benefice, pv.idproduitcree, pv.quantite_sortie,de.taille
from prix_vente as pv
join v_depense_entre as de on de.idproduit = pv.idproduitcree
group by pv.idproduitcree, pv.prix_vente,pv.quantite_sortie,de.depense,de.taille;


create or replace view v_Get_Benf as
select sum(bn.benefice) as benefice, bn.idproduitcree, bn.taille, t.nom as nom_taille, p.nom as nom_produit 
from v_GetBenefice as bn join taille as t on bn.taille = t.id
join produit as p on bn.idproduitcree = p.idProduit
join v_total_Sal as sal on bn.idproduitcree = sal.ididproduitcree
GROUP by bn.taille, bn.idproduitcree,t.nom, p.nom ;

select sum(benefice) from v_Get_Benf group by taille;

select * from v_GetBenf where benefice between -73000 and -30000; 


select * from v_prix_look where prix_total between 8000 and 16000;


insert into look (nom,) values('luxe');
insert into look (nom) values('normale');
insert into look (nom) values('debraille');

insert into matiere(nom,prix_unitaire) values 
('Cuir',4000),
('Tissu Brode', 3000),
('accessoires de deco',2000);

insert into taille(nom) values 
('PM'),
('GM');

insert into lookMatiere(idMatiere,idlook,taille,quantite) values
(1,1,1,1),
(1,1,2,2),
(2,1,1,2),
(2,1,2,3),
(3,1,1,3),
(3,1,2,4); 

create table paremtre_produit(

);

create table 

create or replace view typeProduit as
select t.idType,t.type,t.idProduit,t.idLook,p.nom as nomProduit, l.nom as nomLook
 from type as t join produit as p on t.idProduit = p.idProduit
join look as l on t.idLook = l.idLook;

create or replace view matiere_look_produit as
select lm.idlookMatiere,m.idMatiere,lm.idLook,m.nom as nomMatiere,m.prix_unitaire,tp.idType,tp.idProduit,tp.nomProduit,tp.nomLook
from lookMatiere as lm join matiere as m on lm.idMatiere = m.idMatiere  join typeProduit as tp on  tp.idLook = lm.idLook;

delete from matiere where id = 
