package com.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONObject;

import javax.persistence.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder

@FieldDefaults(level=AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idLivraison")
public class Livraison {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivraison ;
    @CreationTimestamp
    private Date dateCreation ;
    @Temporal(TemporalType.DATE)
    private Date dateArrivage;
    @UpdateTimestamp
    private Date modifiedAt;
    @OneToOne(cascade=CascadeType.ALL,mappedBy="livraison" )
    private  Facture facture;
    @ManyToOne(cascade=CascadeType.ALL)
    private Adresse adresse;
    private float distance ;
    private float dureeitineraire;
    @ManyToOne(cascade=CascadeType.ALL)
    private Adresse adresseMagasin;
    private float prixLivraison ;


    public void calculatePrixLivraison()
    {
    this.prixLivraison=this.distance*0.02f+3;
    }

    public void calculateDistanceToDepot()
    {

        try {
            HttpRequest request = HttpRequest.newBuilder()

                    .uri(URI.create("https://trueway-matrix.p.rapidapi.com/CalculateDrivingMatrix?origins="+adresseMagasin.getLatitude()+"%2C"+adresseMagasin.getLogitude()+"&destinations="+this.getAdresse().getLatitude()+"%2C"+this.getAdresse().getLogitude()))
                    .header("x-rapidapi-host", "trueway-matrix.p.rapidapi.com")
                    .header("x-rapidapi-key", "6e28e8df5cmshc99f0a14b7fc503p13ac35jsnde968e78dbe1")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            JSONObject obj = new JSONObject(response.body());
            this.distance= obj.getJSONArray("distances").getJSONArray(0).getLong(0);
            this.dureeitineraire=obj.getJSONArray("durations").getJSONArray(0).getLong(0);
            this.distance=this.distance/1000;
            this.dureeitineraire=this.dureeitineraire/60/60;
            System.out.println(this.distance+this.dureeitineraire);






        }
      catch( Exception e) {
        System.out.println(e.getCause());
    }
    }


}
