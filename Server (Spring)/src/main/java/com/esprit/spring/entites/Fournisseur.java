package com.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idfournisseur")
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idfournisseur;
	private String code_fornisseur;
	private String libelle_fournisseur;
	private Long Numero_Tel;
	@Enumerated(EnumType.STRING)
	private CategorieFournisseur Categorie;
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy = "fournisseur")
	public Set<LigneFournisseur> ligneFournisseur;*/
}
