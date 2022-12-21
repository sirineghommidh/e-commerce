package com.esprit.spring.services;


import com.esprit.spring.entites.LigneFournisseur;

import java.util.List;

public interface ILigneFournisseur {
    List<LigneFournisseur> retrieveAllLigneFournisseurs();

    LigneFournisseur addLigneFournisseur(LigneFournisseur c);

    void deleteLigneFournisseur(Long id);

    LigneFournisseur updateLigneFournisseur(LigneFournisseur u);

    LigneFournisseur retrieveLigneFournisseur(Long id);
}
