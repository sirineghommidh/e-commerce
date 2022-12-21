package com.esprit.spring.controller;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.repository.DetailProduitRepository;
import com.esprit.spring.repository.ProduitRepository;
import com.esprit.spring.services.ICategorieProduit;
import com.esprit.spring.services.IDetailProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DetailProduitRestController {
    @Autowired
    IDetailProduit detailProduitService;

    @Autowired
    DetailProduitRepository detailProduitRepository;
    @Autowired
    ICategorieProduit categorieProduitService;

    //http://localhost:8081/springMVC/servlet/detailProduit/retrieve_all_detailProduits
    @GetMapping("/retrieve_all_detailProduits")
    @ResponseBody
    public List<DetailProduit> getDetailProduits() {
        List<DetailProduit> detailProduits = detailProduitService.retrieveAllDetailProduits();
        System.out.println(detailProduits);
        return detailProduits;
    }
    // http://localhost:8081/springMVC/servlet/detailProduit/add_detailProduit
    @PostMapping("/add_detailProduit")
    @ResponseBody
    public DetailProduit addDetailProduit(@RequestBody DetailProduit c) {
        DetailProduit detailProduit = detailProduitService.addDetailProduit(c);
        return detailProduit;
    }
    //http://localhost:8081/springMVC/servlet/detailProduit/retrieve_detailProduit/1
    @GetMapping("/retrieve_detailProduit/{detailProduit_id}")
    @ResponseBody
    public DetailProduit retrieveDetailProduit(@PathVariable("detailProduit_id") Long detailProduitId) {
        return detailProduitService.retrieveDetailProduit(detailProduitId);
    }




    // http://localhost:8081/springMVC/servlet/detailProduit/remove-detailProduit/1
    @DeleteMapping("/remove-detailProduit/{detailProduit-id}")
    @ResponseBody
    public void removeDetailProduit(@PathVariable("detailProduit-id") Long detailProduitId) {
        detailProduitService.deleteDetailProduit(detailProduitId);
    }

    // http://localhost:8081/springMVC/servlet/detailProduit/modify_detailProduit
    @PutMapping("/modify_detailProduit")
    @ResponseBody
    public DetailProduit modifyDetailProduit(@RequestBody DetailProduit detailProduit) {
        return detailProduitService.updateDetailProduit(detailProduit);
    }

    // http://localhost:8081/idmaxdet
    @GetMapping("/idmaxdet")
    @ResponseBody
    public Long retrieveProduit() {
        return detailProduitRepository.idmaxdetprod();
    }


    // http://localhost:8081/affecteProduitToStock/{produit-id}/{det-id}
    @GetMapping("/affectedetaildetaiProduitTocateg/{detproduit-id}/{categ-id}")
    @ResponseBody
    public DetailProduit affectProduitTodet(@PathVariable("detproduit-id") Long iddet , @PathVariable("categ-id")  Long idcateg) {
        CategorieProduit c=categorieProduitService.retrieveCategorieProduit(idcateg);
        DetailProduit det= this.retrieveDetailProduit(iddet);
        det.setCategorieProduit(c);
        return   detailProduitService.updateDetailProduit(det);
    }
}
