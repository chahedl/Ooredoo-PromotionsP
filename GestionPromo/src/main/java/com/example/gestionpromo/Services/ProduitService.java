package com.example.gestionpromo.Services;

import com.example.gestionpromo.Entities.Produit;
import com.example.gestionpromo.Repos.ProduitRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProduitService {
    final ProduitRepo produitRepository ;
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }


    public List<Produit> getProduitById(Integer IdProduit){
        if (IdProduit ==  null) {
            throw new IllegalArgumentException("Code promo cannot be null");
        }
        List<Produit> produit = Collections.singletonList((Produit) produitRepository.findByIdProduit(IdProduit));
       // return produit.map(Collections::singletonList).orElse(Collections.emptyList());
       return produit;
    }


    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteProduit(Integer IdProduit) {
        produitRepository.deleteById(IdProduit);
    }
}
