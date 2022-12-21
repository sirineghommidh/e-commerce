package com.esprit.spring.controller;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.services.ICategorieProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class CategorieProduitRestController {
    @Autowired
    ICategorieProduit categorieProduitService;

    //http://localhost:8081/retrieve_all_categorieProduit
    @GetMapping("/retrieve_all_categorieProduit")
    @ResponseBody
    public List<CategorieProduit> getCategorieProduits() {
        List<CategorieProduit> categorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        return categorieProduits;
    }
    // http://localhost:8081/add_categorieProduit
    @PostMapping("/add_categorieProduit")
    @ResponseBody
    public CategorieProduit addCategorieProduit(@RequestBody CategorieProduit c) {
        CategorieProduit categorieProduit = categorieProduitService.addCategorieProduit(c);
        return categorieProduit;
    }
    //http://localhost:8081/retrieve_categorieProduit/1
    @GetMapping("/retrieve_categorieProduit/{categorieProduit_id}")
    @ResponseBody
    public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit_id") Long categorieProduitId) {
        return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
    }




    // http://localhost:8081/remove-categorieProduit/1
    @DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        categorieProduitService.deleteCategorieProduit(categorieProduitId);
    }

    // http://localhost:8081/modify_categorieProduit
    @PutMapping("/modify_categorieProduit")
    @ResponseBody
    public CategorieProduit modifyCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
        return categorieProduitService.updateCategorieProduit(categorieProduit);
    }




}
