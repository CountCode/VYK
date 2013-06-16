package vyk;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.Solmu;

/**
 *
 * @author ilkka
 */
public class SolmuTest {
    
    public SolmuTest() {
    }
    
    @Test
    public void konstruktoriAsettaaSolmunOikein(){
        Solmu solmu=new Solmu(10);
        assertEquals(10,solmu.getSolmu());
    }
    
    @Test 
    public void setSolmuAsettaaOikein(){
        Solmu solmu=new Solmu(10);
        solmu.setSolmu(7);
        assertEquals(7,solmu.getSolmu());
    }
    
    @Test
    public void setSeuraavaAsettaaOikein(){
        Solmu solmu1=new Solmu();
        Solmu solmu2=new Solmu(12);
        Solmu solmu3=new Solmu(31);
        solmu1.setSeuraava(solmu2);
        solmu2.setSeuraava(solmu3);
        
        Solmu testi = solmu1;
        while (testi.getSeuraava()!=null){
            testi = testi.getSeuraava();    
        }        
        assertEquals(31,testi.getSolmu());
    }
}
