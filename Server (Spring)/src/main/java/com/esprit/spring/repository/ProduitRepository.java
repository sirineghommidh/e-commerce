package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

    @Query("select max(p.idProduit) from Produit p")
    public Long idmaxprod();

}
