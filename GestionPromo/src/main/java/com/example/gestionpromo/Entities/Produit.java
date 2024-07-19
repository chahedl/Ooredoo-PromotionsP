package com.example.gestionpromo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "produit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @Column(name = "idProduit")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

    private String libelle;
    private String description;
    private Float prixHC;
    private Float prixHT;
    private String TVA;
    private String marque;
    private int etat;
    private LocalDateTime creationDate;
    private int livraisonGratuite;
}
