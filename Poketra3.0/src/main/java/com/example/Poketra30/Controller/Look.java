package com.example.Poketra30.Controller;

import com.example.Poketra30.Model.DetailLookModel;
import com.example.Poketra30.Model.LookModel;
import com.example.Poketra30.Service.DetailLookService;
import com.example.Poketra30.Service.LookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/look")
public class Look {
    private final LookService lookService;
    private final DetailLookService detailLookService;

    public Look(LookService lookService, DetailLookService detailLookService) {
        this.lookService = lookService;
        this.detailLookService = detailLookService;
    }

    @GetMapping("/list")
    public String getAffch(Model model){
        List<LookModel> list = lookService.getList();
        model.addAttribute("list", list);
        return "Look/List";
    }

    @PostMapping("/insert")
    public String insertLook(@RequestParam("nom") String nom){
        LookModel lookModel = new LookModel();
        lookModel.setNom(nom);
        this.lookService.create(lookModel);
        return "redirect:/look/list";
    }

    @GetMapping("/details")
    public String getDet(@RequestParam("idlook") String idlook, Model model){
        System.out.println(idlook);
        List<DetailLookModel> list = detailLookService.getList(Integer.parseInt(idlook));
        model.addAttribute("list" ,list);
        return "/Look/Detail";
    }

}
