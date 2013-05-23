package vyk;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 *  Tarjan algoritmi 
 * - Verkon vahvasti yhtenäisten komponenttien löytämseksi
 * 
 * @author ilkka
 * @version 0.3
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
    public static LinkedList pino;
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
     * - Etsii vahvasti yhtenäiset komponentit
     * @param verkko
     * @param solmu 
     */    
    public static void SSE(int[][] verkko, int solmu){
  
        System.out.println("SSE:"+solmu+"aika:"+aika);
   
        color[solmu]=0; 
        syvyys[solmu]=aika;                     // solmun syvyys
        alin[solmu]=aika;                       // solmun komponentin alin
        aika=aika+1;                            // lisää syvyyttä
        pino.push(solmu);                        // pinoon     
        for (int kaari=0;kaari<verkko.length;kaari++){      // joka kaarelle
            if (verkko[solmu][kaari]==1 && color[kaari]==-1){ // if q is not already in T ??
                                            // add p->q to T ??
                SSE(verkko, kaari);                 // seuraavaan solmuun
                alin[solmu]=Math.min(alin[solmu],alin[kaari]); // jos komponentista löytynyt alempi solmu
            } // if
            else if (pino.contains(kaari)){         // Jos kaari on pinossa
            alin[solmu]=Math.min(alin[solmu],syvyys[kaari]); // jos kaari on alempana
            } // else if
        } // for
    
        // BUGI BUGI 
        
        
        if (alin[solmu]==syvyys[solmu]){         // jos olemme alimmassa solmussa
      //      System.out.println("Komponentti:");  // output "component:"
            boolean valmis=true;
            int w;
            while (valmis){                      // repeat
        //        System.out.println("lisää");   // komponentin solmut yhteen
                w=(Integer)pino.pop();
                System.out.println(w+":"+solmu);
                komponentti.add(w);
                if (solmu==w){
                    valmis=false;
                } // if
            } // while
            Komponentti();                      // tulostetaan komponetin solmut
        } //if               
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
     */
    public static void Tarjan(){

    System.out.println("Tarjan");
    // Alustus
    int[][] verkko = esim1;
    color = new int[verkko.length];
    syvyys = new int[verkko.length];
    alin= new int[verkko.length];
    pino = new LinkedList();
    komponentti = new TreeSet();    

    Alustus(verkko);        // Aloitetaan etsintä
    
    }
}