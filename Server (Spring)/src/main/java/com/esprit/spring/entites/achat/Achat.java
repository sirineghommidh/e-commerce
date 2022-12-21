package com.esprit.spring.entites.achat;

import com.esprit.spring.entites.Commande;
import com.esprit.spring.entites.DetailCommande;
import com.esprit.spring.entites.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Achat {
    private User user;
    private Commande commande;
    private Set<DetailCommande> detailCommandes;

}
