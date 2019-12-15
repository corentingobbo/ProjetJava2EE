/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
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
public class TestClient {
    
    DAOcompte dao;
    ArrayList<String> args;
    ArrayList<String> creation;
    
    public TestClient() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new DAOcompte(DataSourceFactory.getDataSource());
        //liste d'arguments pour la recherche et la modification d'un profil
        args = new ArrayList<>();
        args.add("Pomme");
        args.add("Thomas Hardy");
        args.add("Représentant(e)");
        args.add("120 Hanover Sq.");
        args.add("London");
        args.add("Johto");
        args.add("WA1 1DP");
        args.add("Royaume-Uni");
        args.add("(71) 555-7788");
        args.add("(71) 555-6750");
        args.add("AROUT");
        
        //liste d'arguments pour la création d'un compte
        creation = new ArrayList<>();
        creation.add("CHAMP");
        creation.add("Champollion");
        creation.add("Bryan Franco");
        creation.add("Etudiant(e)");
        creation.add("10 rue Saint-Antoine");
        creation.add("Albi");
        creation.add("Occitanie");
        creation.add("81000");
        creation.add("France");
        creation.add("0564528745");
        creation.add("0564528745");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRechercheProfil() throws SQLException{
        ClientEntity c = new ClientEntity("AROUT","Around the Horn","Thomas Hardy","Représentant(e)","120 Hanover Sq.","London",null,"WA1 1DP","Royaume-Uni","(71) 555-7788","(71) 555-6750");
        ClientEntity c1 = dao.rechercheCompte("Thomas Hardy", "AROUT");
        assertEquals("Société : ", c.getSociete(),c1.getSociete());
        assertEquals("Fonction : ", c.getFonction(),c1.getFonction());
        assertEquals("Adresse : ", c.getAdresse(),c1.getAdresse());
        assertEquals("Ville : ",c.getVille(),c1.getVille());
    }
    
    @Test
    public void testModification() throws SQLException{
        ClientEntity c = dao.rechercheCompte("Thomas Hardy", "AROUT");
        dao.modifierProfil(c, args);
        ClientEntity c2 = new ClientEntity("AROUT","Pomme","Thomas Hardy","Représentant(e)","120 Hanover Sq.","London","Johto","WA1 1DP","Royaume-Uni","(71) 555-7788","(71) 555-6750");
        ClientEntity c3 = dao.rechercheCompte("Thomas Hardy", "AROUT");
        assertEquals(c2.toString(), c3.toString() );
    }
    
    @Test
    public void testCreation(){
        dao.creationCompte(creation);
        ClientEntity c = new ClientEntity("CHAMP","Champollion","Bryan Franco","Etudiant(e)","10 rue Saint-Antoine","Albi","Occitanie","81000","France","0564528745","0564528745");
        ClientEntity c2 = dao.rechercheCompte("Bryan Franco", "CHAMP");
        assertEquals(c.toString(),c2.toString());
    }
}
