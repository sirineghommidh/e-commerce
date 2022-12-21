package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.DetailProduit;

public interface IDetailProduit {
	List<DetailProduit> retrieveAllDetailProduits();

	DetailProduit addDetailProduit(DetailProduit c);

	void deleteDetailProduit(Long id);

	DetailProduit updateDetailProduit(DetailProduit u);

	DetailProduit retrieveDetailProduit(Long id);
}
