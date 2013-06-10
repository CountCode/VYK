package vyk;

/**
 * VYK - Vahvasti Yhtenäiset Komponentit
 * Luokka toimii verkon vahvasti yhtenäisten komponenttien etsintää
 * suorittavien algorimien "testikeskuksena".
 * @author ilkka
 * @version 0.41
 */
public class VYK {
    
   /* TESTIMATRIISEJA */ 
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
        
        int[][] verkko = verkkoja(solmuja, tiheys);     
        System.out.println("Solmuja: "+solmuja+" Tiheys: "+tiheys);
        
        alkuAika=System.nanoTime();
        Kosaraju.kosaraju(verkko);
      //  System.out.println(Kosaraju.kosaraju(verkko));        
        loppuAika=System.nanoTime();
        System.out.println("Kosaraju: "+(loppuAika-alkuAika));
 
        alkuAika=System.nanoTime();
        Tarjan.tarjan(verkko);
      //  System.out.println(Tarjan.tarjan(verkko));          
        loppuAika=System.nanoTime();
        System.out.println("Tarjan: "+(loppuAika-alkuAika));
           
        alkuAika=System.nanoTime();
        PathBased.pathBased(verkko);
       // System.out.println(PathBased.pathBased(verkko));          
        loppuAika=System.nanoTime();
        System.out.println("PathBased: "+(loppuAika-alkuAika));                      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int solmuja;
        double tiheys;
       
        if (args.length==2){
             try {
                solmuja = Integer.parseInt(args[0]);
                tiheys = Double.parseDouble(args[1]);
                System.out.println(solmuja);
                System.out.println(tiheys);      
            } // try
            catch (Exception e) {
                System.out.println("Virheelliset parametrit");
                System.out.println("Oikeat tavat:");
                System.out.println("Joko ilman parametreja");
                System.out.println("Tai sitten");
                System.out.println("int double");
                return;
            } // catch
            if (solmuja<0){
                System.out.println("Solmuja pitää olla positiivinen määrä.");
                return;
            }
            if (tiheys<0 || tiheys>1) {
                System.out.println("Tiheyden on oltava nollan(0) ja yhden(1) välillä.");
                return;
            }
            vertaaAlgoritmeja(solmuja, tiheys);
            
        } else {      
        vertaaAlgoritmeja(1, 0.1);           
        vertaaAlgoritmeja(1, 0.1);
        vertaaAlgoritmeja(5, 0.1);
        vertaaAlgoritmeja(10, 0.1);
        vertaaAlgoritmeja(50, 0.1);
        vertaaAlgoritmeja(100, 0.1);
        vertaaAlgoritmeja(500, 0.1);
        vertaaAlgoritmeja(1000, 0.1);   
            
//          System.out.println(PathBased.pathBased(esim1));           
//         System.out.println(PathBased.pathBased(esim2));           
//         System.out.println(PathBased.pathBased(esim2));             
        }
    }
}
