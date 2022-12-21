package com.esprit.spring.entites;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;



@Entity
@Getter
@Setter
@Table(name="Produit")



//@FieldDefaults(level=AccessLevel.PUBLIC)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idProduit")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long idProduit ;

	private String codeProduit ;

	private String libelleProduit;

	private float prixUnitaire;

	private int etat;

	private Double etoile;
	@ElementCollection
	private Map<Long, Double> clientEtoile;

	private String imageUrl;

	@ManyToOne
	@JsonBackReference(value="stockprod")
	private Stock stock;


	@ManyToOne
	@JsonBackReference(value="rayprod")
	private Rayon rayon;

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "produit")
	@JsonManagedReference(value="proddetcom")
	private Set<DetailCommande> detailCommande;


	@OneToOne
	@JsonManagedReference(value="proddet")
	private DetailProduit detailProduit;

	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Fournisseur>  fournisseurs;

	@OneToMany(cascade=CascadeType.PERSIST,mappedBy = "produit",fetch=FetchType.LAZY)
	@JsonManagedReference(value="prodcom")
	private List<Commentaire> commentaire;


	@CreationTimestamp
	private Date dateCreated;

	@Column (name = "last_updated")
	@UpdateTimestamp
	private Date lastUpdated;




}


