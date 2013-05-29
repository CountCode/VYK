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
public class PathBasedTest {
    
    public PathBasedTest() {
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
     * Test of Alustus method, of class PathBased.
     */
    @Test
    public void testAlustus() {
        System.out.println("Alustus");
        int[][] verkko = null;
        PathBased.Alustus(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SSE method, of class PathBased.
     */
    @Test
    public void testSSE() {
        System.out.println("SSE");
        int[][] verkko = null;
        int solmu = 0;
        PathBased.SSE(verkko, solmu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Komponentti method, of class PathBased.
     */
    @Test
    public void testKomponentti() {
        System.out.println("Komponentti");
        PathBased.Komponentti();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PathBased method, of class PathBased.
     */
    @Test
    public void testPathBased() {
        System.out.println("PathBased");
        int[][] verkko = null;
        PathBased.PathBased(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
