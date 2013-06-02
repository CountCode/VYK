/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vyk;

/**
 * Pino - Linkitetty lista 
 * @author ilkka
 * @version 0.41
 */
public class Pino {
    
    private Solmu pinta;                            // pino päällimmäinen solmu
    
    // konstruktori
    
    public Pino(){
        this.pinta = null;
    }
    
    // aksessorit
    
    /**
     * Asettaa pinon pinnan
     * @param solmu 
     */
    public void setPinta(Solmu solmu){
        this.pinta=solmu;
    }
    /**
     * Hakee pinon pinnan
     * @return palauttaa pintasolmun
     */
    public Solmu getPinta(){
        return this.pinta;
    }

    /**
     * Lisää uuden solmu pinoon
     * @param pino
     * @param solmu 
     */
    public void push(int solmu){
        Solmu uusi = new Solmu(solmu);          // uusi solmu
        uusi.setSeuraava(this.pinta);           // seuraavaksi nykyinen pinta
        this.setPinta(uusi);                    // uudeksi pinnaksi uusi solmu
    }
    
    /**
     * Poistaa pinosta yhden solmun
     * @param pino
     * @return solmu tai -1, jos pino tyhjä
     */
    public int pop(){
        if (this.isEmpty()) {
            return -1;                          // -1 virhe
        }
        Solmu pois=this.getPinta();
        this.setPinta(pois.getSeuraava());
        return pois.getSolmu();
    }
    /**
     * Tarkistaa onko pino tyhjä
     * @return jos pino tyhjä niin true
     */
    public boolean isEmpty(){
        return (this.getPinta()==null);
    }
    
    /**
     * Tarkistaa onko kyseinen solmu pinossa
     * @param solmu
     * @return pinossa true
     */
    public boolean contains(int solmu){
        Solmu hae = this.getPinta();
        while (hae!=null){
            if (hae.getSolmu()==solmu){
                return true;
            }
            hae= hae.getSeuraava();
        }
        return false;       
    }
    
    /**
     * Lukee pinon pinnan
     * @return pintasolmun
     */
    public int peek(){
         if (this.isEmpty()) {
            return -1;                          // -1 virhe
        }            
        Solmu pinta=this.getPinta();
        return(pinta.getSolmu());
    }
}