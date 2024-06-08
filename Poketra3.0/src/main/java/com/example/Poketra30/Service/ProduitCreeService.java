package com.example.Poketra30.Service;

import com.example.Poketra30.Model.ProduitCreeModel;
import com.example.Poketra30.Model.VenteModel;
import com.example.Poketra30.Repos.ReposProduitCree;
import org.springframework.stereotype.Service;

@Service
public class ProduitCreeService {
    private ReposProduitCree reposProduitCree;

    public ProduitCreeService(ReposProduitCree reposProduitCree){
        this.reposProduitCree = reposProduitCree;
    }

    public int generateUniqueId() {
        ProduitCreeModel produitCreeModel = reposProduitCree.findFirstByOrderByIdDesc();
        int nextId = 1;
        if (produitCreeModel != null) {
            int lastId = Integer.parseInt(String.valueOf(produitCreeModel.getId()));
            nextId = lastId + 1;
        }

        return nextId;
    }

    public void create(ProduitCreeModel produitCreeModel) {
        produitCreeModel.setId(generateUniqueId());
        this.reposProduitCree.save(produitCreeModel);
    }
}
