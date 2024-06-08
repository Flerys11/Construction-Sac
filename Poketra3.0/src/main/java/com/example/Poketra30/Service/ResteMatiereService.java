package com.example.Poketra30.Service;

import com.example.Poketra30.Model.RestMatiereModel;
import com.example.Poketra30.Repos.ReposResteMatiere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResteMatiereService {
    private ReposResteMatiere reposResteMatiere;

    public ResteMatiereService(ReposResteMatiere reposResteMatiere){
        this.reposResteMatiere = reposResteMatiere;
    }

    public List<RestMatiereModel> getList(){
        return this.reposResteMatiere.findAll();
    }
}
