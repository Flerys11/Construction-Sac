package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.DetailLookModel;
import com.example.Poketra30.Model.StatProdModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReposDetailLook extends JpaRepository<DetailLookModel, Integer> {
    @Query(value = "select * from v_get_Produit_Matiere where idlook = :idlook", nativeQuery = true)
    public List<DetailLookModel> maka(@Param("idlook") int idlook);
}
