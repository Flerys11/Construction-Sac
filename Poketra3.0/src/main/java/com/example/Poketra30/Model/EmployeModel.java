package com.example.Poketra30.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employe")
@Getter
@Setter
public class EmployeModel {

    @Id
    private String idemploye;
    @Column(name = "nom")
    private  String nom;
    //@OneToOne
    //@JoinColumn(name = "fonctionModel")
    //private FonctionModel fonctionModel;
    @Column(name = "idfonction")
    private int idfonction;
    @Column(name = "date_embauche")
    private LocalDate date_embauche;

}


