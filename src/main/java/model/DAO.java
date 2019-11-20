/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author pedago
 */
public class DAO {
    
    public List<CategorieEntity> montrerCategories(){
        return new List<>();
    }
    
    public List<ArticleEntity> articlesParCatégorie(String categorie){
        List<ArticleEntity> articles = new ArrayList<>();
        return  articles;
    }
    
    // Le client peut modifier son profil
    
    public void modifierProfil(ClientEntity client,String nomPrenom,String fonction, String addresse, String ville, String codePostal, String pays, String telephone){
        
    }
    
    //Gestion du caddie
    
    public void ajoutCaddie(ArticleEntity a, int n){
        
    }
    
    public void modifierCaddie(){
        
    }
    
    public void supprimerArticleCaddie(ArticleEntity a){
        
    }
    
    public CommandeEntity nouvelleCommande(){
        
    }
    
    
    
}
