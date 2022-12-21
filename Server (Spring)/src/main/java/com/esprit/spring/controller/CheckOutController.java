package com.esprit.spring.controller;

import com.esprit.spring.entites.achat.Achat;
import com.esprit.spring.entites.achat.ReponseAchat;
import com.esprit.spring.services.ICheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/checkout")
public class CheckOutController {

    @Autowired

    private ICheckoutService iCheckoutService;

  @PostMapping("/achat")
    public ReponseAchat passerCommande(@RequestBody Achat achat){
      ReponseAchat reponseAchat=iCheckoutService.PasserCommande(achat);
      return reponseAchat;
  }
}

