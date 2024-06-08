package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_getQuantite_Reste")
@Getter
@Setter
public class StockMatiereModel {
    @Id
    private int idmatiere;
    @Column(name = "quantite_finaux")
    private  double quantite_finaux;
    @Column(name = "nom")
    private  String nom;
}
