package com.example.gestionpromo.Controllers;

import com.example.gestionpromo.Entities.Produit;
import com.example.gestionpromo.Services.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProduitController {

    private final ProduitService ProduitService ;

    @GetMapping("/Produits")
    List<Produit> getAllProduits(){
        return ProduitService.getAllProduits();
    }
    @GetMapping("/Produits/{IdProduit}")
    public List<Produit> getProduitById(@PathVariable Integer IdProduit) {
                return ProduitService.getProduitById(IdProduit);
    }
    @PutMapping("/ProduitsC")
    public Produit createProduit( Produit produit) {
        return ProduitService.saveProduit(produit);
    }

    @PutMapping("/ProduitsU/{IdProduit}")
    public ResponseEntity<Produit> updateProduit(Integer IdProduit, Produit produitDetails) {
        List<Produit> produits = ProduitService.getProduitById(IdProduit);
        if (produits.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Produit updatedProduit = produits.get(0); // Assuming one product in the list
            updatedProduit.setLibelle(produitDetails.getLibelle());
            updatedProduit.setDescription(produitDetails.getDescription());
            updatedProduit.setPrixHC(produitDetails.getPrixHC());
            updatedProduit.setPrixHT(produitDetails.getPrixHT());
            updatedProduit.setTVA(produitDetails.getTVA());
            updatedProduit.setMarque(produitDetails.getMarque());
            updatedProduit.setEtat(produitDetails.getEtat());
            updatedProduit.setCreationDate(produitDetails.getCreationDate());
            updatedProduit.setLivraisonGratuite(produitDetails.getLivraisonGratuite());
            return ResponseEntity.ok(ProduitService.saveProduit(updatedProduit));
        }
    }

    @DeleteMapping("/ProduitsD/{IdProduit}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Integer IdProduit) {
        ProduitService.deleteProduit(IdProduit);
        return ResponseEntity.noContent().build();
    }



}
