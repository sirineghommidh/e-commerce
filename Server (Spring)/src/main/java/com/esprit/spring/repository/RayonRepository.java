package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Rayon;
@Repository
public interface RayonRepository  extends JpaRepository<Rayon, Long>{

}
