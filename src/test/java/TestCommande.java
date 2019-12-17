/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.HashMap;
import model.ClientEntity;
import model.CommandeEntity;
import model.DAOCommande;
import model.DAOProduit;
import model.DAOcompte;
import model.DataSourceFactory;
import model.ProduitEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCommande {

    /*
    private DAOCommande dao;
    private DAOcompte daoclient;
    private HashMap<String,String> client1;
    private DAOProduit daoprod;
    private ClientEntity client2;

    
    public TestCommande() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        dao = new DAOCommande(DataSourceFactory.getDataSource());
        daoclient = new DAOcompte(DataSourceFactory.getDataSource());
        daoprod = new DAOProduit(DataSourceFactory.getDataSource());
        client1 = daoclient.rechercheCompte("Maria Anders", "ALFKI");
        client2 = daoclient.rechercheCompte2("Maria Anders", "ALFKI");
        
        
   
    }
    @Test
    //Creation d'une commande
    public void testnumLigne(){
        
        assertEquals("numero de ligne incorrecte",831,dao.numLigne());
    }
    
    @Test
    public void testnewCommande() throws SQLException{
        int num = dao.numLigne();
        
        dao.newCommande(client2);
        assertEquals(num+1, dao.numLigne());
        dao.supprimerCommande(dao.numLigne());
    }
    
    @Test
    public void testAjouterLigne() throws SQLException{
        ProduitEntity produit=daoprod.rechercheProduitParticulier("iPhone 5");
        dao.newCommande(client2);
        CommandeEntity com= dao.recupereCommandeParNum(dao.numLigne());
        dao.ajouterLigne(com, produit, 1);
        assertTrue(com.getPort()== produit.getPrix_unitaire());
        assertEquals(dao.numLigneParCommande(com), 1);
        dao.supprimerCommande(dao.numLigne());
        
    }
    
    @Test
    public void testRechercheCommandeParClient() throws SQLException{
        
        assertEquals(dao.rechercheCommmandeParClient("ALFKI").size(), 4);

        
        
    }
    @Test
    public void testNumLigneParCommande() throws SQLException{
        dao.newCommande(client2);
        CommandeEntity com= dao.recupereCommandeParNum(dao.numLigne());
        ProduitEntity produit=daoprod.rechercheProduitParticulier("iPhone 5");
        dao.ajouterLigne(com, produit, 1);
        assertEquals(dao.numLigneParCommande(com), 1);
        dao.supprimerCommande(dao.numLigne());
        
        
    } 
    @Test
    public void testSupprimerCommande() throws SQLException{
        
        dao.newCommande(client2);
        CommandeEntity com= dao.recupereCommandeParNum(dao.numLigne());
        ProduitEntity produit=daoprod.rechercheProduitParticulier("iPhone 5");
        dao.ajouterLigne(com, produit, 1);
        int num=dao.numLigne();
        dao.supprimerCommande(dao.numLigne());
        assertEquals(dao.numLigne(), num-1);
        assertEquals(dao.numLigneParCommande(com), 0);
        
        
    }
    
    
    @After
    public void tearDown() {
    }

   
*/


}
