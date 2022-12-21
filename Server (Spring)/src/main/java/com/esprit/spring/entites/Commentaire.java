package com.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
//@FieldDefaults(level=AccessLevel.PUBLIC)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idCommentaire")
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idCommentaire ;

    private Long idClient;

    private String comment;

    private Long likes;
    @JsonBackReference(value="prodcom")
    @ManyToOne
    private Produit produit;

    @CreationTimestamp
    private Date dateCreated;

    @Column (name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;




}

