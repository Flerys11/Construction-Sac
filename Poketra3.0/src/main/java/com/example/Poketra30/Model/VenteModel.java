package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prix_vente")
@Getter
@Setter
public class VenteModel {
    @Id
    private int id;
    @Column(name = "idproduitcree")
    private int idproduitcree;
    @Column(name = "prix_vente")
    private  double prix_vente;
    @Column(name = "quantite_sortie")
    private int quantite_sortie;
    @Column(name = "idclient")
    private int idclient;
    @Column(name = "date_achat")
    private LocalDate date_achat;
}

