package com.esprit.spring;

import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.entites.Rayon;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.services.IDetailProduit;
import com.esprit.spring.services.IProduit;
import com.esprit.spring.services.IRayon;
import com.esprit.spring.services.IStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {
    @Autowired
    IProduit produitService;
    @Autowired
    IDetailProduit detailProduitService;
    @Autowired
    IStock stockService;
    @Autowired
    IRayon rayonService;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
/*
		DetailProduit dp1=new DetailProduit(CategorieProduit.ALIMENTAIRE);
		DetailProduit dp2=new DetailProduit(CategorieProduit.ALIMENTAIRE);
		Stock stock1=new Stock(40,2,"libellestock1");
		Stock stock2=new Stock(20,21,"libellestock2");
		Rayon rayon1=new Rayon("Colone1ligne2","fruit et legume");
		stockService.addStock(stock1);
		stockService.addStock(stock2);
		rayonService.addRayon(rayon1);
		Produit p1=new Produit("45878","tomate",10.22f,stock1,rayon1,dp1);
		Produit p2=new Produit("88575","pomme",10.22f,stock2,rayon1,dp2);
		detailProduitService.addDetailProduit(dp1);
		detailProduitService.addDetailProduit(dp2);

	 	produitService.addProduit(p1);

	 	produitService.addProduit(p2);


		System.out.println("***************************");


		produitService.retrieveAllProduits().forEach(p->{
			System.out.println(p);
		});
		List<Produit> produits=produitService.retrieveAllProduits();


		System.out.println("***************************");


		Produit produit = produitService.retrieveProduit(1L);
 		System.out.println(produit.getIdProduit());

		System.out.println("***************************");

*/

    }

}
