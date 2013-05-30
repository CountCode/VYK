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

/**
 *
 * @author ilkka
 */
public class TarjanTest {

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
    
//    public TarjanTest() {
//    }
//    
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
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of alustus method, of class Tarjan.
//     */
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
//
//    /**
//     * Test of tulostaKomponentti method, of class Tarjan.
//     */
//    @Test
//    public void testTulostaKomponentti() {
//        System.out.println("tulostaKomponentti");
//        Tarjan.tulostaKomponentti();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

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
