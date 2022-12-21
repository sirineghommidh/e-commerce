package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Fournisseur;


public interface IFournisseur {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur c);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur u);

	Fournisseur retrieveFournisseur(Long id);
}
