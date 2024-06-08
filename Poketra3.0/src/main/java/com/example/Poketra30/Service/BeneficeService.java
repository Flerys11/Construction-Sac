package com.example.Poketra30.Service;

import com.example.Poketra30.Model.BeneficeModel;
import com.example.Poketra30.Repos.ReposBenefice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficeService {

    public ReposBenefice reposBenefice;

    public BeneficeService(ReposBenefice reposBenefice){
        this.reposBenefice = reposBenefice;
    }

    public List<BeneficeModel> getListByLookId() {
        return reposBenefice.findAll();
    }

    public List<BeneficeModel> getListByBeneficeRange(double minValue, double maxValue) {
        return reposBenefice.makaTrie(minValue, maxValue);
    }
}
