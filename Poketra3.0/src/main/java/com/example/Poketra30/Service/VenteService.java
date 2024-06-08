package com.example.Poketra30.Service;

import com.example.Poketra30.Model.ClientSimpleModel;
import com.example.Poketra30.Model.VenteModel;
import com.example.Poketra30.Repos.ReposVente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    private ReposVente reposVente;
    private ClientSimpleService clientSimpleService;

    public VenteService (ReposVente reposVente){
        this.reposVente = reposVente;
    }

    public int generateUniqueId() {
        VenteModel venteModel = reposVente.findFirstByOrderByIdDesc();
        int nextId = 1;
        if (venteModel != null) {
            int lastId = Integer.parseInt(String.valueOf(venteModel.getId()));
            nextId = lastId + 1;
        }

        return nextId;
    }

    public void create(VenteModel venteModel) {
        venteModel.setId(generateUniqueId());
        this.reposVente.save(venteModel);
    }
}
