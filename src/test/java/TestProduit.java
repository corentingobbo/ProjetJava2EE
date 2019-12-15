/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAOProduit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.DataSourceFactory;



public class TestProduit {
    
    DAOProduit dao;
    
    public TestProduit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new DAOProduit(DataSourceFactory.getDataSource());

    }
    
    @After
    public void tearDown() {
    }

    @Test
     public void produitsApple() throws SQLException {
         String sql = "SELECT COUNT(*) AS NBPRODUIT FROM PRODUIT INNER JOIN CATEGORIE ON categorie.code = PRODUIT.categorie where categorie = 1";
         try (Connection co = dao.getDataSource().getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            try (ResultSet rs = stm.executeQuery()) {
                System.out.println(rs.next());
                int nb = rs.getInt(1);
                System.out.println(nb);
                assertEquals(nb, dao.rechercheProduitApple().size());
            }
         }
     }
     
     @Test 
     public void produitMarque() throws SQLException{
         String sql = "SELECT COUNT(*) FROM PRODUIT WHERE CATEGORIE = ?";
         try (Connection co = dao.getDataSource().getConnection();
                PreparedStatement stm = co.prepareStatement(sql)) {
            stm.setInt(1, 1); // On va comparer la recherche par marque avec la recherche des produits Apple, déjà testé précédemment
            try (ResultSet rs = stm.executeQuery()) {
                System.out.println(rs.next());
                int nb = rs.getInt(1);
                System.out.println(nb);
                assertEquals(nb, dao.rechercheParMarque("Apple").size());
            }
         }
     }
     
     @Test
     public void multipleMarque(){
         //On sait que la recherche par marque fonctionne
         int nb = dao.rechercheParMarque("Apple").size() + dao.rechercheParMarque("Samsung").size();
         ArrayList<String> marques = new ArrayList<>();
         marques.add("Apple");
         marques.add("Samsung");
         int nb2 = dao.rechercheParMultipleMarque(marques).size();
         assertEquals(nb,nb2);
     }
     
     @Test
     public  void testPrix(){
         assertEquals(51,dao.rechercheParPlageDePrix(0, 400).size());
     }
            
     
     
     
}

