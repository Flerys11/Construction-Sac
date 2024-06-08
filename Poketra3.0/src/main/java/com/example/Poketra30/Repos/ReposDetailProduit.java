package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.DetailLookModel;
import com.example.Poketra30.Model.DetailProduitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReposDetailProduit extends JpaRepository<DetailProduitModel, Integer> {

    @Query(value = "select * from v_prod_creer_finaux1 where idproduit = :idproduit and idlook = :idlook and idtaille = :idtaille", nativeQuery = true)
    public List<DetailProduitModel> maka(@Param("idproduit") int idproduit,@Param("idlook") int idlook, @Param("idtaille") int idtaille);

}
