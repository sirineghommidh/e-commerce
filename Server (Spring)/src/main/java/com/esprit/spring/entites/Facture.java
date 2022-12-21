package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idFacture")
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idFacture;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createdAT;
	private Boolean active;
	private String matricule_Fiscal;
	@OneToOne(cascade = CascadeType.ALL)
	private Commande commande;
	@OneToOne(cascade=CascadeType.ALL )
	private  Livraison livraison;
	@UpdateTimestamp
	private Date modifiedAt;
    
	@ManyToOne(cascade = CascadeType.ALL)
    private User u ;


	
}
