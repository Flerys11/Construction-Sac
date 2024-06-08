package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.ClientSimpleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReposClientSimple extends JpaRepository<ClientSimpleModel, Integer> {
    @Query(value = "select * from client", nativeQuery = true)
    public List<ReposClientSimple> findone();

    ClientSimpleModel findFirstByOrderByIdDesc();
}
