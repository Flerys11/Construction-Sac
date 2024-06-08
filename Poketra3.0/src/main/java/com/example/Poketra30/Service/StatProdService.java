package com.example.Poketra30.Service;

import com.example.Poketra30.Model.StatProdModel;
import com.example.Poketra30.Repos.ReposStatProd;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatProdService {
    private ReposStatProd reposStatProd;

    public StatProdService(ReposStatProd reposStatProd){
        this.reposStatProd = reposStatProd;
    }

    public List<StatProdModel> getList(int idproduit){
        return this.reposStatProd.maka(idproduit);
    }
}
