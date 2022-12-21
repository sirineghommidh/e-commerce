package com.esprit.spring.services;

import com.esprit.spring.entites.Reclamation;
import com.esprit.spring.entites.Reclamation;
import com.esprit.spring.entites.Reclamation;
import com.esprit.spring.repository.ReclamationRepository;
import com.esprit.spring.repository.ReclamationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j  //equivalent instance de logger
public class ReclamationServiceImp implements IReclamation{
    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public List<Reclamation> retrieveAllReclamations() {
        // TODO Auto-generated method stub
        List<Reclamation> reclamations = (List<Reclamation>) reclamationRepository.findAll();
        return reclamations;
    }

    @Override
    public Reclamation addReclamation(Reclamation r) {
        // TODO Auto-generated method stub
        reclamationRepository.save(r);
        return r;
    }

    @Override
    public void deleteReclamation(Long id) {
        // TODO Auto-generated method stub
        reclamationRepository.deleteById(id);
    }

    @Override
    public Reclamation updateReclamation(Reclamation r) {
        // TODO Auto-generated method stub
        return reclamationRepository.save(r);
    }

    @Override
    public Reclamation retrieveReclamation(Long id) {
        // TODO Auto-generated method stub
        Reclamation reclamation = reclamationRepository.findById(id).orElse(null);
        return reclamation;
    }

    //gets all reclamations made by the same client

    @Override
    public List<Reclamation> retrieveReclamationsByClientId(Long id, Long etat){
        List<Reclamation> reclamations = (List<Reclamation>) reclamationRepository.findAllReclamationById(id,etat);
        return reclamations;
    }
}
