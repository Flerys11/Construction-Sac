package com.example.Poketra30.Service;

import com.example.Poketra30.Model.ParametreMaModel;
import com.example.Poketra30.Repos.ReposParametreMa;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametreMaService {
    private ReposParametreMa reposParametreMa;

    public ParametreMaService(ReposParametreMa reposParametreMa) {
        this.reposParametreMa = reposParametreMa;
    }

    public List<ParametreMaModel> getlistbyId(int idlook, int taille){
        return this.reposParametreMa.maka(idlook, taille);
    }



}
