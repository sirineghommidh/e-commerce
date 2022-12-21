package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Stock;

import java.util.List;

@Repository
public interface StockRepository  extends JpaRepository<Stock, Long>{
    // Statistique :  libellé des produits qui ont un quantité de stock inférieur à 5
    @Query(value = "SELECT p.libelleProduit FROM Produit p,Stock s WHERE p.stock_id_stock in (SELECT s.idStock WHERE s.qteMin<5)",nativeQuery = true)
    List<String> findLibelleProduit();

    // Recherche aveugle Pour un stock ( trouver stock avec n'importe quel key word)
    @Query(value = "SELECT * FROM Stock s WHERE CONCAT(s.idStock+s.qteStock+s.qteMin+s.libelleStock) LIKE '% :rech %' ",nativeQuery = true)
    List<Stock> findStockWithAnyKeyWord(@Param("rech") String rech);
}


