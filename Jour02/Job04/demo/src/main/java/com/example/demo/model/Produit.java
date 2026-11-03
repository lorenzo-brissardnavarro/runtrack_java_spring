package com.example.demo.model;

public class Produit {
    private String nom;
    private int prix;

    public Produit(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() { 
        return nom; 
    }

    public int getPrix() { 
        return prix; 
    }
}

