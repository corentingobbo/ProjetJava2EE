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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pedago
 */
public class DAOCommande {

    DataSource ds;

    public DAOCommande(DataSource ds) {
        this.ds = ds;

    }

    public int numLigne() {
        String sql = "SELECT COUNT(*) FROM Commande";
        try (Connection co = ds.getConnection();
                java.sql.Statement stm = co.createStatement();
                ResultSet rs = stm.executeQuery(sql);) {
            if (rs.next()) {
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
                  stm.setString(5,client.getContact());
                  stm.setString(6,client.getAdresse());
                  stm.setString(7,client.getVille());
                  stm.setString(8,client.getRegion());
                  stm.setString(9,client.getCode_postal());
                  stm.setString(10,client.getPays());
                  stm.executeUpdate();
              }             
           catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void ajouterLigne(CommandeEntity commande, ProduitEntity produit, int quantite) throws SQLException {
        commande.setPort((int) (commande.getPort() + produit.getPrix_unitaire() * quantite));
        String sqlp = "UPDATE commande SET port = ? where = ? ";
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sqlp);) {
            stm.setInt(2, commande.getNumero());
            stm.setInt(1, commande.getPort());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);

            String sql = "INSERT INTO ligne VALUES(?,?,?)";
            try (Connection co = ds.getConnection();
                    PreparedStatement stm = co.prepareStatement(sql);) {
                stm.setInt(1, commande.getNumero());
                stm.setInt(2, produit.getReference());
                stm.setInt(3, quantite);

                stm.executeUpdate();
            } catch (SQLException exx) {
                Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

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
                  System.out.println(commandeByClient);
                  return commandeByClient;
              } 
              
                 
              }catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);            
    }
        return commandeByClient;

    }

    public List<ProduitEntity> rechercheToutesCommandesParNumCommande(int code) {
        ArrayList<ProduitEntity> produit = new ArrayList<>();
        String sql = "SELECT NOM,PRIX_UNITAIRE,unites_en_stock,accessoires,libelle from LIGNE inner join COMMANDE on ligne.commande = COMMANDE.NUMERO inner join produit on produit.REFERENCE = ligne.PRODUIT inner join categorie on CATEGORIE.CODE = PRODUIT.CATEGORIE inner join client on client.CODE = COMMANDE.CLIENT where ligne.COMMANDE = ?";
        String nom, contenu;
        float prix;
        int stock;
        ProduitEntity pe;
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql);) {
            stm.setInt(1, code);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    nom = rs.getString("nom");
                    prix = rs.getFloat("prix_unitaire");
                    stock = rs.getInt("unites_en_stock");
                    contenu = rs.getString("accessoires");
                    pe = new ProduitEntity(-1, nom, -1, -1, contenu, prix, stock, -1, -1, -1, rs.getString("libelle"));
                    produit.add(pe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produit;
    }


    public CommandeEntity recupereCommandeParNum(int num) throws SQLException {
        String sql = "SELECT * FROM commande WHERE numero = ?";
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql);) {
            stm.setInt(1, num);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    String cli = rs.getString(2);
                    String sl = rs.getString(3);
                    String el = rs.getString(4);
                    float port = rs.getFloat(5);
                    String desti = rs.getString(6);
                    String al = rs.getString(7);
                    String vl = rs.getString(8);
                    String rl = rs.getString(9);
                    String cpl = rs.getString(10);
                    String pl = rs.getString(11);
                    float remise = rs.getFloat(12);
                    CommandeEntity com = new CommandeEntity(num, cli, sl, el, (int) port, desti, al, vl, rl, cpl, pl, remise);
                    return com;
                }

            }
        }
        return null;
    }

    public int numLigneParCommande(CommandeEntity com) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ligne WHERE commande = ?";
        try (Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql);) {
            stm.setInt(1, com.getNumero());
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 10;
    }
    
    public ArrayList<String> nbVentesParMarque(String marque){
        String sql = "SELECT COUNT(*) FROM LIGNE inner join categorie on ligne.PRODUIT = categorie.CODE WHERE CODE = ?";
        ArrayList<String> nbLigne= new ArrayList<>(); 
        
        try(Connection co = ds.getConnection();
            PreparedStatement stm = co.prepareStatement(sql);){
            stm.setString(0, marque);
            try(ResultSet rs = stm.executeQuery()){
                if(rs.next()){
                    nbLigne.add(marque);
                    nbLigne.add(Integer.toString(rs.getInt(1)));
                }
            }
    }   catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbLigne;
    }
    
    public HashMap<String,String> nBVentes(){
        HashMap<String,String> hm = new HashMap<>();
        ArrayList<String> al = nbVentesParMarque("Apple");
        hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("Samsung");
         hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("Huawei");
         hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("OnePlus");
         hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("Xiaomi");
         hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("Asus");
         hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("Sony");
         hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("Nokia");
         hm.put(al.get(0), al.get(1));
        al = nbVentesParMarque("Oppo");
         hm.put(al.get(0), al.get(1));
       return hm;
    }
    
    public String ventesSurAnnee(String annee){
        String sql = "SELECT COUNT(*) FROM COMMANDE WHERE SAISIE_LE BETWEEN '"+annee+"-01-01' AND '"+annee+"-12-31'";
        String str = null;
        try(Connection co = ds.getConnection();
            PreparedStatement stm = co.prepareStatement(sql);){
            try(ResultSet rs = stm.executeQuery()){
                str = Integer.toString(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    public HashMap<String,String> ventesParAnnee(){
        HashMap<String,String> hm = new HashMap<>();
        String al = null;
        for(int i = 1994 ; i < 1997 ; i++){
            al = ventesSurAnnee(Integer.toString(i));
            hm.put(Integer.toString(i), al);
        }
        return hm;
    }

    //public void newCommande(HashMap<String, String> client1) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
    public void supprimerCommande(int num) throws SQLException{
        String sql = "DELETE FROM Ligne WHERE commande = ?";
        try(Connection co = ds.getConnection();
                PreparedStatement stm = co.prepareStatement(sql);){
            stm.setInt(1,num);
            stm.executeUpdate();
        }
        String sql2 = "DELETE FROM commande WHERE numero = ?";
        try(Connection co2 = ds.getConnection();
                PreparedStatement stm2 = co2.prepareStatement(sql);){
            stm2.setInt(1,num);
            stm2.executeUpdate();
        
        }
    }
    
}
