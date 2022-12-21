package com.esprit.spring.services;

import com.esprit.spring.entites.Commande;
import com.esprit.spring.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeServiceImpl implements ICommande {
    @Autowired
    private CommandeRepository commandeRepository;


    @Override
    public List<Commande> retrieveAllCommandes()  {
        // TODO Auto-generated method stub
        List<Commande> Commandes = (List<Commande>) commandeRepository.findAll();
        return Commandes;
    }

    @Override
    public Commande addCommande(Commande p) {
        // TODO Auto-generated method stub
        commandeRepository.save(p);
        return p;
    }

    @Override
    public void deleteCommande(Long id) {
        // TODO Auto-generated method stub
        commandeRepository.deleteById(id);

    }

    @Override
    public Commande updateCommande(Commande u) {
        // TODO Auto-generated method stub
        return commandeRepository.save(u);
    }

    @Override
    public Commande retrieveCommande(Long id) {
        // TODO Auto-generated method stub
        Commande Commande = commandeRepository.findById(id).orElse(null);
        return Commande;
    }
}
