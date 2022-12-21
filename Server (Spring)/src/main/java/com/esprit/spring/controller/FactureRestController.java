package com.esprit.spring.controller;

import com.esprit.spring.entites.Commande;
import com.esprit.spring.entites.Facture;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.entites.Livraison;
import com.esprit.spring.services.ICommande;
import com.esprit.spring.services.IFacture;
import com.esprit.spring.services.ILivraison;
import com.esprit.spring.services.PdfService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/facture")
public class FactureRestController {
    @Autowired
    IFacture factureService;
    @Autowired
    ICommande commandeService;
    @Autowired
    ILivraison livraisonService;
    private PdfService pdfService;

    //http://localhost:8081/springMVC/servlet/facture/retrieve_all_Factures
    @GetMapping("retrieve_all_Factures")
    @ResponseBody
    public List<Facture> getFactures() {
        List<Facture> factures = factureService.retrieveAllFactures();
        System.out.println(factures);
        return factures;
    }
    // http://localhost:8081/springMVC/servlet/Facture/add_Facture
    @PostMapping("/add_Facture")
    @ResponseBody
    public Facture addFacture(@RequestBody Facture c) {
        Facture facture = factureService.addFacture(c);
        return facture;
    }
    //http://localhost:8081/springMVC/servlet/Facture/retrieve_Facture/1
    @GetMapping("/retrieve_facture/{facture_id}")
    @ResponseBody
    public Facture retrieveFacture(@PathVariable("facture_id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }




    // http://localhost:8081/springMVC/servlet/facture/remove-facture/1
    @DeleteMapping("/remove-facture/{facture-id}")
    @ResponseBody
    public void removeFacture(@PathVariable("facture-id") Long factureId) {
        factureService.deleteFacture(factureId);
    }

    // http://localhost:8081/springMVC/servlet/facture/modify_facture
    @PutMapping("/modify_facture")
    @ResponseBody
    public Facture modifyFacture(@RequestBody Facture facture) {
        return factureService.updateFacture(facture);
    }

    // http://localhost:8081/springMVC/servlet/affecteFactureToCommande/{facture-id}/{commande-id}
    @PutMapping("/affecteFactureToCommande/{facture-id}/{commande-id}")
    @ResponseBody
    public Facture affectFactureToCommande(@PathVariable("facture-id") Long idFacture , @PathVariable("commande-id")  Long idCommande) {
        Facture p=this.retrieveFacture(idFacture);
        Commande commande= commandeService.retrieveCommande(idCommande);
        p.setCommande(commande);
        return   factureService.updateFacture(p);
    }

    // http://localhost:8081/springMVC/servlet/affecteFactureToLivraison/{facture-id}/{livraison-id}
    @PutMapping("/affecteFactureToLivraison/{facture-id}/{livraison-id}")
    @ResponseBody
    public Facture affectFactureToLivraison(@PathVariable("facture-id") Long idFacture ,@PathVariable("livraison-id")  Long idLivraison) {
        Facture p=this.retrieveFacture(idFacture);
        Livraison livraison= livraisonService.retrieveLivraison(idLivraison);
        p.setLivraison(livraison);
        return   factureService.updateFacture(p);
    }

    @GetMapping("/download-pdf")
    public void downloadPDFResource(HttpServletResponse response) {
        try {
            Path file = Paths.get(pdfService.generatePdf().getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch ( IOException | DocumentException ex) {
            ex.printStackTrace();
        }
    }

}
