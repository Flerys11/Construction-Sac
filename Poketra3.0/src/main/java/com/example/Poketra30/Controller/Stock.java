package com.example.Poketra30.Controller;

import com.example.Poketra30.Model.MatiereModel;
import com.example.Poketra30.Model.StockModel;
import com.example.Poketra30.Service.MatiereService;
import com.example.Poketra30.Service.ProduitService;
import com.example.Poketra30.Service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/stock")
public class Stock {

    private StockService stockService;
    private ProduitService produitService;
    private MatiereService matiereService;

    public Stock(StockService stockService, ProduitService produitService, MatiereService matiereService) {

        this.stockService = stockService;
        this.produitService = produitService;
        this.matiereService = matiereService;
    }

    @GetMapping("/insert")
    public String getListAll(Model model){
        //List<StockModel> result = stockService.getList();
        //model.addAttribute("result" ,result);
        //List<ProduitModel> result = produitService.getList();
        List<MatiereModel> resultM = matiereService.getList();
        model.addAttribute("resultM", resultM);
        return "Matiere/InsertStock";
    }

    @PostMapping("/stockInsert")
    public String insertMa(@RequestParam("matiere") String matiere, @RequestParam("quantite") String quantite, @RequestParam("pu" ) String pu, @RequestParam("date") String date){

        StockModel stockModel = new StockModel();
        stockModel.setIdmatiere(Integer.parseInt(matiere));
        stockModel.setQuantite(Integer.parseInt(quantite));
        stockModel.setPrix_unitaire(Double.parseDouble(pu));

        String format = "yyyy-MM-dd";
        LocalDate datefin = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
        stockModel.setDate_reception(datefin);
        this.stockService.create(stockModel);
        return "redirect:/stock/insert";
        //return null;

    }

}
