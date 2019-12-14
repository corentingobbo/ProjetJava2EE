/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bryan
 */
public class DAOcompteTest {
    
    public DAOcompteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of modifierProfil method, of class DAOcompte.
     */
    @Test
    public void testModifierProfil() {
        System.out.println("modifierProfil");
        ClientEntity client = null;
        String[] args = null;
        DAOcompte instance = null;
        instance.modifierProfil(client, args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechercheCompte method, of class DAOcompte.
     */
    @Test
    public void testRechercheCompte() throws Exception {
        System.out.println("rechercheCompte");
        String nomDUtilisateur = "";
        String mdp = "";
        DAOcompte instance = null;
        ClientEntity expResult = null;
        ClientEntity result = instance.rechercheCompte(nomDUtilisateur, mdp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creationCompte method, of class DAOcompte.
     */
    @Test
    public void testCreationCompte() {
        System.out.println("creationCompte");
        String[] args = null;
        DAOcompte instance = null;
        instance.creationCompte(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
