package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "v_get_Quantite_Reste")
@Getter
@Setter
public class RestMatiereModel {

    @Id
    private int idmatiere;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prix_unitaire")
    private double prix_unitaire;
    @Column(name = "quantite_finaux")
    private double quantite_finaux;
}

