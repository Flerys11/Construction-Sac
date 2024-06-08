package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.DetailEmployeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposDetailEmploye extends JpaRepository<DetailEmployeModel, String> {
    DetailEmployeModel findFirstByOrderByIdemployeDesc();
}
