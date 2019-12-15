/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import model.ClientEntity;
import model.DAOCommande;
import model.DAOcompte;
import model.DataSourceFactory;
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
        //client1 = daoclient.rechercheCompte("Maria Anders", "ALFKI");
        
        
    }
    @Test
    //Creation d'une commande
    public void testnumLigne(){
        
        assertEquals("numero de ligne incorrecte",830,dao.numLigne());
    }
    
    @Test
    public void testnewCommande() throws SQLException{
        int num = dao.numLigne();
        
        dao.newCommande(client1);
        assertEquals(num+1, dao.numLigne());
    }
    
    
    
    
    
    
    @After
    public void tearDown() {
    }

     //TODO add test methods here.
     //The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void hello() {}

}
