package com.example.Poketra30.Controller;

import com.example.Poketra30.Model.*;
import com.example.Poketra30.Service.ClientService;
import com.example.Poketra30.Service.ClientSimpleService;
import com.example.Poketra30.Service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/client")
public class Client {
    private final GenreService genreService;
    private  final ClientService clientService;
    private final  ClientSimpleService clientSimpleService;


    public Client(GenreService genreService, ClientService clientService, ClientSimpleService clientSimpleService) {
        this.genreService = genreService;
        this.clientService = clientService;
        this.clientSimpleService = clientSimpleService;

    }

    @GetMapping("/list")
    public String list(Model model){
        List<GenreModel> list = genreService.getlist();
        List<ClientModel> listClient = clientService.getList();
        model.addAttribute("list" ,list);
        model.addAttribute("listClient" ,listClient);
        return "Client/List";
    }

    @PostMapping("/insert")
    public String create(@RequestParam("nom") String  nom, @RequestParam("genre") String  genre) {
        ClientSimpleModel clientSimpleModel = new ClientSimpleModel();
        clientSimpleModel.setNom(nom);
        clientSimpleModel.setGenre(Integer.parseInt(genre));
        //System.out.println("nom " + nom + "genre" + Integer.parseInt(genre));
        this.clientSimpleService.create(clientSimpleModel);
        return "redirect:/client/list";
    }
}
