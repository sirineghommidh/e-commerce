package com.esprit.spring.services;

import com.esprit.spring.entites.Commande;

import java.util.List;

public interface ICommande {
    List<Commande> retrieveAllCommandes();

    Commande addCommande(Commande c);

    void deleteCommande(Long id);

    Commande updateCommande(Commande u);

    Commande retrieveCommande(Long id);
}
