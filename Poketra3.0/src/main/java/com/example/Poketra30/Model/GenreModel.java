package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genreClient")
@Getter
@Setter
public class GenreModel {
    @Id
    private int id;
    @Column(name = "nom")
    private String nom;
}
