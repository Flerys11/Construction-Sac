package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.ParametreMaModel;
import com.example.Poketra30.Model.StatProdModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReposStatProd extends JpaRepository<StatProdModel, Integer> {
    @Query(value = "select * from v_get_Stat_Pro where idproduitcree = :idproduit", nativeQuery = true)
    public List<StatProdModel> maka(@Param("idproduit") int idproduit);
}
