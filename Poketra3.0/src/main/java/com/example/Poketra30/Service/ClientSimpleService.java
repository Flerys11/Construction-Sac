package com.example.Poketra30.Service;

import com.example.Poketra30.Model.ClientSimpleModel;
import com.example.Poketra30.Model.EmployeModel;
import com.example.Poketra30.Model.StockModel;
import com.example.Poketra30.Repos.ReposClientSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientSimpleService {

    private final ReposClientSimple reposClientSimple;

    @Autowired
    public ClientSimpleService(ReposClientSimple reposClientSimple) {
        this.reposClientSimple = reposClientSimple;
    }


    public ReposClientSimple getList() {
        return reposClientSimple;
    }

    public int generateUniqueId() {
        ClientSimpleModel clientSimpleModel = (ClientSimpleModel) reposClientSimple.findFirstByOrderByIdDesc();
        int nextId = 1;

        if (clientSimpleModel != null) {
            int lastId = Integer.parseInt(String.valueOf(clientSimpleModel.getId()));
            nextId = lastId + 1;
        }

        return nextId;
    }

    public void create(ClientSimpleModel clientSimpleModel) {
        //System.out.println(generateUniqueId());
        clientSimpleModel.setId(generateUniqueId());
        this.reposClientSimple.save(clientSimpleModel);
    }
}
