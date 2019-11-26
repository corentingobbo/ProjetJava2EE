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
    
    public void modifierProfil(ClientEntity client,String nomPrenom,String fonction, String addresse, String ville, String codePostal, String pays, String telephone){
        /*
        Si un champs est vide, il sera considéré comme null dans la bd
        */
        
    }
    
    /*
     * @param nomDUtilisateur le login pour se connecter
     * @param mdp le mot de passe correspondant au nom d'utilisateur
     *
    */
    
    public ClientEntity rechercheCompte(String nomDUtilisateur, String mdp) throws SQLException{
        String sql = "SELECT * FROM CLIENT WHERE CONTACT = ? AND CODE = ?";
        String societe,fonction,adresse,ville,region,cp,pays,telephone,fax;
        try(Connection co = ds.getConnection();
            PreparedStatement pst = co.prepareStatement(sql)){
            pst.setString(0, nomDUtilisateur);
            pst.setString(1, mdp);
            try(ResultSet rs = pst.executeQuery()){
                societe = rs.getString("societe");
                fonction = rs.getString("fonction");
                adresse = rs.getString("adresse");
                ville = rs.getString("ville");
                region = rs.getString("region");
                cp = rs.getString("code_postal");
                pays = rs.getString("pays");
                telephone = rs.getString("telephone");
                fax = rs.getString("fax");
            }
        }
        return new ClientEntity(mdp, societe, nomDUtilisateur, fonction,adresse,ville,region,cp,pays,telephone,fax);
    }
    
    public void creationCompte(String societe, String contact, String fonction, String adresse, String ville, String region, String codePostal,String pays, String telephone, String fax){
        /*
        Si un champs non obligatoire est vide, il sera considéré comme null
        */
    }
      
    
}
