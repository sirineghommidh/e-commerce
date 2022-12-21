package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.DetailCommande;
import com.esprit.spring.repository.DetailCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.DetailCommande;
import com.esprit.spring.repository.DetailCommandeRepository;
@Service
public class DetailCommandeServiceImpl implements IDetailCommande {
	@Autowired
	private DetailCommandeRepository detailCommandeRepository;


	@Override
	public List<DetailCommande> retrieveAllDetailCommandes() {
		List<DetailCommande> DetailCommandes = (List<DetailCommande>) detailCommandeRepository.findAll();
		return DetailCommandes;
	}

	@Override
	public DetailCommande addDetailCommande(DetailCommande p) {
		detailCommandeRepository.save(p);
		return p;
	}

	@Override
	public void deleteDetailCommande(Long id) {
		detailCommandeRepository.deleteById(id);

	}

	@Override
	public DetailCommande updateDetailCommande(DetailCommande u) {
		return detailCommandeRepository.save(u);
	}

	@Override
	public DetailCommande retrieveDetailCommande(Long id) {
		DetailCommande DetailCommande = detailCommandeRepository.findById(id).orElse(null);
		return DetailCommande;
	}
}
