package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_Get_Benf")
@Getter
@Setter
public class BeneficeModel {
    @Id
    private int taille;
    @Column(name = "idproduitcree")
    private int idproduitcree;
    @Column(name = "nom_taille")
    private String nom_taille;
    @Column(name = "nom_produit")
    private  String nom_produit;
    @Column(name = "benefice")
    private double benefice;
}
