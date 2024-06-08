package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produitcreer")
@Getter
@Setter
public class ProduitCreeModel {
    @Id
    private int id;
    @Column(name = "idproduit")
    private int idproduit;
    @Column(name = "idlook")
    private int idlook;
    @Column(name = "idtaille")
    private int idtaille;
    @Column(name = "quantite")
    private double quantite;
}
