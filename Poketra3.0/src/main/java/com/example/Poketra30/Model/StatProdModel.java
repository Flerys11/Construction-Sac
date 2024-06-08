package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_get_Stat_Pro")
@Getter
@Setter
public class StatProdModel {
    @Id
    private int genre;
    @Column(name = "nom_genre")
    private String nom_genre;
    @Column(name = "idproduitcree")
    private int idproduitcree;
    @Column(name = "total_quantite")
    private double total_quantite;
    @Column(name = "pourcentage_produit")
    private double pourcentage_produit;
}
