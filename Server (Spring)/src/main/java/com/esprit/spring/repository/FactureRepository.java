package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Facture;
@Repository
public interface FactureRepository  extends JpaRepository<Facture, Long> {

}
