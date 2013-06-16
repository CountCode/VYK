/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vyk;

import algoritmit.Tarjan;
import tietorakenteet.HakuPuu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ilkka
 */
public class TarjanTest {
    
   /* Testimatriisit */
   /** 
   * Tira luentokalvot s. 499
   * Komponentit:
   * {0,1,4},{2},{3,7},{5,6}
   */
     static int[][] esim1 = new int[][] {
        {0, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0}};
     
     
    /** 
    * Cormen s. 615
    * Komponentit:
    * {0,1,4},{2,3},{5,6},{7}
    */
     static int[][] esim2 = new int[][] {
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 1}};     
     
    /** 
    * http://en.wikipedia.org/wiki/Tarjan's_strongly_connected_components_alorithm
    * Komponentit:
    * {0,1,4},{2,3},{5,6},{7}
    */
     static int[][] esim3 = new int[][] {
        {0, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 1}};
     
    /** 
    *  Yksi lenkki
    *  Komponentit:
    *  {0,1,2,3,4,5,6,7}
    */
     static int[][] esim4 = new int[][] {
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0}};
     
    /** 
    *  Jokainen itsensä kanssa
    *  Komponentit:
    *  {{0},{1},{2},{3},{4},{5},{6},{7}}
    */
     static int[][] esim5 = new int[][] {
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 1}};      
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of alustus method, of class Tarjan.
     */
    @Test
    public void testAlustus() {
        System.out.println("alustus");
        int[][] verkko = null;
        Tarjan.alustus(verkko);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sse method, of class Tarjan.
     */
    @Test
    public void testSse() {
        System.out.println("sse");
        int[][] verkko = null;
        int solmu = 0;
        Tarjan.sse(verkko, solmu);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of tulostaKomponentti method, of class Tarjan.
     */
    @Test
    public void testTulostaKomponenttiTyhja() {
        System.out.println("tulostaKomponentti");
        HakuPuu testi = new HakuPuu();
        Tarjan.komponentti=testi;
        
        assertEquals("{}",Tarjan.tulostaKomponentti());
    }    
    
    /**
     * Test of tulostaKomponentti method, of class Tarjan.
     */
    @Test
    public void testTulostaKomponentti() {
        System.out.println("tulostaKomponentti");
        HakuPuu testi = new HakuPuu();
        testi.add(1);
        testi.add(4);
        Tarjan.komponentti=testi;
        
        assertEquals("{1,4}",Tarjan.tulostaKomponentti());
    } 
    
    @Test
    public void testVerkkoEsim1(){
        int[][] verkko=esim1;
        String testi = Tarjan.tarjan(verkko);
        assertEquals("{{1,4,0}{5,6}{2}{7,3}}",testi);
    }
    
    @Test
    public void testVerkkoEsim2(){
        int[][] verkko=esim2;
        String testi = Tarjan.tarjan(verkko);
        assertEquals("{{7}{5,6}{3,2}{4,1,0}}",testi);
    }    

    @Test
    public void testVerkkoEsim3(){
        int[][] verkko=esim3;
        String testi = Tarjan.tarjan(verkko);
        assertEquals("{{1,4,0}{3,2}{6,5}{7}}",testi);
    }    
    
    @Test
    public void testVerkkoEsim4(){
        int[][] verkko=esim4;
        String testi = Tarjan.tarjan(verkko);
        assertEquals("{{7,6,5,4,3,2,1,0}}",testi);
    } 

    @Test
    public void testVerkkoEsim5(){
        int[][] verkko=esim5;
        String testi = Tarjan.tarjan(verkko);
        assertEquals("{{0}{1}{2}{3}{4}{5}{6}{7}}",testi);
    }      

    /**
     * Test of tarjan method, of class Tarjan.
     */
    @Test
    public void testTarjan() {
        System.out.println("tarjan");
        int[][] verkko = null;
        Tarjan.tarjan(verkko);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}
