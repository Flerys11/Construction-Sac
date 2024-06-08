package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReposClient extends JpaRepository<ClientModel, Integer> {
    //ClientModel find();
    @Query(value = "select * from v_getClient", nativeQuery = true)
    public List<ClientModel> findone();
}
