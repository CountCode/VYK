/*
 * 
 */
package vyk;

/**
 *
 * @author ilkka
 * @version 0.31
 */
public class VYK {
    
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
      * Tulostaa annetun vierusmatriisin
      * @param verkko 
      */     
          public static void tulostaVerkko(int[][] verkko){
        
         
         for (int i=0; i<verkko.length; i++){
             for (int j=0; j<verkko[0].length; j++){
                 System.out.print(verkko[i][j]);
             } // for j
             System.out.println();
         } // for i        
     }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] verkko = verkkoja(12, 0.14);
      //  tulostaVerkko(verkko);
        
      //  Kosaraju kosa = new Kosaraju();
   //     System.out.println("VYK");
    //    Kosaraju.Kosaraju(esim1);    
  //      Kosaraju.Kosaraju(esim2);  
    //    Kosaraju.Kosaraju(esim3);
     //   Kosaraju.Kosaraju(verkko);        
        
    //    Tarjan.Tarjan(esim1);
    //    Tarjan.Tarjan(esim2);
   //     Tarjan.Tarjan(esim3);        
        Tarjan.Tarjan(verkko);     
        
     //   PathBased.PathBased(esim1);
    //    PathBased.PathBased(esim2);
   //     PathBased.PathBased(esim3);        
        PathBased.PathBased(verkko);       
    }
}
