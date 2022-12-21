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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idAddresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddresse;
    private String ville;
    private String rue;
    private String autreDetail;
    private String codePostal;
    private String pays;
    @CreationTimestamp
    private Date createdAt ;
    @UpdateTimestamp
    private Date modifiedAt;

    private Double latitude;
    private Double logitude;
    @Enumerated(EnumType.STRING)
    private Adressetype adressetype;





    @PrePersist
    @PreUpdate
    public void calculateLatitudeLogitude(){

        String addresse=this.autreDetail+" "+rue+" "+ville+" "+pays;
        addresse=addresse.replaceAll("\\s","%20");
        try{



        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://trueway-geocoding.p.rapidapi.com/Geocode?address="+ addresse))
                .header("x-rapidapi-host", "trueway-geocoding.p.rapidapi.com")
                .header("x-rapidapi-key", "6e28e8df5cmshc99f0a14b7fc503p13ac35jsnde968e78dbe1")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
           // System.out.println("https://trueway-places.p.rapidapi.com/FindPlaceByText?text="+this.autreDetail.replaceAll("\\s","%20")+this.getVille().replaceAll("\\s","%20"));

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //JSONParser parser = new JSONParser();
            System.out.println(response.body());

            JSONObject obj = new JSONObject(response.body());
            JSONObject loc= obj.getJSONArray("results").getJSONObject(0).getJSONObject("location");
            logitude = loc.getDouble("lng");
            latitude = loc.getDouble("lat");



        }
        catch( Exception e) {
            System.out.println(e.getCause());
        }
    }

    public void ReverseGeoCoding()
    {
        try{

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://trueway-geocoding.p.rapidapi.com/ReverseGeocode?location="+this.getLatitude()+"%2C"+this.getLogitude()+"&language=fr"))
                .header("x-rapidapi-host", "trueway-geocoding.p.rapidapi.com")
                .header("x-rapidapi-key", "6e28e8df5cmshc99f0a14b7fc503p13ac35jsnde968e78dbe1")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
            JSONObject obj = new JSONObject(response.body());
            JSONObject result= obj.getJSONArray("results").getJSONObject(0);
           try{
               pays = result.getString("country");
           }  catch( Exception e) {
               System.out.println("nopays");
           }
            try{
                this.ville = result.getString("locality");
            }  catch( Exception e) {
                System.out.println("noville");
            }
            try{
                pays = result.getString("country");
            }  catch( Exception e) {
                System.out.println("noCountry");
            }
            try{
                this.autreDetail=result.getString("area");
            }  catch( Exception e) {
                System.out.println("noautreDetail");
            }
            try{
                this.rue=result.getString("street");
            }  catch( Exception e) {
                System.out.println("nostreet");
            }

        }
        catch( Exception e) {
            System.out.println(e.getCause());
        }
    }

}