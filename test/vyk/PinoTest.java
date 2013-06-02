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
public class PinoTest {
    
    public PinoTest() {
    }
    
    @Test
    public void pinoOnTyhja(){
        Pino pino = new Pino();      
        assertEquals(true,pino.isEmpty());
    }

   @Test
    public void pinoEiOleTyhja(){
        Pino pino = new Pino();
        pino.push(1);
        assertEquals(false,pino.isEmpty());        
    }
   
    @Test
    public void pushJaPop(){
         Pino pino = new Pino();         
         pino.push(1);
         pino.push(2);
         pino.push(4);
         pino.push(3);
         
         int vastaus = pino.pop();
         
        assertEquals(3,vastaus);          
         
    }
    
    @Test
    public void popTyhjaaPinoa(){
         Pino pino = new Pino();         
         
         int vastaus = pino.pop();
         
        assertEquals(-1,vastaus);   
    }
    
    @Test
    public void PinoEiSisalla(){
         Pino pino = new Pino();         
         pino.push(1);
         pino.push(2);
         pino.push(4);       
         
         assertEquals(false, pino.contains(5));
    }
    
    @Test
    public void pinoSisaltaa(){
         Pino pino = new Pino();         
         pino.push(1);
         pino.push(2);
         pino.push(4);       
         
         assertEquals(true, pino.contains(1));
    }    
    
    
    @Test
    public void pinonPinta(){
         Pino pino = new Pino();         
         pino.push(1);
         pino.push(2);
         pino.push(4);
         
         assertEquals(4,pino.peek());
    }
    
    @Test
    public void pinonPintaTyhja(){
         Pino pino = new Pino();         
         
         assertEquals(-1,pino.peek());
    }    

}
