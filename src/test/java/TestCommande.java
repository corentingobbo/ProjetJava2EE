/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
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
 
    private DAOCommande dao;
    private DAOcompte daoclient;
    private ClientEntity client1;
    private DAOProduit daoprod;

    
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
        
        
    /*    
    }
    @Test
    //Creation d'une commande
    public void testnumLigne(){
        
        assertEquals("numero de ligne incorrecte",831,dao.numLigne());
    }
    
    @Test
    public void testnewCommande() throws SQLException{
        int num = dao.numLigne();
        
        dao.newCommande(client1);
        assertEquals(num+1, dao.numLigne());
    }
    
    @Test
    public void testAjouterLigne() throws SQLException{
        ProduitEntity produit=daoprod.rechercheProduitParticulier("iPhone 5");
        dao.newCommande(client1);
        CommandeEntity com= dao.recupereCommandeParNum(dao.numLigne());
        dao.ajouterLigne(com, produit, 1);
        assertTrue(com.getPort()== produit.getPrix_unitaire());
        assertEquals(dao.numLigneParCommande(com), 1);
        
    }
    
    @Test
    public void testRechercheCommandeParClient(){
        
        assertEquals(dao.rechercheCommmandeParClient(client1).size(), 4);
        
    }
    
    
    @After
    public void tearDown() {
    }

   
*/
}
