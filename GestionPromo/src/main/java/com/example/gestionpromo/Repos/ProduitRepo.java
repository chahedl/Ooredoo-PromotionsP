package com.example.gestionpromo.Repos;



import com.example.gestionpromo.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Integer> {
     /*@Query("SELECT p FROM Produit p WHERE p.IdProduit = :idProduit")
        Produit findByIdProduit(@Param("idProduit") int idProduit);
      */
     List<Produit> findByIdProduit(int idProduit);

}
