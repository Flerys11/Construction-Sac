package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.StockMatiereModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposStockMatiere extends JpaRepository<StockMatiereModel, Integer> {
    StockMatiereModel findFirstByOrderByIdmatiereDesc();
}
