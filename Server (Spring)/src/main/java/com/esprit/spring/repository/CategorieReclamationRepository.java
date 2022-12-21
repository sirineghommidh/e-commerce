package com.esprit.spring.repository;


import com.esprit.spring.entites.CategorieReclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategorieReclamationRepository extends JpaRepository<CategorieReclamation,Long> {


    @Transactional
    @Modifying
    @Query("SELECT c FROM CategorieReclamation c WHERE c.status=0")
    public List<CategorieReclamation> findInactiveCategories();

    @Transactional
    @Modifying
    @Query("SELECT c FROM CategorieReclamation c WHERE c.status=1")
    public List<CategorieReclamation> findActiveCategories();



    @Query("SELECT max(c.idReclamationCategory) FROM CategorieReclamation c")
    public Long getLastElementId();

}
