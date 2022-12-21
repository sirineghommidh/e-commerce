package com.esprit.spring.controller;

import com.esprit.spring.entites.Fournisseur;
import com.esprit.spring.services.IFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/fournisseur")
public class FournisseurRestController {
    //TEST
    @Autowired
    IFournisseur fournisseurService;
    //http://localhost:8081/springMVC/servlet/fournisseur/retrieve_all_fournisseurs
    @GetMapping("/retrieve_all_fournisseurs")
    @ResponseBody
    public List<Fournisseur> getFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.retrieveAllFournisseurs();
        System.out.println(fournisseurs);
        return fournisseurs;
    }
    // http://localhost:8081/fournisseur/add_fournisseur
    @PostMapping("/add_fournisseur")
    @ResponseBody
    public Fournisseur addFournisseur(@RequestBody Fournisseur c) {
        Fournisseur fournisseur = fournisseurService.addFournisseur(c);
        return fournisseur;
    }
    //http://localhost:8081/springMVC/servlet/fournisseur/retrieve_fournisseur/1
    @GetMapping("/retrieve_fournisseur/{fournisseur_id}")
    @ResponseBody
    public Fournisseur retrieveFournisseur(@PathVariable("fournisseur_id") Long fournisseurId) {
        return fournisseurService.retrieveFournisseur(fournisseurId);
    }




    // http://localhost:8081/springMVC/servlet/fournisseur/remove-fournisseur/1
    @DeleteMapping("/remove-fournisseur/{fournisseur-id}")
    @ResponseBody
    public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        fournisseurService.deleteFournisseur(fournisseurId);
    }

    // http://localhost:8081/springMVC/servlet/fournisseur/modify_fournisseur
    @PutMapping("/modify_fournisseur")
    @ResponseBody
    public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.updateFournisseur(fournisseur);
    }

}
