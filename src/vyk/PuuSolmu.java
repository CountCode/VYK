/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vyk;

/**
 * Puunsolmut hakupuuta varten
 * @author ilkka
 * @version 1.0
 */
public class PuuSolmu {
    
    private int avain;
    private PuuSolmu vasen;
    private PuuSolmu oikea;
    private PuuSolmu vanhempi;
    
    // konstruktori
    
    public PuuSolmu(int avain){
        this.avain=avain;
        this.vasen=null;
        this.oikea=null;
        this.vanhempi=null;       
    }
    
    // aksessorit
   /**
    * Asettaa avaimen
    * @param avain 
    */ 
    public void setAvain(int avain){
        this.avain=avain;
    }
    
    /**
     * Hakee avaimen
     * @return avain
     */
    public int getAvain(){
        return this.avain;
    }
    
    /**
     * Asettaa vasemman lapsen
     * @param solmu 
     */
    public void setVasen(PuuSolmu solmu){
        this.vasen=solmu;
    }
    
    /**
     * Hakee vasemman lapsen
     * @return vasen lapsi
     */
    public PuuSolmu getVasen(){
        return this.vasen;
    }
    
    /**
     * Asettaa oikean lapsen
     * @param solmu 
     */
    public void setOikea(PuuSolmu solmu){
        this.oikea=solmu;
    }
    
    /**
     * Hakee oikean lapsen
     * @return oikea lapsi
     */
    public PuuSolmu getOikea(){
        return this.oikea;
    }
    
    /**
     * Asettaa vanhemman
     * @param solmu 
     */
    public void setVanhempi(PuuSolmu solmu){
        this.vanhempi=solmu;
    }
    
    /**
     * Hakee vanhemman
     * @return vanhempi
     */
    public PuuSolmu getVanhempi(){
        return this.vanhempi;
    }    
    
}
