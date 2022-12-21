package com.esprit.spring.services;

import java.util.List;
import java.util.Set;

import com.esprit.spring.entites.Produit;

public interface IProduit {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Produit u);

	Produit retrieveProduit(Long id);

	void calculeEtoile(Double rev,Long idP,Long idC);

	 Set<Produit> rechercheAv(String categ, float prixMin, float prixMax, String libelle, Double etoile);
}
