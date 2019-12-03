/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedago
 */
public class ProduitEntity {
    private int reference;
    private String nom;
    private int fournisseur;
    private int categorie;
    private String marque;
    private float prix_unitaire;
    private int unite_en_stock;
    private int unite_commandees;
    private int niveau_de_reappro;
    private int indisponible;

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String quantite_par_unite) {
        this.marque = quantite_par_unite;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getUnite_en_stock() {
        return unite_en_stock;
    }

    public void setUnite_en_stock(int unite_en_stock) {
        this.unite_en_stock = unite_en_stock;
    }

    public int getUnite_commandees() {
        return unite_commandees;
    }

    public void setUnite_commandees(int unite_commandees) {
        this.unite_commandees = unite_commandees;
    }

    public int getNiveau_de_reappro() {
        return niveau_de_reappro;
    }

    public void setNiveau_de_reappro(int niveau_de_reappro) {
        this.niveau_de_reappro = niveau_de_reappro;
    }

    public int getIndisponible() {
        return indisponible;
    }

    public void setIndisponible(int indisponible) {
        this.indisponible = indisponible;
    }
    
    
}
