package com.esprit.spring.services;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.repository.CategorieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduit{
    @Autowired
    private CategorieProduitRepository categorieProduitRepository;


    @Override
    public List<CategorieProduit> retrieveAllCategorieProduits() {
        // TODO Auto-generated method stub
        List<CategorieProduit> CategorieProduits = (List<CategorieProduit>) categorieProduitRepository.findAll();
        return CategorieProduits;
    }

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit c) {
        // TODO Auto-generated method stub
        return categorieProduitRepository.save(c);
    }

    @Override
    public void deleteCategorieProduit(Long id) {
        // TODO Auto-generated method stub
        categorieProduitRepository.deleteById(id);

    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit c) {
        // TODO Auto-generated method stub
        return categorieProduitRepository.save(c);
    }

    @Override
    public CategorieProduit retrieveCategorieProduit(Long id) {
        // TODO Auto-generated method stub
        CategorieProduit categorieProduit = categorieProduitRepository.findById(id).orElse(null);
        return categorieProduit;
    }
}
