package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.spring.entites.Commentaire;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
