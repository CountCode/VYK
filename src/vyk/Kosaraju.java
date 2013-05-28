package vyk;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *  Kosarajun algritmi verkon vahvasti yhtenäisten komponenttien löytämiseksi
 *  @author ilkka
 *  @version 0.3
 * 
 */


public class Kosaraju {
    
    // Tira luentokalvot s. 499
    // {0,1,4},{2},{3,7},{5,6}
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
 //  public static int[] alku;
 //  public static int[] loppu;
 //  public static int aika;
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
  //      aika = 0;
        
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
    //    aika = 0;
        
        int solmu;
        while (!pino.isEmpty()){
            solmu=(Integer)pino.pop();
             if (color[solmu]==-1){
                    SSE(verkko, solmu);
                    Komponentti();
            } // if
             else {
                // System.out.print(solmu+" ");
                 komponentti.add(solmu);
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
   //     aika=aika+1;
 //       System.out.println("solmu: "+solmu);
   //     alku[solmu]=aika;
       
        for (int v=0; v<verkko.length; v++){           // jokaiselle solmulle 
           // System.out.println("v: "+v);
            if (verkko[solmu][v]==1 && color[v]==-1){  // v e vierus[u]
                SSE(verkko, v);
            } // if
        } //for
        color[solmu]=1;                         // 1 = musta
  //      aika=aika+1;
  //      loppu[solmu]=aika;
        pino.push(solmu);                       // Käsitellyt solmut pinoon
    }
    
    /**
     * - Kääntää kaarien suunnat vastakkaisiksi
     * @param verkko  Käsiteltävä verkko
     * @return palautaa käännetyn matriisin
     */
    public static int[][] Transpoosi(int[][] verkko){
        
   //     System.out.println("Transpoosi");        
        
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
     */
    
    public static void Kosaraju(int[][] verkko){
  // public static void main(String[] args){ 
        System.out.println("Kosuraju");
     //   int[][] verkko = esim1;
      //  alku = new int[verkko.length];
      //  loppu = new int[verkko.length];
        pino = new LinkedList();
        komponentti = new TreeSet();
        
        color = new int[verkko.length];
        Alustus1(verkko);
        // Solmut pinoon lopun mukaan alenevassa järjestyksessä
        Alustus2(Transpoosi(verkko));
            
    }   
}