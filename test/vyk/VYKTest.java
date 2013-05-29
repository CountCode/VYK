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
public class VYKTest {
    
    public VYKTest() {
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
     * Test of main method, of class VYK.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VYK.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verkkoja method, of class VYK.
     */
    @Test
    public void testVerkkoja() {
        System.out.println("verkkoja");
        int solmuja = 0;
        double tiheys = 0.0;
        int[][] expResult = null;
        int[][] result = VYK.verkkoja(solmuja, tiheys);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tulostaVerkko method, of class VYK.
     */
    @Test
    public void testTulostaVerkko() {
        System.out.println("tulostaVerkko");
        int[][] verkko = null;
        VYK.tulostaVerkko(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
