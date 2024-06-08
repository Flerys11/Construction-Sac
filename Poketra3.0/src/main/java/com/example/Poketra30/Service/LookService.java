package com.example.Poketra30.Service;

import com.example.Poketra30.Model.LookModel;
import com.example.Poketra30.Model.VenteModel;
import com.example.Poketra30.Repos.ReposLook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookService {
    private ReposLook reposLook;

    public LookService(ReposLook reposLook){
        this.reposLook = reposLook;
    }

    public List<LookModel> getList(){
        return this.reposLook.findAll();
    }

    public int generateUniqueId() {
        LookModel lookModel = reposLook.findFirstByOrderByIdlookDesc();
        int nextId = 1;
        if (lookModel != null) {
            int lastId = Integer.parseInt(String.valueOf(lookModel.getIdlook()));
            nextId = lastId + 1;
        }

        return nextId;
    }

    public void create(LookModel lookModel) {
        lookModel.setIdlook(generateUniqueId());
        this.reposLook.save(lookModel);
    }
}
