package com.esprit.spring.controller;

import com.esprit.spring.entites.Commande;
import com.esprit.spring.services.ICommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeRestController {
    @Autowired
    ICommande commandeService;
    //http://localhost:8081/springMVC/servlet/commande/retrieve_all_Commandes
    @GetMapping("admin/retrieve_all_Commandes")
    @ResponseBody
    public List<Commande> getCommandes() {
        List<Commande> commandes = commandeService.retrieveAllCommandes();
        System.out.println(commandes);
        return commandes;
    }
    // http://localhost:8081/springMVC/servlet/Commande/add_Commande
    @PostMapping("/add_Commande")
    @ResponseBody
    public Commande addCommande(@RequestBody Commande c) {
        Commande commande = commandeService.addCommande(c);
        return commande;
    }
    //http://localhost:8081/springMVC/servlet/Commande/retrieve_Commande/1
    @GetMapping("/retrieve_commande/{commande_id}")
    @ResponseBody
    public Commande retrieveCommande(@PathVariable("commande_id") Long commandeId) {
        return commandeService.retrieveCommande(commandeId);
    }




    // http://localhost:8081/springMVC/servlet/commande/remove-commande/1
    @DeleteMapping("/remove-commande/{commande-id}")
    @ResponseBody
    public void removeCommande(@PathVariable("commande-id") Long commandeId) {
        commandeService.deleteCommande(commandeId);
    }

    // http://localhost:8081/springMVC/servlet/commande/modify_commande
    @PutMapping("/modify_commande")
    @ResponseBody
    public Commande modifyCommande(@RequestBody Commande commande) {
        return commandeService.updateCommande(commande);
    }


}
