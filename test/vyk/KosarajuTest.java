/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vyk;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
// Lisätyt
import java.util.TreeSet;

/**
 *
 * @author ilkka
 */
public class KosarajuTest {
    
      static int[][] esim1 = new int[][] {
        {0, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0}};
      
      static int[][] esim1Transpoosi = new int[][] {
        {0, 1, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 0, 1, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 0}};      
    
//    public KosarajuTest() {
//    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of ekaAlustus method, of class Kosaraju.
     */
//    @Test
//    public void testEkaAlustus() {
//        System.out.println("ekaAlustus");
//        int[][] verkko = null;
//        Kosaraju.ekaAlustus(verkko);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of tokaAlustus method, of class Kosaraju.
     */
//    @Test
//    public void testTokaAlustus() {
//        System.out.println("tokaAlustus");
//        int[][] verkko = null;
//        Kosaraju.tokaAlustus(verkko);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of tulostaKomponentti method, of class Kosaraju.
     */
//    @Test
//    public void testTulostaKomponentti() {
//        System.out.println("tulostaKomponentti");
//        Kosaraju.tulostaKomponentti();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of sse method, of class Kosaraju.
     */
//    @Test
//    public void testSse() {
//        System.out.println("sse");
//        int[][] verkko = null;
//        int solmu = 0;
//        Kosaraju.sse(verkko, solmu);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of transpoosi method, of class Kosaraju.
     */
    @Test
    public void testTranspoosiTyhjaMatriisi() {
        System.out.println("transpoosiNull");
        int[][] verkko = null;
        int[][] expResult = null;
        int[][] result = Kosaraju.transpoosi(verkko);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testTranspoosi1x1Matriisi() {
        System.out.println("transpoosi1x1");
        int[][] verkko = new int[1][1];
        int[][] expResult = new int[1][1];
        verkko[0][0]=1;
        expResult[0][0]=1;
        int[][] result = Kosaraju.transpoosi(verkko);
        assertArrayEquals(expResult, result);
    }
    
        @Test
    public void testTranspoosi8x8Matriisi() {
        System.out.println("transpoosi8x8");
        int[][] verkko = esim1;
        int[][] expResult = esim1Transpoosi;
        int[][] result = Kosaraju.transpoosi(verkko);
        assertArrayEquals(expResult, result);
    } 
    
    /**
     * Test of kosaraju method, of class Kosaraju.
     */
//    @Test
//    public void testKosaraju() {
//        System.out.println("kosaraju");
//        int[][] verkko = null;
//        Kosaraju.kosaraju(verkko);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
