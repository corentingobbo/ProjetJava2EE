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
import model.ProduitEntity;



public class TestProduit {
    /*
    DAOProduit dao;
    ArrayList<Object> args;
    
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
        args = new ArrayList<>();
        args.add(77);
        args.add("Pot");
        args.add(1);
        args.add(1);
        args.add("Un câble");
        args.add(654.0f);
        args.add(12);
        args.add(1);
        args.add(10);
        args.add(0);
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
     
     @Test
     public void testRechercheUnProduit(){
        ProduitEntity pe;
        pe = new ProduitEntity(1, "iPhone 5", -1, -1, "Vendu avec chargeur", 90.00f, 39, -1, -1, -1, " ");
        ProduitEntity tst = dao.rechercheProduitParticulier("iPhone 5");
        assertEquals(pe,tst);
     }
     
     @Test
     public void testAjoutProduit() throws SQLException{
         dao.ajoutProduit(args);
         assertEquals(72,dao.rechercheTousProduits().size());
     }
     
     
     */
}

