package com.esprit.spring.controller;

import com.esprit.spring.entites.Adresse;
import com.esprit.spring.entites.Livraison;
import com.esprit.spring.services.IAdresse;
import com.esprit.spring.services.ILivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/livraison")
public class LivraisonRestController {
    @Autowired
    ILivraison livraisonService;
    @Autowired
    IAdresse adresseService;
    //http://localhost:8081/springMVC/servlet/livraison/retrieve_all_livraisons
    @GetMapping("/retrieve_all_livraisons")
    @ResponseBody
    public List<Livraison> getLivraisons() {
        List<Livraison> livraisons = livraisonService.retrieveAllLivraisons();
        System.out.println(livraisons);
        return livraisons;
    }
    // http://localhost:8081/springMVC/servlet/livraison/add_livraison
    @PostMapping("/add_livraison")
    @ResponseBody
    public Livraison addLivraison(@RequestBody Livraison c) {
        Livraison livraison = livraisonService.addLivraison(c);
        return livraison;
    }
    //http://localhost:8081/springMVC/servlet/livraison/retrieve_livraison/1
    @GetMapping("/retrieve_livraison/{livraison_id}")
    @ResponseBody
    public Livraison retrieveLivraison(@PathVariable("livraison_id") Long livraisonId) {
        return livraisonService.retrieveLivraison(livraisonId);
    }




    // http://localhost:8081/springMVC/servlet/livraison/remove-livraison/1
    @DeleteMapping("/remove-livraison/{livraison-id}")
    @ResponseBody
    public void removeLivraison(@PathVariable("livraison-id") Long livraisonId) {
        livraisonService.deleteLivraison(livraisonId);
    }

    // http://localhost:8081/springMVC/servlet/livraison/modify_livraison
    @PutMapping("/modify_livraison")
    @ResponseBody
    public Livraison modifyLivraison(@RequestBody Livraison livraison) {
        return livraisonService.updateLivraison(livraison);
    }

    // http://localhost:8081/springMVC/servlet/livraison/add_livraison
    @PutMapping("/calculateDistance/{livraison-id}/{addressmagazin-id}/{addresseclient_id}")
    @ResponseBody
    public Livraison calculateDistance(@PathVariable("livraison-id") Long livraisonId ,@PathVariable("addressmagazin-id") Long addressmagazinId,@PathVariable("addresseclient_id") Long addressclientId) {
        Livraison l =livraisonService.retrieveLivraison(livraisonId);
        System.out.println(addressmagazinId);
        l.setAdresseMagasin(adresseService.retrieveAdresse(addressmagazinId));
        l.setAdresse(adresseService.retrieveAdresse(addressclientId));
        l.calculateDistanceToDepot();
        l.calculatePrixLivraison();
        livraisonService.updateLivraison(l);
        return l;
    }
}
