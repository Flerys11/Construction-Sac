package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.BeneficeModel;
import com.example.Poketra30.Model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReposBenefice extends JpaRepository<BeneficeModel, Integer> {

    @Query(value = "SELECT * FROM v_GetBenf ", nativeQuery = true)
    List<BeneficeModel> maka();

    @Query(value = "SELECT * FROM v_GetBenf WHERE benefice BETWEEN :minValue AND :maxValue", nativeQuery = true)
    List<BeneficeModel> makaTrie(@Param("minValue") double minValue, @Param("maxValue") double maxValue);
}
