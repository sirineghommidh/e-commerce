package com.esprit.spring.repository;

import com.esprit.spring.entites.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long> {
}
