/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class DAOProduit {

    DataSource ds;

    public DAOProduit(DataSource ds) {
        this.ds = ds;

    }

    public List<ProduitEntity> rechercheProduitApple() {
        List<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 1 order by nom desc";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"Apple");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public List<ProduitEntity> rechercheProduitSamsung() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 2";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"Samsung");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public List<ProduitEntity> rechercheProduitHuawei() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 3";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"Huawei");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public List<ProduitEntity> rechercheProduitOnePlus() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 4";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"OnePlus");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public List<ProduitEntity> rechercheProduitXiaomi() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 5";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"Xiaomi");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }
    
        public List<ProduitEntity> rechercheProduitAsus() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 7";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"Asus");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public List<ProduitEntity> rechercheProduitSony() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 7";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"Sony");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public List<ProduitEntity> rechercheProduitNokia() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 8";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    prix = rs.getFloat(2);
                    nom = rs.getString(1);
                    stock = rs.getInt(3);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1,"Nokia");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public int isDisponible(ProduitEntity pe) {
        return pe.getIndisponible();
    }

}


