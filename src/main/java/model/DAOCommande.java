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
    public CommandeEntity newCommande (ClientEntity client){
        
          ///num derniere ligne 
          String sql="SELECT COUNT(*) FROM Commande";
          try(Connection co = ds.getConnection();
              java.sql.Statement stm = co.createStatement();
              ResultSet rs = stm.executeQuery(sql);){              
          } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
          String sql2 = "SELECT DATE( NOW() )"; 
          try(Connection co = ds.getConnection();
              java.sql.Statement stm = co.createStatement();
              ResultSet rs2 = stm.executeQuery(sql2)){              
          } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         // destinataire,adresse,ville,region,code,pays: client
         //remise
         
      
        return new CommandeEntity(rs,this.client,rs2,rs2);
                
    }
    public void validerCommande(){
        
    };
    
}
