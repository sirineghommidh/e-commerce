package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.DetailCommande;

@Repository
public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Long>{

}
