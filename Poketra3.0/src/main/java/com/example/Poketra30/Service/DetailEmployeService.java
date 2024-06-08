package com.example.Poketra30.Service;

import com.example.Poketra30.Model.DetailEmployeModel;
import com.example.Poketra30.Repos.ReposDetailEmploye;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailEmployeService {

    private ReposDetailEmploye reposDetailEmploye;

    public DetailEmployeService(ReposDetailEmploye reposDetailEmploye) {
        this.reposDetailEmploye = reposDetailEmploye;
    }

    public  List<DetailEmployeModel> getList(){
        return this.reposDetailEmploye.findAll();
    }
}
