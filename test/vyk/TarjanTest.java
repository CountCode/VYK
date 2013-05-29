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
    
    public TarjanTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Alustus method, of class Tarjan.
     */
    @Test
    public void testAlustus() {
        System.out.println("Alustus");
        int[][] verkko = null;
        Tarjan.Alustus(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SSE method, of class Tarjan.
     */
    @Test
    public void testSSE() {
        System.out.println("SSE");
        int[][] verkko = null;
        int solmu = 0;
        Tarjan.SSE(verkko, solmu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Komponentti method, of class Tarjan.
     */
    @Test
    public void testKomponentti() {
        System.out.println("Komponentti");
        Tarjan.Komponentti();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Tarjan method, of class Tarjan.
     */
    @Test
    public void testTarjan() {
        System.out.println("Tarjan");
        int[][] verkko = null;        
        Tarjan.Tarjan(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
