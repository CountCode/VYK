package vyk;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * PathBased-algoritmi verkon vahvasti yhtenäisten komponenttien löytämiseksi
 * @author ilkka
 * @version 0.4
 */
public class PathBased {
    
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
    public static LinkedList pinoS;
    /**
     * Kerää talteen käydyt solmut
     */
    public static LinkedList pinoP;      
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
    public static TreeSet komponentti;
    
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
     * - Alustaa apumuuttujat verkon ensimmäistä läpikäyntiä varten
     * - Käynnistää läpikäynnin
     * - Valitsee uudet solmut numerojärjestyksessä
     * @param verkko 
     */
    
        public static void Alustus(int[][] verkko){
        
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
     * - Syvyys Suuntainen Etsintä
     * - Etsii verkon vahvasti yhtenäiset komponentit
     * @param verkko
     * @param solmu 
     */    
    public static void SSE(int[][] verkko, int solmu){
  
    //    System.out.println("SSE:"+solmu+" aika:"+aika);
        int pinosta;
   
        color[solmu]=0; 
        syvyys[solmu]=aika;                     // solmun syvyys
        alin[solmu]=aika;                       // solmun komponentin alin
        aika=aika+1;                            // lisää syvyyttä
        pinoS.push(solmu);                        // pinoon C
        pinoP.push(solmu);                        // pinoon  P       
        for (int kaari=0;kaari<verkko.length;kaari++){      // joka kaarelle
            if (verkko[solmu][kaari]==1 && color[kaari]==-1){ // if q is not already in T ??
                                            // add p->q to T ??
                SSE(verkko, kaari);                 // seuraavaan solmuun
           //     System.out.println("SSE-:"+solmu);
            } // if
            else if (verkko[solmu][kaari]==1 && pinoS.contains(kaari)){         // Jos kaari on pinossa
                while (syvyys[(Integer)pinoP.peek()]>syvyys[kaari]){
                    pinoP.pop();            
                }     
            } // else if            
        } // for
                
        if (solmu==pinoP.peek()){
            do { 
                pinosta=(Integer)pinoS.pop();
                komponentti.add(pinosta);
            } while (solmu!=pinosta);
           // komponentti.add(pinosta); 
            pinoP.pop();
           Komponentti();   // tulostetaan komponetin solmut
        }   
                         
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
     * - Algoritmin käynnistysmetodi
     * @param verkko 
     */
    public static void PathBased(int[][] verkko){

    System.out.println("PathBased");
    // Alustus
    color = new int[verkko.length];
    syvyys = new int[verkko.length];
    alin= new int[verkko.length];
    pinoS = new LinkedList();
    pinoP = new LinkedList();    
    komponentti = new TreeSet();    

    Alustus(verkko);        // Aloitetaan etsintä
    
    }
}