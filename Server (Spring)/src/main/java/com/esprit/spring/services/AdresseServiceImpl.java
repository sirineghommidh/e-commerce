package com.esprit.spring.services;

import com.esprit.spring.entites.Adresse;
import com.esprit.spring.repository.AdresseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j  //equivalent instance de logger
public class AdresseServiceImpl  implements  IAdresse{
    @Autowired
    private AdresseRepository adresseRepository;


    @Override
    public List<Adresse> retrieveAllAdresses() {
        // TODO Auto-generated method stub
        List<Adresse> adresses = (List<Adresse>) adresseRepository.findAll();
		/*for (Adresse adresse:adresses) {
			log.info(" adresse: " + adresse);
		}*/
        return adresses;
    }

    @Override
    public Adresse addAdresse(Adresse p) {
        // TODO Auto-generated method stub
        adresseRepository.save(p);
        return p;
    }

    @Override
    public void deleteAdresse(Long id) {
        // TODO Auto-generated method stub
        adresseRepository.deleteById(id);

    }

    @Override
    public Adresse updateAdresse(Adresse u) {
        // TODO Auto-generated method stub
        return adresseRepository.save(u);
    }

    @Override
    public Adresse retrieveAdresse(Long id) {
        // TODO Auto-generated method stub
        Adresse adresse = adresseRepository.findById(id).orElse(null);
        return adresse;
    }
}
