package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.ParametreMaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReposParametreMa extends JpaRepository<ParametreMaModel,Integer> {
    @Query(value = "select * from v_get_Produit_Matiere where idLook = :idlook and taille = :taille", nativeQuery = true)
    public List<ParametreMaModel> maka(@Param("idlook") int idlook, @Param("taille") int taille);


    //List<ParametreMaModel> findByIdlookAndTaille(int idlook, int taille);
}
