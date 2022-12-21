package com.esprit.spring.entites;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="CategorieProduit")
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idCategorieProduit")

public class CategorieProduit implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy =GenerationType.IDENTITY)
        private long idCategorieProduit ;

        private String categorie;

        @OneToMany(cascade=CascadeType.PERSIST,mappedBy = "categorieProduit",fetch=FetchType.LAZY)
        private Set<DetailProduit> detailproduit;

}
