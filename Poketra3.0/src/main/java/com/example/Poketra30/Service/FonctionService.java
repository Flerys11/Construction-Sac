package com.example.Poketra30.Service;

import com.example.Poketra30.Model.FonctionModel;
import com.example.Poketra30.Repos.ReposFonction;

import java.util.List;

public class FonctionService {
    private ReposFonction reposFonction;

    public FonctionService (ReposFonction reposFonction) {
        this.reposFonction = reposFonction;
    }

    public List<FonctionModel> getList(){
        return this.reposFonction.findAll();
    }
}
