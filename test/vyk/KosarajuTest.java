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
public class KosarajuTest {
    
    public KosarajuTest() {
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
     * Test of Alustus1 method, of class Kosaraju.
     */
    @Test
    public void testAlustus1() {
        System.out.println("Alustus1");
        int[][] verkko = null;
        Kosaraju.Alustus1(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Alustus2 method, of class Kosaraju.
     */
    @Test
    public void testAlustus2() {
        System.out.println("Alustus2");
        int[][] verkko = null;
        Kosaraju.Alustus2(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Komponentti method, of class Kosaraju.
     */
    @Test
    public void testKomponentti() {
        System.out.println("Komponentti");
        Kosaraju.Komponentti();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SSE method, of class Kosaraju.
     */
    @Test
    public void testSSE() {
        System.out.println("SSE");
        int[][] verkko = null;
        int solmu = 0;
        Kosaraju.SSE(verkko, solmu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Transpoosi method, of class Kosaraju.
     */
    @Test
    public void testTranspoosi() {
        System.out.println("Transpoosi");
        int[][] verkko = null;
        int[][] expResult = null;
        int[][] result = Kosaraju.Transpoosi(verkko);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Kosaraju method, of class Kosaraju.
     */
    @Test
    public void testKosaraju() {
        System.out.println("Kosaraju");
        int[][] verkko = null;        
        Kosaraju.Kosaraju(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
