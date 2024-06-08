package com.example.Poketra30.Service;

import com.example.Poketra30.Model.EmployeModel;
import com.example.Poketra30.Repos.ReposEmploye;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeService {
    private ReposEmploye reposEmpoye;


    public EmployeService (ReposEmploye reposEmpoye) {

        this.reposEmpoye = reposEmpoye;
    }

    public List<EmployeModel> getList(){
        return this.reposEmpoye.findAll();
    }

    public String generateUniqueId() {
        String prefix = "EMP";
        int paddingSize = 3;
        EmployeModel employeModel = reposEmpoye.findFirstByOrderByIdemployeDesc();
        int lastId = (employeModel != null) ? Integer.parseInt(employeModel.getIdemploye().substring(prefix.length())) : 0;
        int nextId = lastId + 1;
        String formattedId = String.format("%s%0" + paddingSize + "d", prefix, nextId);
        return formattedId;
    }

    public void create(EmployeModel employeModel){
        //System.out.println(generateUniqueId());
        employeModel.setIdemploye(generateUniqueId());

        //System.out.println(employeModel.getNom() + employeModel.getDate_embauche());
        this.reposEmpoye.save(employeModel);
    }

}
