package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_getProduit_Matiere")
@Getter
@Setter
public class ParametreMaModel {
    @Id
    private int idmatiere;
    @Column(name = "idlook")
    private  int idlook;
    @Column(name = "taille")
    private  int taille;
    @Column(name = "quantite")
    private  double quantite;
    @Column(name = "taille_sac")
    private String taille_sac;
    @Column(name = "nom_look")
    private String nom_look;
    @Column(name = "nom_matiere")
    private  String nom_matiere;
    @Column(name = "idproduit")
    private int idproduit;
    @Column(name = "nom_produit")
    private  String nom_produit;
    @Column(name = "prix_unitaire")
    private double prix_unitaire;

}
