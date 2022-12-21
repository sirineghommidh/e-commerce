package com.esprit.spring.services;

import com.esprit.spring.entites.LigneFournisseur;
import com.esprit.spring.repository.LigneFournisseurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j  //equivalent instance de logger
public class LigneForunisseurServiceImpl implements ILigneFournisseur {
    @Autowired
    private LigneFournisseurRepository ligneFournisseurRepository;


    @Override
    public List<LigneFournisseur> retrieveAllLigneFournisseurs() {
        // TODO Auto-generated method stub
        List<LigneFournisseur> ligneFournisseurs = (List<LigneFournisseur>) ligneFournisseurRepository.findAll();
		/*for (LigneFournisseur ligneFournisseur:ligneFournisseurs) {
			log.info(" ligneFournisseur: " + ligneFournisseur);
		}*/
        return ligneFournisseurs;
    }

    @Override
    public LigneFournisseur addLigneFournisseur(LigneFournisseur p) {
        // TODO Auto-generated method stub
        ligneFournisseurRepository.save(p);
        return p;
    }

    @Override
    public void deleteLigneFournisseur(Long id) {
        // TODO Auto-generated method stub
        ligneFournisseurRepository.deleteById(id);

    }

    @Override
    public LigneFournisseur updateLigneFournisseur(LigneFournisseur u) {
        // TODO Auto-generated method stub
        return ligneFournisseurRepository.save(u);
    }

    @Override
    public LigneFournisseur retrieveLigneFournisseur(Long id) {
        // TODO Auto-generated method stub
        LigneFournisseur ligneFournisseur = ligneFournisseurRepository.findById(id).orElse(null);
        return ligneFournisseur;
    }
}
