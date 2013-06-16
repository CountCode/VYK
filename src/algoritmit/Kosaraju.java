package algoritmit;

import tietorakenteet.HakuPuu;
import tietorakenteet.Pino;


/**
 *  Kosarajun algoritmi 
 * - verkon vahvasti yhtenäisten komponenttien löytämiseksi
 * - Suorittaa syvyysuuntaisen läpikäynnin
 * - lisää solmut jälkijärjestyksessä pinoon
 * - transpoosi eli kääntää verkon kaaren vastakkaiseksi
 * - suorittaa syvyyssuuntaisen läpikäynnin transpoosiverkolle
 * 
 * - Aikavaativuus O(n^2)
 * - Tilavaativuus O(n)
 * 
 *  @author ilkka
 *  @version 1.0
 */

public class Kosaraju {
    
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
   * Pitää kirjaa käydyistä solmuista
   */  
   public static int[] color;
   /**
    * Kerää talteen käydyt solmut
    */
   public static Pino pino;
   /**
    * kerää yhteen komponentin solmut
    */
   public static HakuPuu komponentti;

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
     * @param verkko  Käsiteltävä verkko 
     */    
    public static void ekaAlustus(int[][] verkko){       
    //    System.out.println("Alustus 1");
        if (verkko==null){
            return;
        }
        for (int solmu=0; solmu< verkko.length; solmu++){ // Jokaiselle solmulle e V
            color[solmu]=-1;        // -1 = valkoinen, solmut ovat käymättömiä
         } // for
        
        for (int solmu=0; solmu<verkko.length; solmu++){    // Jokaiselle solmulle e V
            if (color[solmu]==-1){                  // jos solmussa ei olla käyty
                sse(verkko, solmu);
            } // if
        } // for
    }
    
    /**
     * - Alustaa apumuuttujat verkon toista läpikäyntiä varten
     * - Käynnistää läpikäynnin.
     * - Valitsee uudet solmut pinosta
     * @param verkko  Käsiteltävä verkko
     */   
    public static String tokaAlustus(int[][] verkko){
      //   System.out.println("Alustus 2");
        if (verkko==null){
            return "{}";
        }
        
        String komponentitMerkkijonona = "{";
        for (int solmu=0; solmu< verkko.length; solmu++){ // Jokaiselle solmulle u e V
            color[solmu]=-1;        // -1 = solmut ovat käsittelemättä
         } // for
        
        int solmu;
        while (!pino.isEmpty()){                // pinossa solmuja
            solmu=(Integer)pino.pop();  
             if (color[solmu]==-1){             // solmussa ei ole vielä käyty
                    sse(verkko, solmu);
                    if (!komponentti.isEmpty()){
                        lisaaKomponentti(tulostaKomponentti());
                    }
            } // if
             else {                             // solmussa on jo käyty
                 if (color[solmu]==0){
                     komponentti.add(solmu);
                     color[solmu]=1;            // 1, solmu on lisätty jo johonkin komponenttiin
                 }  // if               
             } // else
        } // while
        lisaaKomponentti(tulostaKomponentti());
       // System.out.println(komponentitMerkkijonona);
        return komponentitMerkkijonona;
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
       //  System.out.println(komponenttiMerkkijonona);
        return komponenttiMerkkijonona;
    }
    
    /**
     * Syvyys Suuntainen Etsintä 
     * - Käy verkon läpi 
     * - Ottaa talteen solmusta poistumisajan
     * @param verkko  Käsiteltävä verkko
     * @param solmu  Käsiteltävä solmu
     */
    //public static void sse(int[][] verkko, int solmu){   
    public static void sse(int[][] verkko, int solmu){
       // System.out.println("SSE");   
        if (verkko==null){
            return;
        }        
        color[solmu]=0;                         // 0 = solmu käsitelyssä
       
        for (int kaari=0; kaari<verkko.length; kaari++){           // jokaiselle solmulle 
            if (verkko[solmu][kaari]==1 && color[kaari]==-1){  // käsittelemätön kaari kuuluu vierus[solmu]
                try {
                    sse(verkko, kaari);  // 5000 solmulla rekursiopino ylittyy
                } catch (StackOverflowError e) {
                    System.out.println("VIRHE: Rekursiopino on vuotanut yli. Kokeile Javan -Xss parametria.");
                }
            } // if
        } //for
        pino.push(solmu);                       // Käsitellyt solmut pinoon
    }
    
    /**
     * - Kääntää kaarien suunnat vastakkaisiksi
     * @param verkko  Käsiteltävä verkko
     * @return palautaa käännetyn matriisin
     */
    public static int[][] transpoosi(int[][] verkko){
        
  //      System.out.println("Transpoosi");        
        if (verkko==null){
            return null;
        }
        int[][] transpoosi = new int[verkko.length][verkko.length];
        for (int i=0; i<verkko.length; i++){
            for (int j=0; j<verkko.length; j++){
                transpoosi[j][i]=verkko[i][j];   // käännetään matriisi
            } // for j
        } // for i
        return transpoosi;
    }
        
    /**
     * - Kosaraju-algorimin aloitusmetodi
     * @param verkko
     */
    
    public static String kosaraju(int[][] verkko){
  //      System.out.println("Kosuraju");      
        if (verkko==null){
            return "{}";
        }        

        pino = new Pino();
        komponentti = new HakuPuu();
        color = new int[verkko.length];
        verkonKomponentit="{";
        
        ekaAlustus(verkko); // Solmut pinoon lopun mukaan alenevassa järjestyksessä
        tokaAlustus(transpoosi(verkko));
        return palautaVerkonKomponentit();          
    }   
}