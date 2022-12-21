package com.esprit.spring.services;



import java.util.*;

import com.esprit.spring.entites.*;
import com.esprit.spring.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.repository.UserRepository;
import com.esprit.spring.repository.ProduitRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j  //equivalent instance de logger
public class ProduitServiceImpl implements IProduit {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	IDetailProduit detailproduit;

	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		List<Produit> produits = (List<Produit>) produitRepository.findAll();

		return produits;
	}
	@Override
	public Produit addProduit(Produit p) {
		// TODO Auto-generated method stub
		produitRepository.save(p);
		return p;
	}


	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);

	}

	@Override
	public Produit updateProduit(Produit u) {
		// TODO Auto-generated method stub
		return produitRepository.save(u);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		Produit produit = produitRepository.findById(id).orElse(null);
		return produit;
	}
	@Override
	public void calculeEtoile(Double rev,Long idP,Long idC){

		Produit p=retrieveProduit(idP);
		Double rectif=null;
		User c=userRepository.findById(idC).orElse(null);
		Map<Long,Double> temp = p.getClientEtoile();
		Double sum=0.0;
		if(((p!=null) )&&(rev>=0 && rev<=5)){
			temp.put(idC, rev);
			for (Double value : temp.values()) {
				sum += value;

			}
			rectif=sum/temp.size();
			if(rectif>=0 && rectif<0.5){
				p.setEtoile(0.0);
				p.setClientEtoile(temp);
			}else if (rectif>=0.5 && rectif<1){
				p.setEtoile(0.5);
				p.setClientEtoile(temp);
			}else if (rectif>=1 && rectif<1.5){
				p.setEtoile(1.0);
				p.setClientEtoile(temp);
			}else if (rectif>=1.5 && rectif<2){
				p.setEtoile(1.5);
				p.setClientEtoile(temp);
			}else if (rectif>=2 && rectif<2.5){
				p.setEtoile(2.0);
				p.setClientEtoile(temp);
			}else if (rectif>=2.5 && rectif<3){
				p.setEtoile(2.5);
				p.setClientEtoile(temp);
			}else if (rectif>=3 && rectif<3.5){
				p.setEtoile(3.0);
				p.setClientEtoile(temp);
			}else if (rectif>=3.5 && rectif<4){
				p.setEtoile(3.5);
				p.setClientEtoile(temp);
			}else if (rectif>=4 && rectif<4.5){
				p.setEtoile(4.0);
				p.setClientEtoile(temp);
			}else if (rectif>=4.5 && rectif<4.75){
				p.setEtoile(4.5);
				p.setClientEtoile(temp);
			}else if (rectif>=4.75 && rectif<=5){
				p.setEtoile(5.0);
				p.setClientEtoile(temp);
			}
			updateProduit(p);
		}
	}
	@Override
	public Set<Produit> rechercheAv(String categ,float prixMin,float prixMax,String libelle,Double etoile){
		Set<Produit> prods=new HashSet<Produit>();

		if (prixMin ==-1){
			prixMin=0.0f;
		}
		if (prixMax ==-1){
			prixMax=99999999999999999f;
		}

		for(Produit prod: retrieveAllProduits()){

			if ((categ.equals("-1") && libelle.equals("-1")) && (etoile==-1)){
				if ((prod.getPrixUnitaire()>= prixMin )&&(prod.getPrixUnitaire()<= prixMax))
				{prods.add(prod);}
			}
			if ((categ.equals("-1") && libelle.equals("-1")) && (etoile!=-1)){
				if ((prod.getPrixUnitaire()>= prixMin && prod.getPrixUnitaire()<= prixMax ) && (Double.compare(prod.getEtoile(), etoile)==0))
				{prods.add(prod);}
			}

			if (categ.equals("-1") && (etoile==-1) && (!libelle.equals("-1"))){
				if ((prod.getPrixUnitaire()>= prixMin )&&(prod.getPrixUnitaire()<= prixMax)&&(prod.getLibelleProduit().toLowerCase().contains(libelle)))
				{prods.add(prod);}
			}
			if (libelle.equals("-1") && (etoile==-1) && (!categ.equals("-1"))){
				if ((prod.getPrixUnitaire()>= prixMin )&&(prod.getPrixUnitaire()<= prixMax)&&(prod.getDetailProduit().getCategorieProduit().getCategorie().equals(categ)))
				{prods.add(prod);}
			}
			if (libelle.equals("-1") && etoile!=-1 && (!categ.equals("-1"))){
				if (((prod.getPrixUnitaire()>= prixMin )&&(prod.getPrixUnitaire()<= prixMax)&&(prod.getDetailProduit().getCategorieProduit().getCategorie().equals(categ))&& (Double.compare(prod.getEtoile(), etoile)==0)))
				{prods.add(prod);}
			}
			if (!libelle.equals("-1") && etoile!=-1 && (categ.equals("-1"))){
				if (((prod.getPrixUnitaire()>= prixMin )&&(prod.getPrixUnitaire()<= prixMax)&&(prod.getLibelleProduit().toLowerCase().contains(libelle)) && (Double.compare(prod.getEtoile(), etoile)==0)))
				{prods.add(prod);}
			}
			if (!libelle.equals("-1") && etoile==-1 && (!categ.equals("-1"))){
				if ((((prod.getPrixUnitaire()>= prixMin )&&(prod.getPrixUnitaire()<= prixMax)&&(prod.getDetailProduit().getCategorieProduit().getCategorie().equals(categ))))&&(prod.getLibelleProduit().toLowerCase().contains(libelle)))
				{prods.add(prod);}
			}

			if (!libelle.equals("-1") && etoile!=-1 && (!categ.equals("-1"))){
				if ((((prod.getPrixUnitaire()>= prixMin )&&(prod.getPrixUnitaire()<= prixMax)&&(prod.getDetailProduit().getCategorieProduit().getCategorie().equals(categ))&& (Double.compare(prod.getEtoile(), etoile)==0)))&&(prod.getLibelleProduit().toLowerCase().contains(libelle)))
				{prods.add(prod);}
			}

		}

		return prods ;
	}

}
