package com.example.Poketra30.Service;

import com.example.Poketra30.Model.TailleModel;
import com.example.Poketra30.Repos.ReposTaille;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TailleService {
    private ReposTaille reposTaille;

    public TailleService(ReposTaille reposTaille){
        this.reposTaille = reposTaille;
    }

    public List<TailleModel> getList(){
        return this.reposTaille.findAll();
    }
}
