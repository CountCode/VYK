/*
 *  Kosurajun algritmi verkon vahvasti yhtenäisten komponenttien löytämiseksi
 * 
 */
package vyk;
import java.util.LinkedList;

/**
 *
 * @author ilkka
 * @version 0.2
 */
public class Kosuraju {
    
    // Tira luentokalvot s. 499
    // {0,1,5},{3},{4,8},{6,7}
  static int[][] esim1 = new int[][] {
        {0, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0}};
    
   public static int[] color;
   public static int[] alku;
   public static int[] loppu;
   public static int aika;
    
    /**
     * Alustus -   Alustaa apumuuttujat verkon läpikäyntiä varten ja käynnistää
     *             läpikäynnin 
     * @param verkko  Käsiteltävä verkko
     * @param solmu  Alkusolmu 
     */
    
    public static void Alustus(int[][] verkko, int alkusolmu){
        
        System.out.println("Alustus");

        for (int u=0; u< verkko.length; u++){ // Jokaiselle solmulle u e V
            color[u]=-1;        // -1 = valkoinen
         } // for
        aika = 0;
        
        for (int u=0; u<verkko.length; u++){ // Jokaiselle solmulle u e V
            if (color[u]==-1){
                SSE(verkko, u);
            } // if
        } // for
    }
    
    /**
     * SSE - Syvyys Suuntainen Etsintä - Käy verkon läpi ja ottaa talteen
     *          solmusta poistumisajan
     * @param verkko  Käsiteltävä verkko
     * @param solmu  Käsiteltävä solmu
     */
    public static void SSE(int[][] verkko, int solmu){
        
        System.out.println("SSE");        
        
        color[solmu]=0;             // 0 = harmaa
        aika=aika+1;
        System.out.println("solmu: "+solmu);
        alku[solmu]=aika;
       
        for (int v=0; v<verkko.length; v++){           // jokaiselle solmulle 
           // System.out.println("v: "+v);
            if (verkko[solmu][v]==1 && color[v]==-1){  // v e vierus[u]
                SSE(verkko, v);
            } // if
        } //for
        color[solmu]=1;                 // 1 = musta
        aika=aika+1;
        loppu[solmu]=aika;
    }
    
    /**
     * Transpoosi - Käänttää kaarien suunnat vastakkaisiksi
     * @param verkko  Käsiteltävä verkko
     */
    public static int[][] Transpoosi(int[][] verkko){
        
        System.out.println("transpoosi");        
        
        int[][] transpoosi = new int[verkko.length][verkko.length];
        for (int i=0; i<verkko.length; i++){
            for (int j=0; j<verkko.length; j++){
                transpoosi[j][i]=verkko[j][i];   // käännetään matriisi
            } // for j
        } // for i
        return transpoosi;
    }
    
    
    /**
     * Kosuraju - Kosuraju-algorimin aloitusmetodi
     */
    
    public static void Kosuraju(){
  // public static void main(String[] args){ 
        System.out.println("Kosuraju");
        int[][] verkko = esim1;
        alku = new int[verkko.length];
        loppu = new int[verkko.length];
        LinkedList pino = new LinkedList();
        
        color = new int[verkko.length];
        Alustus(verkko,0);
        // Solmut pinoon lopun mukaan alenevassa järjestyksessä
        Alustus(Transpoosi(verkko),0);
            
    }
    
}
