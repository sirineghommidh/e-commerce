package com.esprit.spring.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.esprit.spring.entites.Commentaire;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.services.ICommentaire;
import com.esprit.spring.services.IProduit;
@CrossOrigin(origins = "*")
@RestController
public class CommentaireRestControler {
    @Autowired
    ICommentaire commentaireService;
    @Autowired
    IProduit produitService;

// http://localhost:8081/retrieve-all-commentaires

    @GetMapping("/retrieve-all-commentaires")
    @ResponseBody
    public List<Commentaire> getCommentaire() {
        List<Commentaire> listCommentaires = commentaireService.retrieveAllCommentaires();
        return listCommentaires;
    }

    // http://localhost:8081/add-commentaire
    @PostMapping("/add-commentaire")
    @ResponseBody
    public Commentaire addCommentaire(@RequestBody Commentaire c){
    	List<String> badWords=Collections.unmodifiableList(Arrays.asList("bob","fuck","shit","dick","sh*t","ass","bitch","bastard","cunt","trash","wanker","piss","pussy","twat","crap","arsehole","gash","prick","cock","minge","nigga","slut","damn","sucker","cracker","poop","puup","boob","buub","f*ck","b*tch"));
      Produit p=produitService.retrieveProduit(c.getProduit().getIdProduit());
      
      if(p==null){throw new ResponseStatusException(
    		  HttpStatus.NOT_FOUND, "NULL");}
      
      
      if(c.getComment().replaceAll("\\s+","").equals("")){
		  throw new ResponseStatusException(
	              HttpStatus.NOT_ACCEPTABLE, "Empty");
	  }
     
      for(String bW : badWords){
      if(c.getComment().toLowerCase().replaceAll("\\s+","").replaceAll("1", "i").replaceAll("!", "i").replaceAll("3", "e").replaceAll("4", "a").replaceAll("@", "a").replaceAll("5", "s").replaceAll("7", "t").replaceAll("0", "o").replaceAll("9", "g").contains(bW)){
          throw new ResponseStatusException( HttpStatus.NOT_ACCEPTABLE, "Bad Boy");}
      }
      
      for(Commentaire com :p.getCommentaire()){
    	  if(c.getComment().equals(com.getComment())){
    		  throw new ResponseStatusException(
    	              HttpStatus.NOT_FOUND, "Duplicated");
    	  } 
      }
      
       
       
      return commentaireService.addCommentaire(c);
    }

    // http://localhost:8081/retrieve-commentaire/2
    @GetMapping("/retrieve-commentaire/{commentaire-id}")
    @ResponseBody
    public Commentaire retrieveCommentaire(@PathVariable("commentaire-id") Long commentaireId) {
        return commentaireService.retrieveCommentaire(commentaireId);
    }


    // http://localhost:8081/remove-commentaire/{commentaire-id}
    @DeleteMapping("/remove-client/{commentaire-id}")
    @ResponseBody
    public void removeCommentaire(@PathVariable("commentaire-id") Long commentaireId) {
        commentaireService.deleteCommentaire(commentaireId);
    }

    // http://localhost:8081/modify-commentaire
    @PutMapping("/modify-commentaire")
    @ResponseBody
    public Commentaire modifyClient(@RequestBody Commentaire c) {
    	List<String> badWords=Collections.unmodifiableList(Arrays.asList("bob","fuck","shit","dick","sh*t","ass","bitch","bastard","cunt","trash","wanker","piss","pussy","twat","crap","arsehole","gash","prick","cock","minge","nigga","slut","damn","sucker","cracker","poop","puup","boob","buub","f*ck","b*tch"));
        Produit p=produitService.retrieveProduit(c.getProduit().getIdProduit());
        
        if(p==null){throw new ResponseStatusException(
      		  HttpStatus.NOT_FOUND, "NULL");}
        
        
        if(c.getComment().replaceAll("\\s+","").equals("")){
  		  throw new ResponseStatusException(
  	              HttpStatus.NOT_ACCEPTABLE, "Empty");
  	  }
       
        for(String bW : badWords){
        if(c.getComment().toLowerCase().replaceAll("\\s+","").replaceAll("1", "i").replaceAll("!", "i").replaceAll("3", "e").replaceAll("4", "a").replaceAll("@", "a").replaceAll("5", "s").replaceAll("7", "t").replaceAll("0", "o").replaceAll("9", "g").contains(bW)){throw new ResponseStatusException(
                HttpStatus.NOT_ACCEPTABLE, "Bad Boy");}
        }
        
        for(Commentaire com :p.getCommentaire()){
      	  if(c.getComment().equals(com.getComment()) && c.getLikes()==com.getLikes()){
      		  throw new ResponseStatusException(
      	              HttpStatus.NOT_FOUND, "Duplicated");
      	  } 
        }
    	return commentaireService.updateCommentaire(c);
    }




}
