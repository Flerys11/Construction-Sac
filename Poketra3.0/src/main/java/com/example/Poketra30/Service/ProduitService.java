package com.example.Poketra30.Service;

import com.example.Poketra30.Model.ProduitModel;
import com.example.Poketra30.Repos.ReposProduit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    private ReposProduit reposProduit;

    public ProduitService(ReposProduit reposProduit) {
        this.reposProduit = reposProduit;
    }

    public List<ProduitModel> getList(){
        return this.reposProduit.findAll();
    }

}
