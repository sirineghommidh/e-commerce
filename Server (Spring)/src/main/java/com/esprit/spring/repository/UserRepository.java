package com.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import com.esprit.spring.entites.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.spring.entites.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
    
    @Query("select u from User u where"+" concat(u.firstName,u.lastName,u.email,u.DateNaissance,u.password,u.profession)"+" LIKE %?1% ")
   public Page<User> findAll(String keyword,Pageable pageable);
    
    
    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.locked = TRUE WHERE a.id = ?1")
    public int lockUser(Long id);

    //requettes statistiques client
    @Transactional
    @Modifying
    @Query("SELECT concat(f.u.profession,' ',SUM(f.montantFacture)) FROM Facture f GROUP BY f.u.profession ORDER BY SUM(f.montantFacture)")
    public List<String> SpendingByProfession();

    /*
    @Transactional
    @Modifying
    @Query("SELECT SUM(f.montantFacture) FROM Facture f GROUP BY f.u.profession ORDER BY SUM(f.montantFacture)")
    public List<Float> AmountByProfession();
    */
}
