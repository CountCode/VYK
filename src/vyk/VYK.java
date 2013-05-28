/*
 * 
 */
package vyk;

/**
 *
 * @author ilkka
 * @version 0.3
 */
public class VYK {
    
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
     
     
    // Corman s. 615
    // {0,1,4},{2,3},{5,6},{7}
     static int[][] esim2 = new int[][] {
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 1}};     
     
    
    // http://en.wikipedia.org/wiki/Tarjan's_strongly_connected_components_alorithm
    // {0,1,4},{2,3},{5,6},{7}
     static int[][] esim3 = new int[][] {
        {0, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 1}};     
     
     
     /**
      * Generoidaan suunnattu verkko
      * @param solmuja verkon solmujen määrä
      * @param tiheys verkon tiheys [0..1]
      * 0 ei yhtään kaarta, 1 kaikkien solmujen välissä kaari
      * @return -generoitu verkko
      */
     
     public static int[][] verkkoja(int solmuja, double tiheys){
         
         int[][] verkko= new int[solmuja][solmuja];
         
         for (int i=0; i<solmuja; i++){
             for (int j=0; j<solmuja; j++){
                 if  (Math.random()<tiheys){
                     verkko[i][j]=1;
                 } else {
                     verkko[i][j]=0;
                 } // if {} else{}
          //       System.out.println(verkko[i][j]);
             } // for j
         } // for i
         
         
         return verkko;
     }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //    int[][] verkko = verkkoja(32, 0.07);
        
      //  Kosaraju kosa = new Kosaraju();
        System.out.println("VYK");
    //    Kosaraju.Kosaraju(esim1);    
        Kosaraju.Kosaraju(esim2);   // Bugi: solmu 3 kahdessa komponentissa 
                                    // ei kuulu 5 ja 6 samaan komponenttiin.
    //    Kosaraju.Kosaraju(esim3);
    //    Kosaraju.Kosaraju(verkko);        
        
    //    Tarjan.Tarjan(esim1);
        Tarjan.Tarjan(esim2);
    //    Tarjan.Tarjan(esim3);        
    //    Tarjan.Tarjan(verkko);        
    }
}
