package com.example.Poketra30.Service;

import com.example.Poketra30.Model.PourcGlobModel;
import com.example.Poketra30.Repos.ReposPourcGlobal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PourcGlobalService {
    private ReposPourcGlobal reposPourcGlobal;

    public PourcGlobalService(ReposPourcGlobal reposPourcGlobal){
        this.reposPourcGlobal = reposPourcGlobal;
    }

    public List<PourcGlobModel> getList(){
        return this.reposPourcGlobal.findAll();
    }

}
