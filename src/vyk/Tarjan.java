/**
 *  Tarjan algoritmi verkon vahvasti yhtenäisten komponenttien löytämseksi
 * 
 *
 * @author ilkka
 * @version 0.2
 */
package vyk;

import java.util.LinkedList;

public class Tarjan {
    
    public static int aika;
    public static int[] color;
    public static LinkedList pino;
    public static int[] dfsnum;
    public static int[] low;
    
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

 
    /*   DFS(G)
    {
    make a new vertex x with edges x->v for all v
    initialize a counter N to zero
    initialize list L to empty
    build directed tree T, initially a single vertex {x}
    visit(x)
    }
    */   
    /**
     * - Alustaa apumuuttujat verkon ensimmäistä läpikäyntiä varten
     * - Käynnistää läpikäynnin
     * - Valitsee uudet solmut numerojärjestyksessä
     * @param verkko 
     */
    
        public static void Alustus(int[][] verkko){
        
    //    System.out.println("Alustus 1");

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
    //      visit(p)
 
   
    color[solmu]=0;                         // add p to L   
    dfsnum[solmu]=aika;                     // dfsnum(p) = N
    aika=aika+1;                            // increment N
    low[solmu]=dfsnum[solmu];               // low(p) = dfsnum(p)
    for (int i=0;i<verkko.length;i++){      //for each edge p->q
        if (i!=-1){                         // if q is not already in T ??
                                            // add p->q to T ??
            SSE(verkko, i);                 // visit(q)
            low[solmu]=Math.min(low[solmu],low[i]); // low(p) = min(low(p), low(q))
        } // if
        else {
            low[solmu]=Math.min(low[solmu],dfsnum[i]); // else low(p) = min(low(p), dfsnum(q))
        } // else
    } // for
    
    if (low[solmu]==dfsnum[solmu]){         // if low(p)=dfsnum(p)
        System.out.println("Komponentti:");  // output "component:"
                        
                        // repeat
                        // remove last element v from L
                        // output v
                        // remove v from G
                        // until v=p
     } //if               
    }  
    
    /**
     * - Algoritmin käynnistysmetodi
     */
    public static void Tarjan(){

    System.out.println("Tarjan");
    
    int[][] verkko = esim1;
    color = new int[verkko.length];
    dfsnum = new int[verkko.length];
    low= new int[verkko.length];
    pino = new LinkedList();

    Alustus(verkko);
    

    }


}
