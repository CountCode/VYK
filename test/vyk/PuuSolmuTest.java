package vyk;

import tietorakenteet.PuuSolmu;
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
public class PuuSolmuTest {
    
    public PuuSolmuTest() {
    }
    
    @Test
    public void konstruktoriAsettaaSolmunOikein(){
        PuuSolmu solmu = new PuuSolmu(10);
        assertEquals(10,solmu.getAvain());
    }
    
    @Test 
    public void setSolmuAsettaaOikein(){
        PuuSolmu solmu = new PuuSolmu(10);
        solmu.setAvain(7);
        assertEquals(7,solmu.getAvain());
    }
    
    @Test
    public void setVasenAsettaaOikein(){
        PuuSolmu solmu1 = new PuuSolmu(1);
        PuuSolmu solmu2 = new PuuSolmu(2); 
        solmu1.setVasen(solmu2);
        PuuSolmu hae = solmu1.getVasen();
        
        assertEquals(2,hae.getAvain());
    }
    
    @Test
    public void setOikeaAsettaaOikein(){
        PuuSolmu solmu1 = new PuuSolmu(1);
        PuuSolmu solmu2 = new PuuSolmu(2); 
        solmu1.setOikea(solmu2);
        PuuSolmu hae = solmu1.getOikea();
        
        assertEquals(2,hae.getAvain());
    }
    
    @Test
    public void setVanhempiAsettaaOikein(){
        PuuSolmu solmu1 = new PuuSolmu(1);
        PuuSolmu solmu2 = new PuuSolmu(2); 
        solmu1.setVanhempi(solmu2);
        PuuSolmu hae = solmu1.getVanhempi();
        
        assertEquals(2,hae.getAvain());
    }    
 
}
