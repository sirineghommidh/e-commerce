package com.esprit.spring.controller;

import com.esprit.spring.entites.*;
import com.esprit.spring.entites.Adresse;
import com.esprit.spring.entites.Adresse;
import com.esprit.spring.services.IAdresse;
import com.esprit.spring.services.IAdresse;
import com.esprit.spring.services.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/addresse")
public class AdresseRestController extends Adresse {
    @Autowired
    IAdresse adresseService;
    @Autowired
    IUser userService;
    //http://localhost:8081/springMVC/servlet/adresse/retrieve_all_adresses
    @GetMapping("/retrieve_all_adresses")
    @ResponseBody
    public List<Adresse> getAdresses() {
        List<Adresse> adresses = adresseService.retrieveAllAdresses();
        System.out.println(adresses);
        return adresses;
    }


    // http://localhost:8081/springMVC/servlet/adresse/client/add_adresseclient
    @PostMapping("client/add_adresseclient")
    @ResponseBody
    public Adresse addAdresseClient(@RequestBody Adresse c) {
        c.setAdressetype(Adressetype.client);
        Adresse adresse = adresseService.addAdresse(c);
        return adresse;
    }
    // http://localhost:8081/springMVC/servlet/adresse/admin/add_adressemagasin
    @PostMapping("a/add_adressemagasin")
    @ResponseBody
    public Adresse addAdresseDepot(@RequestBody Adresse c) {
        c.setAdressetype(Adressetype.magasin);
        Adresse adresse = adresseService.addAdresse(c);
        return adresse;
    }
    //http://localhost:8081/springMVC/servlet/adresse/retrieve_adresse/1
    @GetMapping("/retrieve_adresse/{adresse_id}")
    @ResponseBody
    public Adresse retrieveAdresse(@PathVariable("adresse_id") Long adresseId) {
       Adresse adresse= adresseService.retrieveAdresse(adresseId);

        return adresse  ;



    }


    // http://localhost:8081/springMVC/servlet/adresse/remove-adresse/1
    @DeleteMapping("/remove-adresse/{adresse-id}")
    @ResponseBody
    public void removeAdresse(@PathVariable("adresse-id") Long adresseId) {
        adresseService.deleteAdresse(adresseId);
    }

    // http://localhost:8081/springMVC/servlet/adresse/modify_adresse
    @PutMapping("/modify_adresse")
    @ResponseBody
    public Adresse modifyAdresse(@RequestBody Adresse adresse) {
        return adresseService.updateAdresse(adresse);
    }


    // http://localhost:8081/springMVC/servlet/adresse/getCoordinate
    @PostMapping("client/getCoordinate")
    @ResponseBody
    public Adresse getCoordinate(@RequestBody Adresse c) {
        c.calculateLatitudeLogitude();
        return c;
    }
    // http://localhost:8081/springMVC/servlet/adresse/getCoordinate
    @PostMapping("client/getAddressFromCoordinate")
    @ResponseBody
    public Adresse getAddressFromCoordinate(@RequestBody Adresse c) {
        c.ReverseGeoCoding();
        return c;
    }
    // http://localhost:8081/springMVC/servlet/affecteFactureToLivraison/{facture-id}/{livraison-id}
    @PutMapping("/affecteAdresseToClient/{Client-id}/{address-id}")
    @ResponseBody
    public void affectAdresseToUser(@PathVariable("Client-id") Long Clientid , @PathVariable("address-id")  Long addressid) {
        User u=userService.findUserById(Clientid);
        Adresse a = adresseService.retrieveAdresse(addressid) ;
        Set<Adresse> adresses =u.getAdresses();
        adresses.add(a);
        u.setAdresses(adresses);
        try {
            userService.UpdateUser(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
