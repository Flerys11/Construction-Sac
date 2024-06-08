package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.FonctionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReposFonction extends JpaRepository<FonctionModel, Integer> {
    List<FonctionModel> findAll();
}
