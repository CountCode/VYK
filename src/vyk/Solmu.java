/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vyk;

/**
 * Linkitetyn listan solmu
 * @author ilkka
 * @versiopn 0.41
 */
public class Solmu {
    
// Attribuutit
    
    private int solmu;
    private Solmu seuraava;
    
// Konstruktori
   public Solmu(){
       this.setSolmu(0);
       this.setSeuraava(null);
   }

   /* 
    * Asettaa solmun valmiiksi
    * @param solmu
    */
   public Solmu(int solmu){
       this.setSolmu(solmu);
       this.setSeuraava(null);
   }
   
// Aksessorit   
    
    /**
     * Asettaa solmun
     * @param solmu 
     */ 
    public void setSolmu(int solmu){
        this.solmu=solmu;
    }
    
    /**
     * Hakee solmun
     * @return solmu
     */
    public int getSolmu(){
        return this.solmu;
    }
    
    /**
     * Asettaa seuraavan listaan
     * @param solmu 
     */
    public void setSeuraava(Solmu solmu){
        this.seuraava=solmu;
    }
    
    /**
     * Hakee seuraavan solmun
     * @return 
     */
    public Solmu getSeuraava(){
        return this.seuraava;
    }    
}
