package com.esprit.spring.controller;

import com.esprit.spring.entites.DetailCommande;
import com.esprit.spring.services.IDetailCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailcommande")
public class DetailCommandeRestController {
    @Autowired
    IDetailCommande detailCommandeService;
    //http://localhost:8081/springMVC/servlet/detailCommande/retrieve_all_detailCommandes
    @GetMapping("/retrieve_all_detailCommandes")
    @ResponseBody
    public List<DetailCommande> getDetailCommandes() {
        List<DetailCommande> detailCommandes = detailCommandeService.retrieveAllDetailCommandes();
        System.out.println(detailCommandes);
        return detailCommandes;
    }
    // http://localhost:8081/springMVC/servlet/detailCommande/add_detailCommande    
    @PostMapping("/add_detailCommande")
    @ResponseBody
    public DetailCommande addDetailCommande(@RequestBody DetailCommande c) {
        DetailCommande detailCommande = detailCommandeService.addDetailCommande(c);
        return detailCommande;
    }
    //http://localhost:8081/springMVC/servlet/detailCommande/retrieve_detailCommande/1
    @GetMapping("/retrieve_detailCommande/{detailCommande_id}")
    @ResponseBody
    public DetailCommande retrieveDetailCommande(@PathVariable("detailCommande_id") Long detailCommandeId) {
        return detailCommandeService.retrieveDetailCommande(detailCommandeId);
    }




    // http://localhost:8081/springMVC/servlet/detailCommande/remove-detailCommande/1
    @DeleteMapping("/remove-detailCommande/{detailCommande-id}")
    @ResponseBody
    public void removeDetailCommande(@PathVariable("detailCommande-id") Long detailCommandeId) {
        detailCommandeService.deleteDetailCommande(detailCommandeId);
    }

    // http://localhost:8081/springMVC/servlet/detailCommande/modify_detailCommande
    @PutMapping("/modify_detailCommande")
    @ResponseBody
    public DetailCommande modifyDetailCommande(@RequestBody DetailCommande detailCommande) {
        return detailCommandeService.updateDetailCommande(detailCommande);
    }

}
