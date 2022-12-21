package com.esprit.spring.services;

import com.esprit.spring.entites.Reclamation;

import java.util.List;

public interface IReclamation {
    List<Reclamation> retrieveAllReclamations();

    Reclamation addReclamation(Reclamation r);

    void deleteReclamation(Long id);

    Reclamation updateReclamation(Reclamation r);

    Reclamation retrieveReclamation(Long id);

    List<Reclamation> retrieveReclamationsByClientId(Long id,Long etat);
}
