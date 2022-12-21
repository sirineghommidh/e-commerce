package com.esprit.spring.services;

import com.esprit.spring.entites.Livraison;
import com.esprit.spring.repository.LivraisonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j  //equivalent instance de logger
public class LivraisonServiceImpl implements  ILivraison{
    @Autowired
    private LivraisonRepository livraisonRepository;


    @Override
    public List<Livraison> retrieveAllLivraisons() {
        // TODO Auto-generated method stub
        List<Livraison> livraisons = (List<Livraison>) livraisonRepository.findAll();
		/*for (Livraison livraison:livraisons) {
			log.info(" livraison: " + livraison);
		}*/
        return livraisons;
    }

    @Override
    public Livraison addLivraison(Livraison p) {
        // TODO Auto-generated method stub
        livraisonRepository.save(p);
        return p;
    }

    @Override
    public void deleteLivraison(Long id) {
        // TODO Auto-generated method stub
        livraisonRepository.deleteById(id);

    }

    @Override
    public Livraison updateLivraison(Livraison u) {
        // TODO Auto-generated method stub
        return livraisonRepository.save(u);
    }

    @Override
    public Livraison retrieveLivraison(Long id) {
        // TODO Auto-generated method stub
        Livraison livraison = livraisonRepository.findById(id).orElse(null);
        return livraison;
    }
}
