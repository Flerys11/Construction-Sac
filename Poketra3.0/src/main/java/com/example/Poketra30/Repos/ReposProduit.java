package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.ProduitModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposProduit extends JpaRepository<ProduitModel,Integer> {
    ProduitModel findFirstByOrderByIdproduit();
}
