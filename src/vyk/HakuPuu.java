/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vyk;

/**
 *
 * @author ilkka
 */
public class HakuPuu {
    
    private PuuSolmu juuri;
    
    // Konstruktori
    
    public HakuPuu(){
        juuri = null;
    }
    
    public HakuPuu(int solmu){
        juuri = new PuuSolmu(solmu);
    }
    
    // aksessorit
    
    /**
     * Lisää solmun hakupuuhun
     * @param solmu 
     */
    public void lisaaSolmu(int solmu){
        PuuSolmu uusi = new PuuSolmu(solmu);
        if (this.isEmpty()){
            juuri=uusi;
            return;
        } //if
        PuuSolmu etsi=juuri;
        PuuSolmu apu=etsi;
        while (etsi!=null){
            apu=etsi;
            if (uusi.getAvain()<etsi.getAvain()){
                etsi=etsi.getVasen();
            } else {
                etsi=etsi.getOikea();
            }
        } // while   
        uusi.setVanhempi(apu);
        if (uusi.getAvain()<apu.getAvain()){
            apu.setVasen(uusi);
        } else {
            apu.setOikea(uusi);
        }
    }
    
    /**
     * englannin kielinen vastine lisaaSolmu-metodille
     * @param solmu 
     */
    public void add(int solmu){
        this.lisaaSolmu(solmu);
    }
    
    /**
     * Hakee hakupuun ensimmäisen alkion ja poistaa sen
     * jos hakupuu on tyhjä palauttaa -1
     * @return 
     */
    public int pollFirst(){
        if (this.isEmpty()){
            return -1;
        }
        int avain=juuri.getAvain();
        
        return avain;
    }
    
    /**
     * Poistaa hakupuun ensimmäisen alkion
     */
    public void poistaEka(int solmu){
        if (solmu )
    }

    
    /**
     * Kiertää solmut oikeaan järjestykseen
     * @param solmu1
     * @return 
     */
    public PuuSolmu kiertoOikeaan(PuuSolmu solmu1){
        PuuSolmu solmu2 = solmu1.getVasen();
        solmu2.setVanhempi(solmu1.getVanhempi());
        solmu1.setVanhempi(solmu2);
        solmu1.setVasen(solmu2.getOikea());
        solmu2.setOikea(solmu1);
        if (solmu1.getVasen()!=null){
            PuuSolmu temp = solmu1.getVasen();
            temp.setVanhempi(solmu1);
        } // if
        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1;
        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1; 
        return solmu2;
    }
    
    /**
     * Kiertää solmut oikeaan järjestykseen
     * @param solmu1
     * @return 
     */
    public PuuSolmu kiertoVasempaan(PuuSolmu solmu1){
        PuuSolmu solmu2 = solmu1.getOikea();
        solmu2.setVanhempi(solmu1.getVanhempi());
        solmu1.setVanhempi(solmu2);
        solmu1.setOikea(solmu2.getVasen());
        solmu2.setVasen(solmu1);
        if (solmu1.getOikea()!=null){
            PuuSolmu temp = solmu1.getOikea();
            temp.setVanhempi(solmu1);
        } // if
        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1;
        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1; 
        return solmu2;
    }    
    
    /**
     * Tarkistaa onko puu tyhjä
     * @return 
     */
    public Boolean isEmpty(){
        return (juuri==null);
    }
}
