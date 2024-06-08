package com.example.Poketra30.Service;

import com.example.Poketra30.Model.StockMatiereModel;
import com.example.Poketra30.Repos.ReposStockMatiere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMatiereService {
    private ReposStockMatiere reposStockMatiere;

    public StockMatiereService(ReposStockMatiere reposStockMatiere) {
        this.reposStockMatiere = reposStockMatiere;
    }

    public List<StockMatiereModel> getList(){
        return  this.reposStockMatiere.findAll();
        }
}
