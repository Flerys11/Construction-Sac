package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_prod_creer_finaux1")
@Getter
@Setter
public class DetailProduitModel {
    @Id
    private  int idproduit;
    @Column(name = "idlook")
    private  int idlook;

    @Column(name ="idtaille")
    private  int idtaille;
    @Column(name = "nom_produit")
    private String nom_produit;
    @Column(name = "nom_look")
    private  String nom_look;
    @Column(name = "nom_taille")
    private  String nom_taille;
    @Column(name = "quantitef")
    private  double quantitef;
}
