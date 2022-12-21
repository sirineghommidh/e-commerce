package com.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder

@FieldDefaults(level=AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idligneFournisseur")

public class LigneFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idligneFournisseur;
    private float  prixProduit;
    @ManyToOne
    Fournisseur fournisseur;
    @ManyToOne
    Produit produit;

}

