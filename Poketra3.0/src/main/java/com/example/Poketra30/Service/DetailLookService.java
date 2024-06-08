package com.example.Poketra30.Service;

import com.example.Poketra30.Model.DetailLookModel;
import com.example.Poketra30.Repos.ReposDetailLook;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public class DetailLookService {
    private ReposDetailLook reposDetailLook;

    public DetailLookService(ReposDetailLook reposDetailLook){
        this.reposDetailLook = reposDetailLook;
    }

    public List<DetailLookModel> getList(int idlook){
        return this.reposDetailLook.maka(idlook);
    }
}
