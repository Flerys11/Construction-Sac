package com.example.Poketra30.Service;

import com.example.Poketra30.Model.GenreModel;
import com.example.Poketra30.Repos.ReposGenre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private ReposGenre reposGenre;

    public GenreService(ReposGenre reposGenre) {
        this.reposGenre = reposGenre;
    }

    public List<GenreModel> getlist(){
        return this.reposGenre.findone();
    }
}
