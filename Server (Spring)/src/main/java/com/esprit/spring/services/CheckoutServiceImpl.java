package com.esprit.spring.services;

import com.esprit.spring.entites.Commande;
import com.esprit.spring.entites.DetailCommande;
import com.esprit.spring.entites.User;
import com.esprit.spring.entites.achat.Achat;
import com.esprit.spring.entites.achat.ReponseAchat;
import com.esprit.spring.repository.UserRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements ICheckoutService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public ReponseAchat PasserCommande(Achat achat) {

        //retrieve the commande info from achat
        Commande commande =achat.getCommande();
        //generate numero de suivi
        String numeroDeSuivi = genererNumeroDeSuivi();
        commande.setNumeroDeSuivi(numeroDeSuivi);
        //populate commande with detail commande
        Set<DetailCommande> detailCommande=achat.getDetailCommandes();
        detailCommande.forEach(detail->commande.add(detail));
        //populate user with  commande
        User user=achat.getUser();
        user.add(commande);
        //save to the DB
        userRepository.save(user);
        //return a response

        return  new ReponseAchat(numeroDeSuivi);

    }

    private String genererNumeroDeSuivi() {
        // generate random id (UUID)
        return UUID.randomUUID().toString();
    }
}
