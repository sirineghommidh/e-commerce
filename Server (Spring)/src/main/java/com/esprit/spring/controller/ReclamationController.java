package com.esprit.spring.controller;


import com.esprit.spring.entites.CategorieReclamation;
import com.esprit.spring.entites.Reclamation;
import com.esprit.spring.entites.User;
import com.esprit.spring.repository.ReclamationRepository;
import com.esprit.spring.services.ICategorieReclamation;
import com.esprit.spring.services.IReclamation;
import com.esprit.spring.services.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("reclamation")
public class ReclamationController {
    @Autowired
    private IReclamation reclamationService;
    @Autowired
    private IUser userService;
    @Autowired
    private ICategorieReclamation categoryService;
    @Autowired
    private ReclamationRepository reclamrepos;

    @GetMapping("/admin/retrieve-all-reclamations")
    @ResponseBody
    public List<Reclamation> getAllReclamations() {
        List<Reclamation> Reclamations =  reclamationService.retrieveAllReclamations();
        return Reclamations;
    }

    @PostMapping ("/client/add-reclamation")
    @ResponseBody
    public Reclamation addReclamation(@RequestBody Reclamation r) {
        reclamationService.addReclamation(r);
        return r;
    }

    @DeleteMapping ("/admin/delete-reclamations/{reclamation-id}")
    @ResponseBody
    public void deleteReclamation(@PathVariable("reclamation-id") Long id) {
        reclamationService.deleteReclamation(id);
    }

    @PutMapping("/admin/update-reclamations")
    @ResponseBody
    public Reclamation updateReclamation(@RequestBody Reclamation r) {
        return reclamationService.updateReclamation(r);
    }

    @GetMapping("/admin/retrieve-one-reclamations/{reclamation-id}")
    @ResponseBody
    public Reclamation retrieveOneReclamation(@PathVariable("reclamation-id") Long id) {
        Reclamation reclamation = reclamationService.retrieveReclamation(id);
        return reclamation;
    }

    @GetMapping("/admin/same-Client")
    @ResponseBody
    public List<Reclamation> retrieveReclamationsByClientId(@RequestParam Long id, @RequestParam Long etat){
        List<Reclamation> reclamations = (List<Reclamation>) reclamationService.retrieveReclamationsByClientId(id,etat);
        return reclamations;
    }


    @PutMapping("/affect-reclamation-client/{id-reclam}/{id-client}")
    @ResponseBody
    public Reclamation affectReclamationToClient(@PathVariable("id-reclam") Long id_rec, @PathVariable("id-client") Long id_client)
    {
        Reclamation r = this.retrieveOneReclamation(id_rec);
        User user = userService.findUserById(id_client);
        r.setClient(user);
        return reclamationService.updateReclamation(r);
    }

    @PutMapping("/affect-reclamation-category/{id-reclam}/{id-category}")
    @ResponseBody
    public Reclamation affectReclamationToCategory(@PathVariable("id-reclam") Long id_rec, @PathVariable("id-category") Long id_category)
    {
        Reclamation r = this.retrieveOneReclamation(id_rec);
        CategorieReclamation category = categoryService.retrieveOneCategory(id_category);
        r.setCategory(category);
        return reclamationService.updateReclamation(r);
    }

    //statistiques réclamation
    @GetMapping("/admin/stats-non-treated")
    @ResponseBody
    public String GetNonTreatedReclamations()
    {
        return reclamrepos.NonTreatedReclamations();
    }

    @GetMapping("/admin/stats-treated")
    @ResponseBody
    public String GetTreatedReclamations()
    {
        return reclamrepos.TreatedReclamations();
    }
}
