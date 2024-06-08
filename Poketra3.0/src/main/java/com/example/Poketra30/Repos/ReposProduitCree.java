package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.ProduitCreeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposProduitCree extends JpaRepository<ProduitCreeModel, Integer> {
    ProduitCreeModel findFirstByOrderByIdDesc();
}
