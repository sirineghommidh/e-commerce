package com.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.repository.DetailProduitRepository;
@Service
public class DetailProduitServiceImpl implements IDetailProduit{
	@Autowired
	private DetailProduitRepository detailProduitRepository;


	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		// TODO Auto-generated method stub
		List<DetailProduit> DetailProduits = (List<DetailProduit>) detailProduitRepository.findAll();
		return DetailProduits;
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit p) {
		// TODO Auto-generated method stub
		detailProduitRepository.save(p);
		return p;
	}

	@Override
	public void deleteDetailProduit(Long id) {
		// TODO Auto-generated method stub
		detailProduitRepository.deleteById(id);

	}

	@Override
	public DetailProduit updateDetailProduit(DetailProduit u) {
		// TODO Auto-generated method stub
		return detailProduitRepository.save(u);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		// TODO Auto-generated method stub
		DetailProduit DetailProduit = detailProduitRepository.findById(id).orElse(null);
		return DetailProduit;
	}
}
