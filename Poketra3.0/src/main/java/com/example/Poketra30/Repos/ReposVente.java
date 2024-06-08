package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.VenteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposVente extends JpaRepository<VenteModel, Integer> {

    VenteModel findFirstByOrderByIdDesc();
}
