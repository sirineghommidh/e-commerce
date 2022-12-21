package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.DetailCommande;

public interface IDetailCommande {
	List<DetailCommande> retrieveAllDetailCommandes();

	DetailCommande addDetailCommande(DetailCommande c);

	void deleteDetailCommande(Long id);

	DetailCommande updateDetailCommande(DetailCommande u);

	DetailCommande retrieveDetailCommande(Long id);
}
