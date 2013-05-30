package vyk;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 *  Kosarajun algoritmi verkon vahvasti yhtenäisten komponenttien löytämiseksi
 *  @author ilkka
 *  @version 0.4
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
   public static LinkedList pino;
   /**
    * kerää yhteen komponentin solmut
    */
   public static TreeSet komponentti;
    
    /**
     * - Alustaa apumuuttujat verkon ensimmäistä läpikäyntiä varten
     * - Käynnistää läpikäynnin
     * - Valitsee uudet solmut numerojärjestyksessä
     * @param verkko  Käsiteltävä verkko 
     */
    
    public static void ekaAlustus(int[][] verkko){       
    //    System.out.println("Alustus 1");

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
    
    public static void tokaAlustus(int[][] verkko){
        
       // System.out.println("Alustus 2");

        for (int solmu=0; solmu< verkko.length; solmu++){ // Jokaiselle solmulle u e V
            color[solmu]=-1;        // -1 = valkoinen, solmut ovat käymättömiä
         } // for
        
        int solmu;
        while (!pino.isEmpty()){                // pinossa solmuja
            solmu=(Integer)pino.pop();  
             if (color[solmu]==-1){             // solmussa ei ole vielä käyty
                    sse(verkko, solmu);
                    tulostaKomponentti();
            } // if
             else {                             // solmussa on jo käyty
                 if (color[solmu]==0){
                     komponentti.add(solmu);
                     color[solmu]=1;            // 1 solmu on lisätty jo johonkin komponenttiin
                 }  // if               
             } // else
        } // while
        tulostaKomponentti();
    }
    
    /**
     *  Tulostaa Vahvasti yhtenäisen komponentin.
     */
    
    public static void tulostaKomponentti(){
        while (!komponentti.isEmpty()){
            System.out.print(komponentti.pollFirst()+" ");
        } // while
        System.out.println();   
    }
    
    /**
     * Syvyys Suuntainen Etsintä 
     * - Käy verkon läpi 
     * - Ottaa talteen solmusta poistumisajan
     * @param verkko  Käsiteltävä verkko
     * @param solmu  Käsiteltävä solmu
     */
    public static void sse(int[][] verkko, int solmu){        
    //    System.out.println("SSE");              
        color[solmu]=0;                         // 0 = harmaa, solmu käsitelyssä
       
        for (int kaari=0; kaari<verkko.length; kaari++){           // jokaiselle solmulle 
            if (verkko[solmu][kaari]==1 && color[kaari]==-1){  // käsittelemätön kaari kuuluu vierus[solmu]
                sse(verkko, kaari);
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
    
    public static void kosaraju(int[][] verkko){
  // public static void main(String[] args){ 
  //      System.out.println("Kosuraju");

        pino = new LinkedList();
        komponentti = new TreeSet();
        
        color = new int[verkko.length];
        ekaAlustus(verkko); // Solmut pinoon lopun mukaan alenevassa järjestyksessä
        tokaAlustus(transpoosi(verkko));
            
    }   
}