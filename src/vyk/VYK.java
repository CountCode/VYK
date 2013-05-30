package vyk;

/**
 *
 * @author ilkka
 * @version 0.4
 */
public class VYK {
    
   /** 
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
    * Corman s. 615
    * Komponentit:
    * {0,1,4},{2,3},{5,6},{7}
    */
     static int[][] esim2 = new int[][] {
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 1}};     
     
    
    /** 
    * http://en.wikipedia.org/wiki/Tarjan's_strongly_connected_components_alorithm
    * Komponentit:
    * {0,1,4},{2,3},{5,6},{7}
    */
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
    *  Yksi lenkki
    *  Komponentit:
    *  {0,1,2,3,4,5,6,7}
    */
     static int[][] esim4 = new int[][] {
        {0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0}};   
     
     
     /**
      * Generoidaan satunnainen suunnattu verkko
      * @param solmuja verkon solmujen määrä
      * @param tiheys verkon tiheys [0..1]
      * 0 ei yhtään kaarta, 1 kaikkien solmujen välissä kaari
      * @return -generoitu verkko
      */
     
     public static int[][] verkkoja(int solmuja, double tiheys){
         
         if (solmuja==0){
             return null;
         }
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
         if (verkko==null){
            return;
        }       
         
         for (int i=0; i<verkko.length; i++){
             for (int j=0; j<verkko[0].length; j++){
                 System.out.print(verkko[i][j]);
             } // for j
             System.out.println();
         } // for i        
     }
    /**
     * Vertaa algoritmien nopeutta annetulla solmujen lukumäärällä
     * @param solmuja
     * @param tiheys
     */      
    public static void vertaaAlgoritmeja(int solmuja, double tiheys){
        long alkuAika;
        long loppuAika;
        
        int[][] verkko = verkkoja(12, 0.14);     
        
        alkuAika=System.nanoTime();
        Kosaraju.kosaraju(verkko);        
        loppuAika=System.nanoTime();
        System.out.println("Kosaraju: "+(loppuAika-alkuAika));
 
        alkuAika=System.nanoTime();
        Tarjan.tarjan(verkko);          
        loppuAika=System.nanoTime();
        System.out.println("Tarjan: "+(loppuAika-alkuAika));
           
        alkuAika=System.nanoTime();
        PathBased.pathBased(verkko);          
        loppuAika=System.nanoTime();
        System.out.println("PathBased: "+(loppuAika-alkuAika));                      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        vertaaAlgoritmeja(10, 0.14);
     //   int[][] verkko = verkkoja(12, 0.14);
      //  tulostaVerkko(verkko);
        
   //     System.out.println("VYK");
    //    Kosaraju.kosaraju(esim1);    
  //      Kosaraju.kosaraju(esim2);  
    //    Kosaraju.kosaraju(esim3);
     //   Kosaraju.kosaraju(verkko);        
        
    //    Tarjan.tarjan(esim1);
    //    Tarjan.tarjan(esim2);
   //     Tarjan.tarjan(esim3);        
    //    Tarjan.tarjan(verkko);     
        
     //   PathBased.pathBased(esim1);
    //    PathBased.pathBased(esim2);
   //     PathBased.pathBased(esim3);        
    //    PathBased.pathBased(verkko);       
    }
}
