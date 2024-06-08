package com.example.Poketra30.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v_get_salemp")
@Getter
@Setter
public class DetailEmployeModel {
    @Id
    private  String idemploye;
    @Column(name = "annee")
    private  double annee;
    @Column(name = "nom")
    private  String nom;
    @Column(name = "salaire")
    private  double salaire;
    @Column(name = "nom_coeffi")
    private  String nom_coeffi;

}
