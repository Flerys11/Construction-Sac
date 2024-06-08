package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.MatiereModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposMatiere extends JpaRepository<MatiereModel, Integer> {
    MatiereModel findFirstByOrderByIdmatiereDesc();
}
