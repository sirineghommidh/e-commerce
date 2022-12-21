package com.esprit.spring.controller;

import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.repository.ProduitRepository;
import com.esprit.spring.services.DetailCommandeServiceImpl;
import com.esprit.spring.services.IDetailProduit;
import com.esprit.spring.services.IProduit;
import com.esprit.spring.services.IStock;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ProduitRestController {
    @Autowired
    IProduit produitService;

    @Autowired
    IStock stockService;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    IDetailProduit detailProduitService;

    // http://localhost:8081/retrieve-all-produits
    @GetMapping("/retrieve-all-produits")
    @ResponseBody
    public List<Produit> getProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        return listProduits;
    }

    // http://localhost:8081/SpringMVC/servlet/add-produit
    @PostMapping("/add-produit")
    @ResponseBody
    public Produit addProduit(@RequestBody Produit p){
        Produit produit = produitService.addProduit(p);
        return produit;
    }

    // http://localhost:8081/retrieve-produit/2
    @GetMapping("/retrieve-produit/{produit-id}")
    @ResponseBody
    public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
        return produitService.retrieveProduit(produitId);
    }


    // http://localhost:8081/SpringMVC/servlet/remove-client/{client-id}
    @DeleteMapping("/remove-produit/{produit-id}")
    @ResponseBody
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        produitService.deleteProduit(produitId);
    }

    // http://localhost:8081/SpringMVC/servlet/modify-produit
    @PutMapping("/modify-produit")
    @ResponseBody
    public Produit modifyClient(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }

    //http://localhost:8081/SpringMVC/servlet/add-etoile/{produit-id}/{client-id}/{rev}
    @GetMapping ("/add-etoile/{produit-id}/{client-id}/{rev}")
    @ResponseBody
    public void moyEtoile(@PathVariable("produit-id") Long produitId,@PathVariable("client-id") Long clientId,@PathVariable("rev") Double rev ){
        produitService.calculeEtoile(rev, produitId, clientId);
    }

    // http://localhost:8081/ret/{categ}/{prixmin}/{prixmax}/{libelle}/{etoile}
    @GetMapping("/ret/{categ}/{prixmin}/{prixmax}/{libelle}/{etoile}")
    @ResponseBody
    public Set<Produit> ret(@PathVariable("categ") String categ, @PathVariable("prixmin") float prixmin, @PathVariable("prixmax") float prixmax, @PathVariable("libelle") String libelle, @PathVariable("etoile") Double etoile){

        return produitService.rechercheAv(categ, prixmin,prixmax,libelle,etoile);
    }

    // http://localhost:8081/affecteProduitToStock/{produit-id}/{stock-id}
    @PutMapping("/affecteProduitToStock/{produit-id}/{stock-id}")
    @ResponseBody
    public Produit affectProduitToStock(@PathVariable("produit-id") Long idProduit ,@PathVariable("stock-id")  Long idStock) {
        Produit p=this.retrieveProduit(idProduit);
       Stock stock= stockService.retrieveStock(idStock);
        p.setStock(stock);
        return   produitService.updateProduit(p);
    }

    // http://localhost:8081/idmax
    @GetMapping("/idmax")
    @ResponseBody
    public Long retrieveProduit() {
        return produitRepository.idmaxprod();
    }

    // http://localhost:8081/affecteProduitToStock/{produit-id}/{det-id}
    @GetMapping("/affectedetailProduitToProduit/{produit-id}/{det-id}")
    @ResponseBody
    public Produit affectProduitTodet(@PathVariable("produit-id") Long idProduit ,@PathVariable("det-id")  Long iddet) {
        Produit p=this.retrieveProduit(idProduit);
        DetailProduit det= detailProduitService.retrieveDetailProduit(iddet);
        p.setDetailProduit(det);
        return   produitService.updateProduit(p);
    }
}
