package com.esprit.spring.controller;

import com.esprit.spring.entites.LigneFournisseur;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.services.ILigneFournisseur;
import com.esprit.spring.services.IStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LigneFournisseur")
public class LigneFournisseurRestController {
    @Autowired
    ILigneFournisseur ligneFournisseurService;

    //http://localhost:8081/springMVC/servlet/ligneFournisseur/retrieve_all_ligneFournisseurs
    @GetMapping("/retrieve_all_ligneFournisseurs")
    @ResponseBody
    public List<LigneFournisseur> getLigneFournisseurs() {
        List<LigneFournisseur> ligneFournisseurs = ligneFournisseurService.retrieveAllLigneFournisseurs();
        System.out.println(ligneFournisseurs);
        return ligneFournisseurs;
    }
    // http://localhost:8081/springMVC/servlet/ligneFournisseur/add_ligneFournisseur
    @PostMapping("/add_ligneFournisseur")
    @ResponseBody
    public LigneFournisseur addLigneFournisseur(@RequestBody LigneFournisseur c) {
        LigneFournisseur ligneFournisseur = ligneFournisseurService.addLigneFournisseur(c);
        return ligneFournisseur;
    }
    //http://localhost:8081/springMVC/servlet/ligneFournisseur/retrieve_ligneFournisseur/1
    @GetMapping("/retrieve_ligneFournisseur/{ligneFournisseur_id}")
    @ResponseBody
    public LigneFournisseur retrieveLigneFournisseur(@PathVariable("ligneFournisseur_id") Long ligneFournisseurId) {
        return ligneFournisseurService.retrieveLigneFournisseur(ligneFournisseurId);
    }




    // http://localhost:8081/springMVC/servlet/ligneFournisseur/remove-ligneFournisseur/1
    @DeleteMapping("/remove-ligneFournisseur/{ligneFournisseur-id}")
    @ResponseBody
    public void removeLigneFournisseur(@PathVariable("ligneFournisseur-id") Long ligneFournisseurId) {
        ligneFournisseurService.deleteLigneFournisseur(ligneFournisseurId);
    }

    // http://localhost:8081/springMVC/servlet/ligneFournisseur/modify_ligneFournisseur
    @PutMapping("/modify_ligneFournisseur")
    @ResponseBody
    public LigneFournisseur modifyLigneFournisseur(@RequestBody LigneFournisseur ligneFournisseur) {
        return ligneFournisseurService.updateLigneFournisseur(ligneFournisseur);
    }
    

}
