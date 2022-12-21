package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
/*@ToString
@EqualsAndHashCode  */ //ya t5dmhm manuallement ya t'excludi les variable eli fihm mapping (manyToMany ,OneTOone etc ) ib annotation
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idStock")
public class Stock implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idStock;
	@NonNull
	private int qteStock;
	@NonNull
	private int qteMin;
	@NonNull
	private String libelleStock;

	@JsonManagedReference(value="stockprod")
	@OneToMany(cascade =CascadeType.ALL,mappedBy = "stock")
	private Set<Produit> produits;
}

