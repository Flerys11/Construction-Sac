package com.example.Poketra30.Service;
import com.example.Poketra30.Model.DetailProduitModel;
import com.example.Poketra30.Repos.ReposDetailProduit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailProduitService {
    private ReposDetailProduit reposDetailProduit;

    public DetailProduitService (ReposDetailProduit reposDetailProduit){

        this.reposDetailProduit = reposDetailProduit;
    }

    public List<DetailProduitModel> getList(){

        return reposDetailProduit.findAll();
    }

    public List<DetailProduitModel> getListD(int idp, int idl, int idt){
        return  reposDetailProduit.maka(idp, idl,idl);
    }
}
