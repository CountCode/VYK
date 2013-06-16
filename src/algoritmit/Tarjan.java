package algoritmit;

import tietorakenteet.HakuPuu;
import tietorakenteet.Pino;

/**
 *  Tarjan algoritmi 
 * - Verkon vahvasti yhtenäisten komponenttien löytämiseksi
 * - suorittaa verko syvyyssuuntaista läpikäyntiä  
 * - laittaa solmut pinoon esijärjestyksessä
 * - alipuusta palattessa tarkistaa mitkä solmut muodostavat komponentin, 
 *  sen perusteella mihin solmuihin niillä on yhteys.
 * 
 * - Aikavaativuus O(n^2) Tosin tällä hetkellä lähempänä 0(n^3)
 * - Tilavaativuus O(n)
 * 
 * @author ilkka
 * @version 1.0
 */
public class Tarjan {
    /**
     * solmujen käyntijärjestyksen laskuri
     */
    public static int aika;
    /**
     * Pitää kirjaa käydyistä solmuista
     */
    public static int[] color;
    /**
     * Kerää talteen käydyt solmut
     */
    public static Pino pino;
    /**
     * Kirjaa haun syvyyden
     */
    public static int[] syvyys;
    /**
     * Komponentin alin syvyys
     */
    public static int[] alin;
    /**
     * Kerää yhteen komponentin solmut
     */
    public static HakuPuu komponentti;
    
   /**
     * Vierusmatriisi testausta varten
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
     * Kerää verkon vahvasti yhtenäiset komponentit
     */
    public static String verkonKomponentit;
    
    /**
     * Lisää vahvasti yhtenäisen komponentin
     * @param komponentti 
     */
    public static void lisaaKomponentti(String komponentti){
        verkonKomponentit=verkonKomponentit+komponentti;
    }
    
    /**
     * Palauttaa verkon vahvasti yhtenäiset komponentit
     * @return 
     */
    public static String palautaVerkonKomponentit(){
        return verkonKomponentit+"}";
    }
    
    /**
     * - Alustaa apumuuttujat verkon ensimmäistä läpikäyntiä varten
     * - Käynnistää läpikäynnin
     * - Valitsee uudet solmut numerojärjestyksessä
     * @param verkko 
     */    
        public static void alustus(int[][] verkko){        
      //  System.out.println("Alustus");
        if (verkko==null){
            return;
        }
        
        aika = 0;            
                 
        for (int solmu=0; solmu< verkko.length; solmu++){ // Jokaiselle solmulle e V
            color[solmu]=-1;        // -1 = käsittelemättä
        } // for    
        for (int solmu=0; solmu<verkko.length; solmu++){ // Jokaiselle solmulle u e V
            if (color[solmu]==-1){
                sse(verkko, solmu);
            } // if
        } // for
    }
    
    /**
     * - Syvyys Suuntainen Etsintä
     * - Etsii verkon vahvasti yhtenäiset komponentit
     * @param verkko
     * @param solmu 
     */    
    public static void sse(int[][] verkko, int solmu){  
    //    System.out.println("SSE:"+solmu+"aika:"+aika);
        if (verkko==null){
            return;
        }
        
        color[solmu]=0;                         // 0 = käsittelyssä
        syvyys[solmu]=aika;                     // solmun syvyys
        alin[solmu]=aika;                       // solmun komponentin alin
        aika=aika+1;                            // lisää syvyyttä
        pino.push(solmu);                        // pinoon     
        for (int kaari=0;kaari<verkko.length;kaari++){      // joka kaarelle
            if (verkko[solmu][kaari]==1 && color[kaari]==-1){ // if q is not already in T ??
                                            // add p->q to T ??
              //  sse(verkko, kaari);                 // seuraavaan solmuun
                try {
                    sse(verkko, kaari);  // 3000 solmulla rekursiopino ylittyy
                } catch (StackOverflowError e) {
                    System.out.println("VIRHE: Rekursiopino on vuotanut yli. Kokeile Javan -Xss parametria.");
                }                
                                                    
                alin[solmu]=Math.min(alin[solmu],alin[kaari]); // jos komponentista löytynyt alempi solmu
            } // if
            else if (verkko[solmu][kaari]==1 && pino.contains(kaari)){         // Jos kaari on pinossa              
            alin[solmu]=Math.min(alin[solmu],syvyys[kaari]); // jos kaari on alempana
            } // else if
        } // for
        
        if (alin[solmu]==syvyys[solmu]){         // jos olemme alimmassa solmussa
      //      System.out.println("Komponentti:");  // output "component:"
            boolean valmis=true;
            int pinosta;
            while (valmis){                      // repeat
                pinosta=(Integer)pino.pop();
                komponentti.add(pinosta);
                if (solmu==pinosta){
                    valmis=false;
                } // if
            } // while
            lisaaKomponentti(tulostaKomponentti());                      // tulostetaan komponetin solmut
        } //if               
    }  

    /**
     * Kerää vahvasti yhtenäisen komponentin solmut yhteen
     * @return vahvasti yhtenäinen komponentti merkkijonona
     */
    public static String tulostaKomponentti(){
        String komponenttiMerkkijonona = "{";
        while (!komponentti.isEmpty()){
            komponenttiMerkkijonona=komponenttiMerkkijonona+komponentti.pollFirst();
            if (!komponentti.isEmpty()){
              komponenttiMerkkijonona=komponenttiMerkkijonona+",";               
            }
        }      
        komponenttiMerkkijonona=komponenttiMerkkijonona+"}"; 
        // System.out.println(komponenttiMerkkijonona);
        return komponenttiMerkkijonona;
    }    
    
    /**
     * - Algoritmin käynnistysmetodi
     * @param verkko
     */
    public static String tarjan(int[][] verkko){
        
        if (verkko==null){
            return "{}";
        }        

    // Alustus
    color = new int[verkko.length];
    syvyys = new int[verkko.length];
    alin= new int[verkko.length];
    pino = new Pino();
    komponentti = new HakuPuu();    
    verkonKomponentit="{";

    alustus(verkko);        // Aloitetaan etsintä
    // System.out.println(palautaVerkonKomponentit());
    return palautaVerkonKomponentit();
    }
}