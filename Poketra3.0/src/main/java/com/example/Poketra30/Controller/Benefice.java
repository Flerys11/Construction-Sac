package com.example.Poketra30.Controller;

import com.example.Poketra30.Model.BeneficeModel;
import com.example.Poketra30.Service.BeneficeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class Benefice {
    private final BeneficeService beneficeService;

    public Benefice (BeneficeService beneficeService){
        this.beneficeService = beneficeService;
    }

    @GetMapping("/")
    public String  getAffich(Model model ){
        List<BeneficeModel> list = beneficeService.getListByLookId();

       /* for (int i = 0; i< list.size(); i++){
            System.out.println("valiny "+ list.get(i).getTaille());
        }*/
        model.addAttribute("list", list);
       return "Benefice/List";
       // return "ato";
    }

    @PostMapping("/trie")
    public String getTrie(Model model, @RequestParam("min") String min , @RequestParam("max") String max){
        double minf = Double.parseDouble(min);
        double maxf = Double.parseDouble(max);
        List<BeneficeModel> list = beneficeService.getListByBeneficeRange(minf,maxf);
        /* for (int i = 0; i< list.size(); i++){
            System.out.println("valiny "+ list.get(i).getBenefice());
        }*/
        model.addAttribute("list",list);
        return "Benefice/List";
    }


}
