package com.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idDetailFacture")
public class DetailCommande implements Serializable{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idDetailFacture;
	private int qte;
	private float prixTotal;
	private int  pourcentageRemise;
	private int montantRemise;
	@ManyToOne
	@JoinColumn(name = "commande_id")
	Commande commande;
	@ManyToOne
	@JsonBackReference(value="proddetcom")
	private Produit produit;
	private String imageUrl;
	private BigDecimal prixUnitaire;
	@Column(name="produit_id")
	private Long produitId;


}
