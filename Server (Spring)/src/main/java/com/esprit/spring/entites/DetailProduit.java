package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
//@FieldDefaults(level= AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idDetailProduit")

public class DetailProduit implements Serializable {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idDetailProduit;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	private Date dateDernierModification;

	private String description;

	@ManyToOne
	@JsonBackReference
	private CategorieProduit categorieProduit;

	@OneToOne(mappedBy = "detailProduit")
	@JsonBackReference(value="proddet")
	Produit produit;

	public DetailProduit(CategorieProduit categorieProduits) {
		super();
		this.dateCreation = new Date(System.currentTimeMillis());
		this.dateDernierModification =dateCreation;
		this.categorieProduit = categorieProduit;
	}

	public void setDateDernierModification() {
		this.dateDernierModification =new Date(System.currentTimeMillis());
	}




}
