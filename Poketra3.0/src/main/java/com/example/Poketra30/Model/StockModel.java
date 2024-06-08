package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "stock_matiere")
@Getter
@Setter
public class StockModel {
    @Id
    private int id;
    @Column(name = "idmatiere")
    private  int idmatiere;

    @Column(name = "quantite")
    private  int quantite;

    @Column(name = "prix_unitaire")
    private double prix_unitaire;

    @Column(name = "date_reception")
    private LocalDate date_reception;
}
