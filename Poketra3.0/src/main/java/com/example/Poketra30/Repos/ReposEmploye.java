package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.EmployeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposEmploye extends JpaRepository<EmployeModel,String> {
    EmployeModel findFirstByOrderByIdemployeDesc();
}
