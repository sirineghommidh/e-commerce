package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Facture;


public interface IFacture {
	List<Facture> retrieveAllFactures();

	Facture addFacture(Facture c);

	void deleteFacture(Long id);

	Facture updateFacture(Facture u);

	Facture retrieveFacture(Long id);

	
}
