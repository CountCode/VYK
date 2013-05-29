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
    
    public static void Alustus1(int[][] verkko){
        
    //    System.out.println("Alustus 1");

        for (int u=0; u< verkko.length; u++){ // Jokaiselle solmulle u e V
            color[u]=-1;        // -1 = valkoinen
         } // for
        
        for (int u=0; u<verkko.length; u++){ // Jokaiselle solmulle u e V
            if (color[u]==-1){
                SSE(verkko, u);
            } // if
        } // for
    }
    
    /**
     * - Alustaa apumuuttujat verkon toista läpikäyntiä varten
     * - Käynnistää läpikäynnin.
     * - Valitsee uudet solmut pinosta
     * @param verkko  Käsiteltävä verkko
     */
    
    public static void Alustus2(int[][] verkko){
        
       // System.out.println("Alustus 2");

        for (int u=0; u< verkko.length; u++){ // Jokaiselle solmulle u e V
            color[u]=-1;        // -1 = valkoinen
         } // for
        
        int solmu;
        while (!pino.isEmpty()){                // pinossa solmuja
            solmu=(Integer)pino.pop();
       //     System.out.println("ps:"+solmu);   
             if (color[solmu]==-1){             // solmussa ei ole vielä käyty
                    SSE(verkko, solmu);
                    Komponentti();
            } // if
             else {                             // solmussa on jo käyty
           //      System.out.print(solmu+" ");
                 if (color[solmu]==0){
                     komponentti.add(solmu);
                     color[solmu]=1;            // 1 solmu on lisätty jo johonkin komponenttiin
                 }
                 
             } // else
        } // while
        Komponentti();
    }
    
    /**
     *  Tulostaa Vahvasti yhtenäisen komponentin.
     */
    
    public static void Komponentti(){
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
    public static void SSE(int[][] verkko, int solmu){
        
    //    System.out.println("SSE");        
        
        color[solmu]=0;                         // 0 = harmaa
       
        for (int v=0; v<verkko.length; v++){           // jokaiselle solmulle 
        //    System.out.println("v: "+v);
            if (verkko[solmu][v]==1 && color[v]==-1){  // v e vierus[u]
     //           System.out.println("s:"+solmu+" v: "+v);
                SSE(verkko, v);
            } // if
        } //for

        pino.push(solmu);                       // Käsitellyt solmut pinoon
    }
    
    /**
     * - Kääntää kaarien suunnat vastakkaisiksi
     * @param verkko  Käsiteltävä verkko
     * @return palautaa käännetyn matriisin
     */
    public static int[][] Transpoosi(int[][] verkko){
        
  //      System.out.println("Transpoosi");        
        
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
    
    public static void Kosaraju(int[][] verkko){
  // public static void main(String[] args){ 
  //      System.out.println("Kosuraju");

        pino = new LinkedList();
        komponentti = new TreeSet();
        
        color = new int[verkko.length];
        Alustus1(verkko); // Solmut pinoon lopun mukaan alenevassa järjestyksessä
        Alustus2(Transpoosi(verkko));
            
    }   
}