package com.esprit.spring.services;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.entites.CategorieProduit;

import java.util.List;

public interface ICategorieProduit {

    List<CategorieProduit> retrieveAllCategorieProduits();

    CategorieProduit addCategorieProduit(CategorieProduit c);

    void deleteCategorieProduit(Long id);

    CategorieProduit updateCategorieProduit(CategorieProduit c);

    CategorieProduit retrieveCategorieProduit(Long id);

}
