package com.example.Poketra30.Controller;

import com.example.Poketra30.Model.DetailEmployeModel;
import com.example.Poketra30.Model.EmployeModel;
import com.example.Poketra30.Service.DetailEmployeService;
import com.example.Poketra30.Service.EmployeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/employe")
public class Employe {

    private final EmployeService employeService;
    private  final DetailEmployeService detailEmployeService;

    public Employe(EmployeService employeService, DetailEmployeService detailEmployeService) {
        this.employeService = employeService;
        this.detailEmployeService = detailEmployeService;
    }

    @GetMapping("/list")
    public String getListEmploye(Model model){
        //List<EmployeModel> list = employeService.getList();
        List<DetailEmployeModel> list = detailEmployeService.getList();
        model.addAttribute("list" ,list);
    return "Employe/List";
    }

    @PostMapping("/insert")
    public String insertEmploye(@RequestParam("nom") String nom, @RequestParam("fonction") String fonction, @RequestParam("date") String date) {
        //int idfonction = Integer.parseInt(fonction);
        String format = "yyyy-MM-dd";
        LocalDate datefin = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
        EmployeModel employeModel = new EmployeModel();
        employeModel.setNom(nom);
        employeModel.setIdfonction(Integer.parseInt(fonction));
        employeModel.setDate_embauche(datefin);
        this.employeService.create(employeModel);
        return "redirect:/employe/list";
    }
}
