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

/**
 *
 * @author pedago
 */
public class DAOcompte {
    
    DataSource ds;
    
    public DAOcompte(DataSource ds){
        this.ds = ds;
    }
    
    public void modifierProfil(ClientEntity client, ArrayList<String> args){
        /*
        Si un champs est vide, il sera considéré comme null dans la bd
        Les champs obligatoires seront filtrés avec le formulaire
        */
        String sql = "UPDATE CLIENT SET"
                + "      SOCIETE = ?,"
                + "      CONTACT = ?,"
                + "      FONCTION = ?, "
                + "      ADRESSE = ?, "
                + "      VILLE = ?,"
                + "      REGION = ?, "
                + "      CODE_POSTAL = ?, "
                + "      PAYS = ?, "
                + "      TELEPHONE = ?, "
                + "      FAX = ?"
                + " WHERE CODE = ?";
        
        try(Connection co = ds.getConnection();
            PreparedStatement stm = co.prepareStatement(sql);){
            for (int i = 0; i < args.size(); i++) {
                if(args.get(i).length() < 1){
                    stm.setString(i+1, null);
            }
                else{
                    stm.setString(i+1, args.get(i));
                   
                }
            }
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOcompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /*
     * @param nomDUtilisateur le login pour se connecter
     * @param mdp le mot de passe correspondant au nom d'utilisateur
     *
    */
    
    public ClientEntity rechercheCompte(String nomDUtilisateur, String mdp){
        String sql = "SELECT * FROM CLIENT WHERE CLIENT.CONTACT = ? AND CLIENT.CODE = ?";
        String societe = null,fonction = null,adresse = null,ville = null,region = null,cp = null,pays = null,telephone = null,fax = null;
        try(Connection co = ds.getConnection();
            PreparedStatement pst = co.prepareStatement(sql)){
            pst.setString(1, nomDUtilisateur);
            pst.setString(2 , mdp);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    societe = rs.getString(2);
                    fonction = rs.getString(4);
                    adresse = rs.getString(5);
                    ville = rs.getString(6);
                    region = rs.getString(7);
                    cp = rs.getString(8);
                    pays = rs.getString(9);
                    telephone = rs.getString(10);
                    fax = rs.getString(11);                    
                }
                return new ClientEntity(mdp, societe, nomDUtilisateur, fonction,adresse,ville,region,cp,pays,telephone,fax);
            }
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
    /*
    *   @param args une liste des éléments du client [ Code (hash du nomprenom),societe,nomPrénom,fonction,adresse,ville,region,codePostal,pays,telephone,fax]
    */
    
    public void creationCompte(ArrayList<String> args){
        /*
        Si un champs non obligatoire est vide, il sera considéré comme null
        */
        String sql = "INSERT INTO CLIENT VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection co = ds.getConnection();
            PreparedStatement stm = co.prepareStatement(sql);){
            for (int i = 0; i < args.size(); i++) {
                if(args.get(i) == ""){
                    stm.setString(i+1, null);
                }
                else{
                    stm.setString(i+1, args.get(i));
                } 
            }
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOcompte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    
}
