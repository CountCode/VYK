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
// lisätyt
import java.io.*; //OutputStream;

/**
 *
 * @author ilkka
 */
public class VYKTest {
    
    public VYKTest() {
    }
    
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

@Before
public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
}

@After
public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
}    
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
    /**
     * Test of main method, of class VYK.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VYK.main(args);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of verkkoja method, of class VYK.
//     */
    @Test
    public void testVerkkojaNullMatriisi() {
        System.out.println("verkkojaNull");
        int solmuja = 0;
        double tiheys = 0.0;
        int[][] expResult = null;
        int[][] result = VYK.verkkoja(solmuja, tiheys);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testVerkkoja1x1_0Matriisi() {
        System.out.println("verkkoja1x1_0");
        int solmuja = 1;
        double tiheys = 0.0;
        int[][] expResult = new int[1][1];
        expResult[0][0] = 0;
        int[][] result = VYK.verkkoja(solmuja, tiheys);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testVerkkoja1x1_1Matriisi() {
        System.out.println("verkkoja1x1_1");
        int solmuja = 1;
        double tiheys = 1.0;
        int[][] expResult = new int[1][1];
        expResult[0][0] = 1;
        int[][] result = VYK.verkkoja(solmuja, tiheys);
        assertArrayEquals(expResult, result);
    }
        
    @Test
    public void testVerkkoja12x12Matriisi() {
        System.out.println("verkkoja12x12");
        int solmuja = 12;
        double tiheys = 0.5;
        int expResult = 12;
        int[][] valiResult = VYK.verkkoja(solmuja, tiheys);
        int result = valiResult.length;
        assertEquals(expResult, result);
    }        

    /**
     * Test of tulostaVerkko method, of class VYK.
     */
    @Test
    public void testTulostaVerkkoNull() {
        System.out.println("tulostaVerkkoNUll");
        int[][] verkko = null;
        VYK.tulostaVerkko(verkko);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    /**
     * Test of tulostaVerkko method, of class VYK.
     */
    @Test
    public void testTulostaVerkko_1() {
        //System.out.println("tulostaVerkko_1");
        int[][] verkko = new int[1][1];
        verkko[0][0]=1;
        VYK.tulostaVerkko(verkko);
        assertEquals("1\n", outContent.toString());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }    

//    /**
//     * Test of vertaaAlgoritmeja method, of class VYK.
//     */
//    @Test
//    public void testVertaaAlgoritmeja() {
//        System.out.println("vertaaAlgoritmeja");
//        int solmuja = 0;
//        double tiheys = 0.0;
//        VYK.vertaaAlgoritmeja(solmuja, tiheys);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
}
