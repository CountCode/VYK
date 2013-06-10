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
    
   /* TESTIMATRIISEJA */ 
      
      static int[][] esim1Transpoosi = new int[][] {
        {0, 1, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 0, 1, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 0}};   
      
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
     * Test of ekaAlustus method, of class Kosaraju.
     */
    @Test
    public void testEkaAlustus() {
        System.out.println("ekaAlustus");
        int[][] verkko = null;
        Kosaraju.ekaAlustus(verkko);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tokaAlustus method, of class Kosaraju.
     */
    @Test
    public void testTokaAlustus() {
        System.out.println("tokaAlustus");
        int[][] verkko = null;
        Kosaraju.tokaAlustus(verkko);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

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
    @Test
    public void testSse() {
        System.out.println("sse");
        int[][] verkko = null;
        int solmu = 0;
        Kosaraju.sse(verkko, solmu);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

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
     * Test of tulostaKomponentti method, of class Tarjan.
     */
    @Test
    public void testTulostaKomponenttiTyhja() {
        System.out.println("tulostaKomponentti");
        HakuPuu testi = new HakuPuu();
        Kosaraju.komponentti=testi;
        
        assertEquals("{}",Kosaraju.tulostaKomponentti());
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
        Kosaraju.komponentti=testi;
        
        assertEquals("{1,4}",Kosaraju.tulostaKomponentti());
    }       
        
    @Test
    public void testVerkkoEsim1(){
        int[][] verkko=esim1;
        String testi = Kosaraju.kosaraju(verkko);
        assertEquals("{{3,7}{2}{6,5}{0,1,4}}",testi);
    }
    
    @Test
    public void testVerkkoEsim2(){
        int[][] verkko=esim2;
        String testi = Kosaraju.kosaraju(verkko);
        assertEquals("{{0,4,1}{2,3}{6,5}{7}}",testi);
    }    

    @Test
    public void testVerkkoEsim3(){
        int[][] verkko=esim3;
        String testi = Kosaraju.kosaraju(verkko);
        assertEquals("{{7}{5,6}{2,3}{0,1,4}}",testi);
    }    
    
    @Test
    public void testVerkkoEsim4(){
        int[][] verkko=esim4;
        String testi = Kosaraju.kosaraju(verkko);
        assertEquals("{{0,7,6,5,4,3,2,1}}",testi);
    } 

    @Test
    public void testVerkkoEsim5(){
        int[][] verkko=esim5;
        String testi = Kosaraju.kosaraju(verkko);
        assertEquals("{{7}{6}{5}{4}{3}{2}{1}{0}}",testi);
    }     
    
    /**
     * Test of kosaraju method, of class Kosaraju.
     */
    @Test
    public void testKosaraju() {
        System.out.println("kosaraju");
        int[][] verkko = null;
        Kosaraju.kosaraju(verkko);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
