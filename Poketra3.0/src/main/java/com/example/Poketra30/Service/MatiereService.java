package com.example.Poketra30.Service;

import com.example.Poketra30.Model.MatiereModel;
import com.example.Poketra30.Repos.ReposMatiere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    private ReposMatiere reposMatiere;

    public MatiereService(ReposMatiere reposMatiere) {
        this.reposMatiere = reposMatiere;
    }

    public List<MatiereModel> getList(){
        return this.reposMatiere.findAll();
    }
}
