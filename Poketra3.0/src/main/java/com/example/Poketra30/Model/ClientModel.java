package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_getClient")
@Getter
@Setter
public class ClientModel {
    @Id
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "genre")
    private  int genre;
    @Column(name = "nom_genre")
    private  String nom_genre;
}
