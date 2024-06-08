package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "matiere")
@Getter
@Setter
public class MatiereModel {
    @Id
    private  int idmatiere;
    @Column(name = "nom")
    private  String nom;

}
