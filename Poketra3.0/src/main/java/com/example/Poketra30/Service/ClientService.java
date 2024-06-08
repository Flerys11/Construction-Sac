package com.example.Poketra30.Service;

import com.example.Poketra30.Model.ClientModel;
import com.example.Poketra30.Repos.ReposClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ReposClient reposClient;

    public ClientService(ReposClient reposClient) {
        this.reposClient = reposClient;
    }

    public List<ClientModel> getList(){

        return this.reposClient.findone();
    }
}
