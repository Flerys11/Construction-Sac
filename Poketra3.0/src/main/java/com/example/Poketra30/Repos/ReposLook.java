package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.LookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposLook extends JpaRepository<LookModel,Integer> {
    LookModel findFirstByOrderByIdlookDesc();
}
