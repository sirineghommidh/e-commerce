package com.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idCommande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private BigDecimal montantRemise;
    private BigDecimal montantPanier;
    @CreationTimestamp
    private Date createdAt;
    private Boolean etat;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User u;
    @OneToMany(cascade = CascadeType.ALL, mappedBy= "commande")
    private Set<DetailCommande> detailCommandes=new HashSet<>();
    @OneToOne(cascade=CascadeType.ALL ,mappedBy="commande")
    private  Facture facture;
    //New fields added
    private String numeroDeSuivi;
    @UpdateTimestamp
    private Date updateAt;

    //Method that adds Detail Commande to the Set of Detail commande
    public void add(DetailCommande detailC){

        if (detailC !=null){
            if(detailCommandes==null){
                detailCommandes =new HashSet<>();

            }
            detailCommandes.add(detailC);
            detailC.setCommande(this);
        }

    }



}
