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

    public DataSource getDataSource() {
        return this.ds;
    }

    // Affichage des produits d'une marque dans la page de cette marque
    public List<ProduitEntity> rechercheProduitApple() {
        List<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK,ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 1 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1, "Apple");
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
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK,ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 2 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1, "Samsung");
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
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK,ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 3 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1, "Huawei");
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
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK, ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 4 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1, "OnePlus");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    public List<ProduitEntity> rechercheProduitOppo() {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK, ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 9 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1, "Oppo");
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
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 5 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1, "Xiaomi");
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
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK, ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 6 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, "Apple", prix, stock, -1, -1, -1, "Asus");
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
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK, ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 7 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, contenu, prix, stock, -1, -1, -1, "Sony");
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
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK, ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 8 order by prix_unitaire desc";
        String nom, contenu;
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
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, contenu, prix, stock, -1, -1, -1, "Nokia");
                    produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    // Affichage des produits selon une marque via un formulaire de recherche
    public List<ProduitEntity> rechercheParMarque(String marque) {
        ArrayList<ProduitEntity> produit = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK,ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where libelle = ? order by prix_unitaire desc";
        String nom, contenu;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql);) {
            stm.setString(1, marque);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    nom = rs.getString(1);
                    prix = rs.getFloat(2);
                    stock = rs.getInt(3);
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, contenu, prix, stock, -1, -1, -1, marque);
                    produit.add(pe);
                }
                return produit;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produit;
    }

    public List<ProduitEntity> rechercheParMarqueEtPrix(String marque, float min, float max) {
        ArrayList<ProduitEntity> produit = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK,ACCESSOIRES FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where libelle = ? and PRIX_UNITAIRE BETWEEN ? AND ?  order by prix_unitaire desc";
        String nom, contenu;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql);) {
            stm.setString(1, marque);
            stm.setFloat(2, min);
            stm.setFloat(3, max);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    nom = rs.getString(1);
                    prix = rs.getFloat(2);
                    stock = rs.getInt(3);
                    contenu = rs.getString(4);
                    pe = new ProduitEntity(-1, nom, -1, -1, contenu, prix, stock, -1, -1, -1, marque);
                    produit.add(pe);
                }
                return produit;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produit;
    }

    public List<ProduitEntity> rechercheParMultipleMarqueEtPrix(ArrayList<String> marques, float min, float max) {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        for (int i = 0; i < marques.size(); i++) {
            List<ProduitEntity> pr = rechercheParMarqueEtPrix(marques.get(i), min, max);
            for (int j = 0; j < pr.size(); j++) {
                produits.add(pr.get(j));
            }
        }
        return produits;
    }

    public List<ProduitEntity> rechercheParMultipleMarque(ArrayList<String> marques) {
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        for (int i = 0; i < marques.size(); i++) {
            List<ProduitEntity> pr = rechercheParMarque(marques.get(i));
            for (int j = 0; j < pr.size(); j++) {
                produits.add(pr.get(j));
            }
        }
        return produits;
    }

    public List<ProduitEntity> rechercheParPlageDePrix(float min, float max) {
        ArrayList<ProduitEntity> produit = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,ACCESSOIRES,UNITES_EN_STOCK,ACCESSOIRES FROM PRODUIT WHERE PRIX_UNITAIRE BETWEEN ? AND ?";
        String nom, contenu;
        float prix;
        int stock;
        ProduitEntity pe;

        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql);) {
            stm.setFloat(1, min);
            stm.setFloat(2, max);

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    nom = rs.getString("NOM");
                    prix = rs.getFloat("PRIX_UNITAIRE");
                    stock = rs.getInt("UNITES_EN_STOCK");
                    contenu = rs.getString("ACCESSOIRES");
                    pe = new ProduitEntity(-1, nom, -1, -1, contenu, prix, stock, -1, -1, -1, " ");
                    produit.add(pe);
                }
                return produit;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produit;
    }

    public int isDisponible(ProduitEntity pe) {
        return pe.getIndisponible();
    }

}
