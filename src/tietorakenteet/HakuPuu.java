/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

/**
 * HakuPuu kerää solmut binääripuuhun ilman tuplikaatteja
 * Tehty joltainosin TreeSetin korvikkeeksi
 * @author ilkka
 * @version 1.0
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
     * Palauttaa Hakupuun juuren
     * @return 
     */
    public PuuSolmu getJuuri(){
        return this.juuri;
    }
    
    /**
     * Lisää solmun hakupuuhun
     * @param solmu 
     */
    public PuuSolmu lisaaSolmu(int solmu){
        PuuSolmu uusi = new PuuSolmu(solmu);
        if (this.isEmpty()){
            juuri=uusi;
            return uusi;
        } //if
        PuuSolmu etsi=juuri;
        PuuSolmu apu=etsi;
        while (etsi!=null){
            apu=etsi;
            if (uusi.getAvain()==etsi.getAvain()){  // vain yksi kutakin
                return uusi;
            }
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
        return uusi;
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
        this.poistaEka();
        
        return avain;
    }
     
    /**
     * Poistaa hakupuun ensimmäisen alkion      
     * Defragmentoitu
     */
    public void poistaEka(){
        // Juurella ei ole lapsia
        if (juuri.getVasen()==null && juuri.getOikea()==null){
            juuri=null;
            return;
        }
        // Juurella on yksi lapsi
        if (juuri.getVasen()==null || juuri.getOikea()==null){        
            PoistaEkaYksiLapsi();
            return;
        }
        // Juurella on kaksi lasta
        PoistaEkaKaksiLasta();
    }
    
    /**
     * Poistaa ekan, jos juurella kaksi lasta
     */
    public void PoistaEkaKaksiLasta(){
        PuuSolmu lapsi;        
        PuuSolmu seuraava=pienin(juuri.getOikea());
        juuri.setAvain(seuraava.getAvain());    // korvataa poistettavan solmun avain seuraajan avaimella
        lapsi=seuraava.getOikea();
        PuuSolmu vanhempi = seuraava.getVanhempi();
        if (vanhempi.getVasen()==seuraava){
            vanhempi.setVasen(lapsi);
        } else {
            vanhempi.setOikea(lapsi);
        }
        if (lapsi!=null){
            lapsi.setVanhempi(vanhempi);
        }
   }
   /**
    * Poistaa hakupuun ensimmäisen alkion, jos juurella on yksi lapsi
    */    
   public void PoistaEkaYksiLapsi(){
        PuuSolmu lapsi;
            if (juuri.getVasen()!=null){
                lapsi = juuri.getVasen();
            } else {
                lapsi = juuri.getOikea();              
            }
            lapsi.setVanhempi(null);
            juuri=lapsi;       
   }
    
  /**
   * Palauttaa alipuun pienimmän solmu
   * @param solmu
   * @return pienin solmu
   */  
   public PuuSolmu pienin(PuuSolmu solmu){
       PuuSolmu kulkija = solmu;
       while (kulkija.getVasen()!=null){
           kulkija=kulkija.getVasen();
       }
       return kulkija;
   }
   
     /**
   * Palauttaa puun suurimman solmu
   * @param solmu
   * @return suurin solmu
   */  
   public PuuSolmu suurin(PuuSolmu solmu){
       PuuSolmu kulkija = solmu;
       while (kulkija.getOikea()!=null){
           kulkija=kulkija.getOikea();
       }
       return kulkija;
   }
   
   /**
    * Palauttaa solmua seuraavan solmun
    * @param solmu
    * @return seuraava solmu
    */
   public PuuSolmu seuraavaSolmu(PuuSolmu solmu){
       PuuSolmu kulkija = solmu;
       if (kulkija.getOikea()!=null){
           return pienin(kulkija.getOikea());
       }
       PuuSolmu apuKulkija = kulkija.getVanhempi();
       while (apuKulkija!=null && kulkija==apuKulkija.getOikea()){
           kulkija=apuKulkija;
           apuKulkija=kulkija.getVanhempi();
       }
       return apuKulkija;
   }
   
    /**
     * Tarkistaa onko puu tyhjä
     * @return 
     */
    public Boolean isEmpty(){
        return (juuri==null);
    }   
   
   // TASAPAINOTUS
//   
//   public int korkeus(PuuSolmu solmu){
//       if (solmu==null){
//           return -1;
//       } else {
//           return solmu.getKorkeus();
//       }
//   }
//   
//    /**
//     * Kiertää solmut oikeaan järjestykseen
//     * @param solmu1
//     * @return 
//     */
//    public PuuSolmu kiertoOikeaan(PuuSolmu solmu1){
//        PuuSolmu solmu2 = solmu1.getVasen();
//        solmu2.setVanhempi(solmu1.getVanhempi());
//        solmu1.setVanhempi(solmu2);
//        solmu1.setVasen(solmu2.getOikea());
//        solmu2.setOikea(solmu1);
//        if (solmu1.getVasen()!=null){
//            PuuSolmu temp = solmu1.getVasen();
//            temp.setVanhempi(solmu1);
//        } // if
//        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1;
//        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1; 
//        return solmu2;
//    }
//    
//    /**
//     * Kiertää solmut oikeaan järjestykseen
//     * @param solmu1
//     * @return 
//     */
//    public PuuSolmu kiertoVasempaan(PuuSolmu solmu1){
//        PuuSolmu solmu2 = solmu1.getOikea();
//        solmu2.setVanhempi(solmu1.getVanhempi());
//        solmu1.setVanhempi(solmu2);
//        solmu1.setOikea(solmu2.getVasen());
//        solmu2.setVasen(solmu1);
//        if (solmu1.getOikea()!=null){
//            PuuSolmu temp = solmu1.getOikea();
//            temp.setVanhempi(solmu1);
//        } // if
//        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1;
//        //solmu1.setKorkeus= Math.max(Height (solmu1.getVasen()), Height(solmu1.getOikea()))+1; 
//        return solmu2;
//    }    
//    
//    /**
//     * tekee kaksoiskierron oikea vasen
//     * @param solmu
//     * @return 
//     */
//    public PuuSolmu kiertoOikeaVasen(PuuSolmu solmu){
//        PuuSolmu apuSolmu = solmu.getOikea();
//        solmu.setOikea(kiertoOikeaan(apuSolmu));
//        return kiertoVasempaan(solmu);
//    }
//    
//    /**
//     * tekee kaksoiskierron vasen oikea
//     * @param solmu
//     * @return 
//     */
//    public PuuSolmu kiertoVasenOikea(PuuSolmu solmu){
//        PuuSolmu apuSolmu = solmu.getVasen();
//        solmu.setVasen(kiertoVasempaan(apuSolmu));
//        return kiertoOikeaan(solmu);
//    }    
//    
//    /**
//     * Tasapainottaa puun lisäyksen osalta
//     * @param solmu 
//     */
//    public void avlInsert(int solmu){
//        PuuSolmu uusiSolmu = lisaaSolmu(solmu);
//        PuuSolmu aliPuu;
//        PuuSolmu isoVanhempi=uusiSolmu.getVanhempi();
//        while (isoVanhempi!=null){
//            if (isoVanhempi.getVasen().getKorkeus()==isoVanhempi.getOikea().getKorkeus()+2){
//                PuuSolmu vanhempi = isoVanhempi.getVanhempi();
//                if (isoVanhempi.getVasen().getVasen().getKorkeus()>isoVanhempi.getVasen().getOikea().getKorkeus()){
//                    aliPuu=kiertoOikeaan(isoVanhempi);
//                } else {
//                    aliPuu=kiertoVasenOikea(isoVanhempi);
//                }
//                if (vanhempi==null){
//                    juuri=aliPuu;
//                } else if (vanhempi.getVasen()==isoVanhempi){
//                    vanhempi.setVasen(aliPuu);
//                } else {
//                    vanhempi.setOikea(aliPuu);                    
//                }
//                if (vanhempi!=null){
//                    vanhempi.setKorkeus(Math.max(vanhempi.getVasen().getKorkeus(),vanhempi.getOikea().getKorkeus())+1);
//                }
//                return;
//            }
//            if (isoVanhempi.getOikea().getKorkeus()==isoVanhempi.getVasen().getKorkeus()+2){
//                PuuSolmu vanhempi = isoVanhempi.getVanhempi();
//                if (isoVanhempi.getOikea().getOikea().getKorkeus()>isoVanhempi.getOikea().getVasen().getKorkeus()){
//                    aliPuu=kiertoVasempaan(isoVanhempi);
//                } else {
//                    aliPuu=kiertoOikeaVasen(isoVanhempi);
//                }
//                if (vanhempi==null){
//                    juuri=aliPuu;
//                } else if (vanhempi.getVasen()==isoVanhempi){
//                    vanhempi.setVasen(aliPuu);
//                } else {
//                    vanhempi.setOikea(aliPuu);                    
//                }
//                if (vanhempi!=null){
//                    vanhempi.setKorkeus(Math.max(vanhempi.getVasen().getKorkeus(),vanhempi.getOikea().getKorkeus())+1);
//                }
//                return;                
//            }
//            isoVanhempi.setKorkeus(Math.max(isoVanhempi.getVasen().getKorkeus(),isoVanhempi.getOikea().getKorkeus())+1);
//            isoVanhempi=isoVanhempi.getVanhempi();
//        }
//    }
//    
//    public void alvDelele(PuuSolmu solmu){
//        PuuSolmu aliPuu;
//        PuuSolmu pois = delete(Puusolmu solmu);
//        PuuSolmu vanhempi=pois.getVanhempi();
//        while (vanhempi!=null){
//            if ((vanhempi.getOikea().getKorkeus()==vanhempi.getVasen().getKorkeus()+2) ||
//                    vanhempi.getVasen().getKorkeus()==vanhempi.getOikea().getKorkeus()+2){ //vanhempi EPÄTASAPAINOSSA)
//                PuuSolmu isoVanhempi=vanhempi.getVanhempi();
//                if (isoVanhempi.getVasen().getVasen().getKorkeus()>isoVanhempi.getVasen().getOikea().getKorkeus()){
//                    aliPuu=kiertoOikeaan(vanhempi);
//                } else if (isoVanhempi.getOikea().getOikea().getKorkeus()>isoVanhempi.getOikea().getVasen().getKorkeus()){
//                    aliPuu=kiertoVasempaan(vanhempi);
//                } else if (isoVanhempi.getVasen().getOikea().getKorkeus()>isoVanhempi.getVasen().getVasen().getKorkeus()){
//                    aliPuu=kiertoOikeaVasen(vanhempi);
//                } else {
//                    aliPuu=kiertoVasenOikea(vanhempi);
//                }
//                if (vanhempi==juuri){
//                    juuri=aliPuu;
//                    return;
//                }
//                //ASETA ALIPUU SOLMUN VANHEMPI LAPSEKSI;
//                vanhempi.setLAPSI(alipuu);
//                vanhempi = isoVanhempi;
//            } else {
//                vanhempi.setKorkeus(Math.max(vanhempi.getVasen().getKorkeus(),vanhempi.getOikea().getKorkeus())+1);
//                vanhempi=vanhempi.getVanhempi();
//            }
//        }
//    }
}