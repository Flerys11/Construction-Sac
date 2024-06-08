package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposStock extends JpaRepository<StockModel,Integer> {
    StockModel findFirstByOrderByIdDesc();

}
