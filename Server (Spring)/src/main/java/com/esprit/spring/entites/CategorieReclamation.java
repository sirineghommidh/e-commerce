package com.esprit.spring.entites;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder

@FieldDefaults(level=AccessLevel.PUBLIC)

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idReclamationCategory")
public class CategorieReclamation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamationCategory;

    private String categoryName;

    private Long status;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Reclamation> categorie;
}
