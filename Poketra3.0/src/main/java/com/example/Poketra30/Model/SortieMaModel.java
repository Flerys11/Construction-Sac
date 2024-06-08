package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "m_sortie")
@Getter
@Setter
public class SortieMaModel {
    @Id
    private int id;
    @Column(name = "idmatiere")
    private int idmatiere;
    @Column(name = "quantite")
    private double quantite;
}
