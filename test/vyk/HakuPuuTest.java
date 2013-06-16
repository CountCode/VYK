package vyk;

import tietorakenteet.PuuSolmu;
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
public class HakuPuuTest {
    
    public HakuPuuTest() {
    }
    
    @Test
    public void konstrutoriHakupuuTyhja(){
        HakuPuu hakuPuu = new HakuPuu();
        
        assertEquals(true,hakuPuu.isEmpty());
    }
    
    @Test
    public void konstruktoriHakuPuu(){
        HakuPuu hakuPuu = new HakuPuu(2);
        
        assertEquals(false,hakuPuu.isEmpty());
    }

    @Test
    public void lisaaPoistaSolmuTyhja(){
        HakuPuu hakuPuu = new HakuPuu(2);        
        hakuPuu.pollFirst();             
        
        assertEquals(true,hakuPuu.isEmpty());
    }    
    
    @Test
    public void lisaaPoistaSolmuEiTyhja(){
        HakuPuu hakuPuu = new HakuPuu(2);
        hakuPuu.add(1);
        hakuPuu.pollFirst();             
        
        assertEquals(false,hakuPuu.isEmpty());
    }       
    
    @Test
    public void lisaaPoistaSolmu_0(){
        HakuPuu hakuPuu = new HakuPuu(2);        
                
        assertEquals(2,hakuPuu.pollFirst());
    }
    
    @Test
    public void lisaaSuurempiPoistaJuuri(){
        HakuPuu hakuPuu = new HakuPuu(2);
        hakuPuu.add(3);
                
        assertEquals(2,hakuPuu.pollFirst());
    }
    
    @Test
    public void lisaaPienempiPoistaJuuri(){
        HakuPuu hakuPuu = new HakuPuu(2);
        hakuPuu.add(1);
                
        assertEquals(2,hakuPuu.pollFirst());
    }    
 
    @Test
    public void lisaaPoistaSolmu_2(){
        HakuPuu hakuPuu = new HakuPuu(2);
        hakuPuu.add(3);
        hakuPuu.add(1);
        hakuPuu.add(5);
        hakuPuu.add(6);

        hakuPuu.pollFirst(); // 2
        hakuPuu.pollFirst(); // 3       
                
        assertEquals(5,hakuPuu.pollFirst());
    }   
    
    @Test
    public void lisaaSamaSolmuTyhja(){
        HakuPuu hakuPuu = new HakuPuu(2);
        hakuPuu.add(2);
        hakuPuu.add(2);
        hakuPuu.add(2);        

        hakuPuu.pollFirst(); // 2     
                
        assertEquals(true,hakuPuu.isEmpty());
    }
    
    @Test
    public void lisaaSamaSolmuEiTyhja(){
        HakuPuu hakuPuu = new HakuPuu(2);
        hakuPuu.add(2);
        hakuPuu.add(1);        
        hakuPuu.add(2);
        hakuPuu.add(2);        

        hakuPuu.pollFirst(); // 2     
                
        assertEquals(false,hakuPuu.isEmpty());
    }       
    
    
    @Test
    public void pieninSolmuVasemmalla(){
        HakuPuu hakuPuu = new HakuPuu(3);
        hakuPuu.add(2);
        hakuPuu.add(1);
        hakuPuu.add(5);
        hakuPuu.add(6);
        
        PuuSolmu solmu = hakuPuu.pienin(hakuPuu.getJuuri());
        
        assertEquals(1, solmu.getAvain());
    }
 
    @Test
    public void pieninSolmuJuuri(){
        HakuPuu hakuPuu = new HakuPuu(1);
        hakuPuu.add(3);
        hakuPuu.add(2);
        hakuPuu.add(5);
        hakuPuu.add(6);
        
        PuuSolmu solmu = hakuPuu.pienin(hakuPuu.getJuuri());
        
        assertEquals(1, solmu.getAvain());
    }    
   
    @Test
    public void suurinSolmuOikealla(){
        HakuPuu hakuPuu = new HakuPuu(3);
        hakuPuu.add(2);
        hakuPuu.add(1);
        hakuPuu.add(5);
        hakuPuu.add(6);
        
        PuuSolmu solmu = hakuPuu.suurin(hakuPuu.getJuuri());
        
        assertEquals(6, solmu.getAvain());
    }
 
    @Test
    public void suurinSolmuJuuri(){
        HakuPuu hakuPuu = new HakuPuu(10);
        hakuPuu.add(3);
        hakuPuu.add(2);
        hakuPuu.add(5);
        hakuPuu.add(6);
        
        PuuSolmu solmu = hakuPuu.suurin(hakuPuu.getJuuri());
        
        assertEquals(10, solmu.getAvain());
    }    
    
    @Test
    public void seuraavaSolmu(){
        HakuPuu hakuPuu = new HakuPuu(4);
        hakuPuu.add(3);
        hakuPuu.add(2);
        hakuPuu.add(5);
        hakuPuu.add(6);
        
        PuuSolmu solmu = hakuPuu.pienin(hakuPuu.getJuuri());
        solmu=hakuPuu.seuraavaSolmu(solmu);
        
        assertEquals(3, solmu.getAvain());
    }      
}
