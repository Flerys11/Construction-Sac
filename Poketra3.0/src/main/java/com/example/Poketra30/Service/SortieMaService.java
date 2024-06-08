package com.example.Poketra30.Service;

import com.example.Poketra30.Model.SortieMaModel;
import com.example.Poketra30.Model.VenteModel;
import com.example.Poketra30.Repos.ReposSortieMa;
import org.springframework.stereotype.Service;

@Service
public class SortieMaService {
    private ReposSortieMa reposSortieMa;

    public SortieMaService(ReposSortieMa reposSortieMa){
        this.reposSortieMa = reposSortieMa;
    }

    public int generateUniqueId() {
        SortieMaModel sortieMaModel = reposSortieMa.findFirstByOrderByIdDesc();
        int nextId = 1;
        if (sortieMaModel != null) {
            int lastId = Integer.parseInt(String.valueOf(sortieMaModel.getId()));
            nextId = lastId + 1;
        }

        return nextId;
    }

    public void create(SortieMaModel sortieMaModel) {
        sortieMaModel.setId(generateUniqueId());
        this.reposSortieMa.save(sortieMaModel);
    }
}
