package com.esprit.spring.repository;

import com.esprit.spring.entites.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
