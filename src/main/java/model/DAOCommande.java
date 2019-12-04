/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import java.sql.*;

/**
 *
 * @author pedago
 */
public class DAOCommande {
    
    DataSource ds;
    
    public DAOCommande(){
        
    }
    
    public CommandeEntity creerCommande (int num, String client, String saisie, String Envoye, int port, String desti, String adresse, String ville, String region, String codeP,String pays, float remise){
        return null;
        
    }
    /**
    public void newCommande (ClientEntity client) throws SQLException{
        
          ///num derniere ligne 
          String sql="SELECT COUNT(*) FROM Commande";
          try(Connection co = ds.getConnection();
              java.sql.Statement stm = co.createStatement();
              ResultSet rs = stm.executeQuery(sql);){              
          } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
          Date auj = new Date();
          
          
          String sql3 = "INSERT INTO commande VALUES(?,?,?,?,0,?,?,?,?,?,?,0)";
           try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql3);)
              { 
                  stm.setInt(1,rs.getInt(1)+1);
                  stm.setClientEntity(2,client);
                  stm.setDate(3,auj);
                  stm.setDate(4,auj);
                  stm.setClientEntity(5,client);
                  stm.setString(6,client.getAdresse_livraison);
                  stm.setString(7,client.getVille_livraison);
                  stm.setString(8,client.getRegion_livraison);
                  stm.setString(9,client.getCode_postal_livraison);
                  stm.setString(10,client.getPays_livraison);
                  stm.executeUpdate();
              }             
          } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
                 
    }
    public void validerCommande(){
        
    };
    
    public void ajouterLigne(CommandeEntity commande,ProduitEntity produit, int quantite){
        commande.getPort() += produit.getPrix_Unitaire * quantite;
        String sqlp="UPDATE commande SET port = ?";
        
        
        String sql = "INSERT INTO ligne VALUES(?,?,?)";
         try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql);)
              { 
                  stm.setInt(1,commande);
                  stm.setClientEntity(2,produit);
                  stm.setDate(3,quantite);
                  
                  stm.executeUpdate();
              }             
          } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);            
    }
        
        return new ligneEntity(commande,produit,quantite);
    }
    public CommandeEntity rechercheCommmandeParClient(){
        return null;
    }**/
    
}
