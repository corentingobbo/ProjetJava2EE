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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pedago
 */
public class DAOCommande {
    
    DataSource ds;
    
    public DAOCommande(DataSource ds){
        this.ds=ds;
        
    }
    
    public int numLigne(){
        String sql="SELECT COUNT(*) FROM Commande";
          try(Connection co = ds.getConnection();
              java.sql.Statement stm = co.createStatement();
              ResultSet rs = stm.executeQuery(sql);){ 
              if(rs.next()){
              return rs.getInt(1);
              }
              
          } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
          return 10;
          
    }

    public void newCommande (ClientEntity client) throws SQLException{
        
          int num= numLigne(); 
         
          String sql3 = "INSERT INTO commande VALUES(?,?,?,?,0,?,?,?,?,?,?,0)";
           try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql3);)
              { 
                  stm.setInt(1,num+1);
                  stm.setString(2,client.getCode());
                  stm.setString(3,"2019-12-17");
                  stm.setString(4,"2019-12-18");
                  stm.setString(5,client.getCode());
                  stm.setString(6,client.getAdresse());
                  stm.setString(7,client.getVille());
                  stm.setString(8,client.getRegion());
                  stm.setString(9,client.getCode_postal());
                  stm.setString(10,client.getPays());
                  stm.executeUpdate();
              }             
           catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
                 
    }}   
    
    public void ajouterLigne(CommandeEntity commande,ProduitEntity produit, int quantite) throws SQLException{
        commande.setPort((int) (commande.getPort()+ produit.getPrix_unitaire() * quantite));
        String sqlp="UPDATE commande SET port = ? where = ? ";
        try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sqlp);)
              {
                  stm.setInt(2,commande.getNumero());
                  stm.setInt(1, commande.getPort());
                  stm.executeUpdate();
              }
             catch (SQLException ex) {
                Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        
        
        String sql = "INSERT INTO ligne VALUES(?,?,?)";
         try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql);)
              { 
                  stm.setInt(1,commande.getNumero());
                  stm.setInt(2,produit.getReference());
                  stm.setInt(3,quantite);
                  
                  stm.executeUpdate();
              }             
           catch (SQLException exx) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);            
    }
        
    }}
    public List<CommandeEntity> rechercheCommmandeParClient(String code) {
        ArrayList<CommandeEntity> commandeByClient = new ArrayList<>();
        String sql="SELECT * FROM commande WHERE client = ?";
        try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql);){
              stm.setString(1, code);
              try(ResultSet rs = stm.executeQuery()){
                  while(rs.next()){
                      int num=rs.getInt(1);
                      String sl=rs.getString(3);
                      String el=rs.getString(4);
                      float port=rs.getFloat(5);
                      String desti=rs.getString(6);
                      String al=rs.getString(7);
                      String vl=rs.getString(8);
                      String rl=rs.getString(9);
                      String cpl=rs.getString(10);
                      String pl=rs.getString(11);
                      float remise=rs.getFloat(12);
                      CommandeEntity com=new CommandeEntity(num,code,sl,el, (int) port,desti,al,vl,rl,cpl,pl,remise);
                      commandeByClient.add(com);
                  }
              } 
              
                 
              }catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);            
    }
        return commandeByClient;
        
        
    }
    
        public HashMap<String,String> rechercheToutesCommandesParNom(String nom) {
        HashMap<String,String> map = new HashMap<>();
        String sql="select commande,SAISIE_LE, ENVOYEE_LE,PORT,ADRESSE_LIVRAISON,VILLE_LIVRAISON,CODE_POSTAL,NOM,ACCESSOIRES,PRIX_UNITAIRE,LIBELLE,CONTACT from ligne inner join commande on ligne.commande = COMMANDE.NUMERO inner join produit on produit.REFERENCE = ligne.PRODUIT inner join categorie on CATEGORIE.CODE = PRODUIT.CATEGORIE inner join client on client.CODE = COMMANDE.CLIENT where client.CONTACT = ?";
        try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql);){
              stm.setString(1, nom);
              try(ResultSet rs = stm.executeQuery()){
                  while(rs.next()){
                      map.put("commande", rs.getString("commande") );
                      map.put("saisie_le", rs.getString("saisie_le") );
                      map.put("envoyee_le", rs.getString("envoyee_le") );
                      map.put("adresse_livraison", rs.getString("adresse_livraison") );
                      map.put("ville_livraison", rs.getString("ville_livraison") );
                      map.put("code_postal", rs.getString("code_postal") );
                      map.put("nom", rs.getString("nom") );
                      map.put("prix_unitaire", rs.getString("prix_unitaire") );
                      map.put("libelle", rs.getString("libelle") );
                      map.put("contact", rs.getString("contact") );
                  }
              } 
              
                 
              }catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);            
    }
        return map;
        
        
    }
        
        
    public CommandeEntity recupereCommandeParNum(int num) throws SQLException{
        String sql="SELECT * FROM commande WHERE numero = ?";
        try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql);){
            stm.setInt(1,num);
            try(ResultSet rs = stm.executeQuery()){
                if(rs.next()){
                    String cli=rs.getString(2);
                      String sl=rs.getString(3);
                      String el=rs.getString(4);
                      float port=rs.getFloat(5);
                      String desti=rs.getString(6);
                      String al=rs.getString(7);
                      String vl=rs.getString(8);
                      String rl=rs.getString(9);
                      String cpl=rs.getString(10);
                      String pl=rs.getString(11);
                      float remise=rs.getFloat(12);
                      CommandeEntity com=new CommandeEntity(num,cli,sl,el, (int) port,desti,al,vl,rl,cpl,pl,remise);
                      return com;
                }
                      
                      
                      
            }
        }
          return null; 
    }
    
    public int  numLigneParCommande(CommandeEntity com) throws SQLException{
        String sql="SELECT COUNT(*) FROM ligne WHERE commande = ?";
         try(Connection co = ds.getConnection();
              PreparedStatement stm = co.prepareStatement(sql);){
                stm.setInt(1,com.getNumero());
                try(ResultSet rs = stm.executeQuery()){
              if(rs.next()){
              return rs.getInt(1);
              }
              
          } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        }}
          return 10;
    }
        

}
