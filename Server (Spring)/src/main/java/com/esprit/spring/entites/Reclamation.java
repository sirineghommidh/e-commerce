package com.esprit.spring.entites;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder

@FieldDefaults(level=AccessLevel.PUBLIC)


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idReclamation")
public class Reclamation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation ;
    private String sujet;
    private String contenu;
    @CreationTimestamp
    private LocalDateTime CreatedAt;
    @UpdateTimestamp
    private LocalDateTime EditedAt;
    private Long etat;

    @ManyToOne
    private User client;

    @ManyToOne
    private CategorieReclamation category ;

}
