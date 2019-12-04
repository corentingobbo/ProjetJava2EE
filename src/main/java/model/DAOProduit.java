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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class DAOProduit {
    
    DataSource ds;
    
    public DAOProduit(DataSource ds){
        this.ds = ds;
        
    }
    
    public List<ProduitEntity> rechercheProduitApple(){
        ArrayList<ProduitEntity> produits = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,UNITES_EN_STOCK FROM PRODUIT WHERE MARQUE = 'Apple'";
        String nom;
        float prix;
        int stock;
        ProduitEntity pe;
        try(Connection co = ds.getConnection();
            PreparedStatement stm = co.prepareStatement(sql)){
            try(ResultSet rs = stm.executeQuery()){
                while(rs.next()){
                   prix = rs.getFloat(2);
                   nom = rs.getString(1);
                   stock = rs.getInt(3);
                    pe = new ProduitEntity(-1,nom,-1,-1,"Apple",prix,stock,-1,-1,-1);
                   produits.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }
    
    public int isDisponible(ProduitEntity pe){
        return pe.getIndisponible();
    } 
    
}
