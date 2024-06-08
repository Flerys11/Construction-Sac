package com.example.Poketra30.Controller;

import com.example.Poketra30.Model.*;
import com.example.Poketra30.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/createP")
public class CreateProduit {
    private  final ParametreMaService parametreMaService;
    private  final DetailProduitService detailProduitService;
    private final VenteService venteService;
    private final ProduitService produitService;
    private final LookService lookService;
    private  final TailleService tailleService;
    private final ResteMatiereService resteMatiereService;
    private final SortieMaService sortieMaService;
    private final ProduitCreeService produitCreeService;
    private final PourcGlobalService pourcGlobalService;
    private final StatProdService statProdService;

    private  final  ClientService clientService;

    public CreateProduit(ParametreMaService parametreMaService,
                         DetailProduitService detailProduitService, VenteService venteService,
                         ProduitService produitService, LookService lookService, TailleService tailleService,
                         ResteMatiereService resteMatiereService, SortieMaService sortieMaService,
                         ProduitCreeService produitCreeService, PourcGlobalService pourcGlobalService,
                         StatProdService statProdService, ClientService clientService) {

        this.parametreMaService = parametreMaService;
        this.detailProduitService = detailProduitService;
        this.venteService = venteService;
        this.produitService = produitService;
        this.lookService = lookService;
        this.tailleService = tailleService;
        this.resteMatiereService = resteMatiereService;
        this.sortieMaService = sortieMaService;
        this.produitCreeService = produitCreeService;
        this.pourcGlobalService = pourcGlobalService;
        this.statProdService = statProdService;
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public String getAfficheList(Model model) {
        List<DetailProduitModel> list = detailProduitService.getList();
        List<ClientModel> listC = clientService.getList();
        model.addAttribute("list", list);
        model.addAttribute("listC", listC);
       for (int i = 0; i<list.size(); i++){
           DetailProduitModel detailProduitModel = list.get(i);
           //System.out.println("valiny " + detailProduitModel.getIdproduit());
       }

        return "Produit/List";
    }

    @GetMapping("/page")
    public String getAffiche(Model model){
        try {
            List<ProduitModel> listP = produitService.getList();
            List<LookModel> listL = lookService.getList();
            List<TailleModel> listT = tailleService.getList();

            model.addAttribute("listP", listP);
            model.addAttribute("listL", listL);
            model.addAttribute("listT", listT);

            return "Produit/Create";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "Produit/Create";
        }
    }

    @PostMapping("/insert")
    public String create(@RequestParam("produit") String produit, @RequestParam("look") String look,
                         @RequestParam("taille") String taille, @RequestParam("quantite") String quantite,
                         Model model) throws Exception {

        try {
            int idl = Integer.parseInt(look);
            int t = Integer.parseInt(taille);
            int idp = Integer.parseInt(produit);
            double quant = Double.parseDouble(quantite);
            SortieMaModel sortieMaModel = new SortieMaModel();
            ProduitCreeModel produitCreeModel = new ProduitCreeModel();
            List<ParametreMaModel> param = parametreMaService.getlistbyId(idl, t);
            for (int i = 0; i < param.size(); i++) {
                double fin = param.get(i).getQuantite() * quant;
                int idM = param.get(i).getIdmatiere();
                List<RestMatiereModel> reste = resteMatiereService.getList();
                for (int j = 0; j < reste.size(); j++) {
                    if (reste.get(j).getIdmatiere() == idM && fin < reste.get(j).getQuantite_finaux()) {
                        sortieMaModel.setIdmatiere(reste.get(i).getIdmatiere());
                        sortieMaModel.setQuantite(fin);
                        produitCreeModel.setIdproduit(idp);
                        produitCreeModel.setIdlook(idl);
                        produitCreeModel.setIdtaille(t);
                        produitCreeModel.setQuantite(quant);
                        this.sortieMaService.create(sortieMaModel);
                        this.produitCreeService.create(produitCreeModel);
                    } else {
                        String matiereInsuffisante = "";
                        for (RestMatiereModel restMatiereModel : reste) {
                            if (restMatiereModel.getIdmatiere() == idM) {
                                matiereInsuffisante = restMatiereModel.getNom();
                                break;
                            }
                        }
                        throw new Exception("Quantité Insuffisante pour la matière : " + matiereInsuffisante);
                    }
                }
            }
            return "redirect:/createP/list";
        } catch (Exception e) {

            List<ProduitModel> listP = produitService.getList();
            List<LookModel> listL = lookService.getList();
            List<TailleModel> listT = tailleService.getList();
            model.addAttribute("listP", listP);
            model.addAttribute("listL", listL);
            model.addAttribute("listT", listT);
            model.addAttribute("errorMessage", e.getMessage());
            return "Produit/Create";
        }

    }




    @PostMapping("/insertVente")
    public String InsertV( @RequestParam("productId") String productId, @RequestParam("client") String client, @RequestParam("prix") String prix, @RequestParam("quantite") String quantite,
                           @RequestParam("date") String date, @RequestParam("lookId") String lookId, @RequestParam("tailleId") String tailleId , Model model) throws Exception {

        try {
            VenteModel venteModel = new VenteModel();
            int idproduit = Integer.parseInt(productId);
            int idclient = Integer.parseInt(client);
            int idlook = Integer.parseInt(lookId);
            int idtaille = Integer.parseInt(tailleId);
            double quatites = Double.parseDouble(quantite);
            //System.out.println("look "+idlook + " taille "+idtaille);
            List<DetailProduitModel> listD = detailProduitService.getListD(idproduit, idlook, idtaille);
            //System.out.println("listD "+ listD.get(0).getQuantitef());
            if(quatites <= listD.get(0).getQuantitef()){
                venteModel.setIdproduitcree(idproduit);
                venteModel.setIdclient(idclient);
                venteModel.setPrix_vente(Double.parseDouble(prix));
                venteModel.setQuantite_sortie(Integer.parseInt(quantite));
                String format = "yyyy-MM-dd";
                LocalDate datefin = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
                venteModel.setDate_achat(datefin);
                this.venteService.create(venteModel);

            }else {
                throw new Exception("Quantité Produit Insuffisante");
            }

            return "redirect:/createP/list";
        }catch (Exception e){
            List<DetailProduitModel> list = detailProduitService.getList();
            List<ClientModel> listC = clientService.getList();
            model.addAttribute("list", list);
            model.addAttribute("listC", listC);
            model.addAttribute("errorMessage", e.getMessage());
            return "Produit/List";
        }
    }

    @GetMapping("/statistique")
    public String listStat(Model model){
        List<PourcGlobModel> list = pourcGlobalService.getList();
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (PourcGlobModel pourcGlobModel : list) {
            labels.add(pourcGlobModel.getNom_genre());
            data.add(pourcGlobModel.getPourcentage_total());
        }
        model.addAttribute("list", list);
        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
        return "/Stat/List";
    }

    @GetMapping("/statP")
    public String listStatProd(@RequestParam("idproduit") String idproduit,Model model){
        //System.out.println("valin "+idproduit);
        List<StatProdModel> list = statProdService.getList(Integer.parseInt(idproduit));
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (StatProdModel statProdModel :list){
            labels.add(statProdModel.getNom_genre());
            data.add(statProdModel.getPourcentage_produit());
        }
        model.addAttribute("list", list);
        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
        return "/Stat/ListTrie";
    }


}
