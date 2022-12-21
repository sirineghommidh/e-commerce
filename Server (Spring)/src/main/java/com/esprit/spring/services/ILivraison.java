package com.esprit.spring.services;

import com.esprit.spring.entites.Livraison;

import java.util.List;

public interface ILivraison {
    List<Livraison> retrieveAllLivraisons();

    Livraison addLivraison(Livraison c);

    void deleteLivraison(Long id);

    Livraison updateLivraison(Livraison u);

    Livraison retrieveLivraison(Long id);
}
