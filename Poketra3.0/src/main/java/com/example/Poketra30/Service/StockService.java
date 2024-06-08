package com.example.Poketra30.Service;

import com.example.Poketra30.Model.StockModel;
import com.example.Poketra30.Repos.ReposStock;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockService {
    private ReposStock reposStock;

    public StockService(ReposStock reposStock) {

        this.reposStock = reposStock;
    }

    public List<StockModel> getList(){

        return this.reposStock.findAll();
    }

    public int generateUniqueId() {
        StockModel stockModel = reposStock.findFirstByOrderByIdDesc();
        int nextId = 1;

        if (stockModel != null) {
            int lastId = Integer.parseInt(String.valueOf(stockModel.getId()));
            nextId = lastId + 1;
        }

        return nextId;
    }

    public void create(StockModel stockModel){

        //System.out.println(stockModel.getIdmatiere() + stockModel.getQuantite() + stockModel.getPrix_unitaire());
        //System.out.println(stockModel.getQuantite());
        stockModel.setId(generateUniqueId());

        this.reposStock.save(stockModel);
    }
}
