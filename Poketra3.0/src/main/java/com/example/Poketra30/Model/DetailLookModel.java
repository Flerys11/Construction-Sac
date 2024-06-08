package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DetailLookModel {
    @Id
    private int idlookmatiere;
    @Column(name = "idlook")
    private int idlook;
    @Column(name = "taille_sac")
    private String taille_sac;
    @Column(name = "nom_look")
    private String nom_look;
    @Column(name = "nom_matiere")
    private String nom_matiere;
    @Column(name = "prix_unitaire")
    private double prix_unitaire;
    @Column(name = "quantite")
    private double quantite;
}
