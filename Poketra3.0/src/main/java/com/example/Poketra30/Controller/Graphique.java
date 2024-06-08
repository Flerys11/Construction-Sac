package com.example.Poketra30.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stat")
public class Graphique {

    @GetMapping("/list")
    public String getList(){
        return "Stat/List";
    }
}
