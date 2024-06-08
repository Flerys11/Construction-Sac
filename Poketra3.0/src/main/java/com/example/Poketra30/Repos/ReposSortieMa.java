package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.SortieMaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposSortieMa extends JpaRepository<SortieMaModel, Integer> {
    SortieMaModel findFirstByOrderByIdDesc();
}
