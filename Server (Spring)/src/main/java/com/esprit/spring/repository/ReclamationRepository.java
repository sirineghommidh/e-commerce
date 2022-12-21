package com.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.spring.entites.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
    @Transactional
    @Modifying
    @Query("SELECT r FROM Reclamation r WHERE r.client.id = ?1 AND r.etat=?2"
            )
    public List<Reclamation> findAllReclamationById(Long id,Long etat);

    //Statistiques réclamations
            //nombre de reclamations non traités
    @Transactional
    @Modifying
    @Query("SELECT concat('il y a : ',COUNT(r),' réclamations non traitées') FROM Reclamation r WHERE r.etat=0")
    public String NonTreatedReclamations();
            //nombre de reclamations traités
    @Transactional
    @Modifying
    @Query("SELECT concat('il y a : ',COUNT(r),' réclamations traitées') FROM Reclamation r WHERE r.etat=1")
    public String TreatedReclamations();


}
