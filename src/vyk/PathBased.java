package vyk;

/**
 * PathBased-algoritmi verkon vahvasti yhtenäisten komponenttien löytämiseksi
 * @author ilkka
 * @version 0.44
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
    public static Pino pinoS;
    /**
     * Kerää talteen käydyt solmut
     */
    public static Pino pinoP;      
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
    public static HakuPuu komponentti;
    
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
     * Kerää verkon vahvasti yhtenäiset komponentit
     */
    public static String verkonKomponentit="{";
    
    /**
     * Lisää vahvasti yhtenäisen komponentin
     * @param komponentti 
     */
    public static void lisaaKomponentti(String komponentti){
        verkonKomponentit=verkonKomponentit+komponentti;
    }
    
    /**
     * Palauttaa verkon vahvasti yhtenäiset komponentit
     * @return 
     */
    public static String palautaVerkonKomponentit(){
        return verkonKomponentit+"}";
    }
   
    /**
     * - Alustaa apumuuttujat verkon ensimmäistä läpikäyntiä varten
     * - Käynnistää läpikäynnin
     * - Valitsee uudet solmut numerojärjestyksessä
     * @param verkko 
     */    
        public static String alustus(int[][] verkko){
 //       System.out.println("Alustus");
        if (verkko==null){
            return "{}";
        }
        
        String komponentitMerkkijonona="{";

        for (int solmu=0; solmu< verkko.length; solmu++){ // Jokaiselle solmulle u e V
            color[solmu]=-1;        // -1 = solmut käsittelemättä
         } // for
        aika = 0;
        
        for (int solmu=0; solmu<verkko.length; solmu++){ // Jokaiselle solmulle u e V
            if (color[solmu]==-1){
                //komponentitMerkkijonona=komponentitMerkkijonona+sse(verkko, solmu);
                sse(verkko, solmu);
                //System.out.println(komponentitMerkkijonona);
            } // if
        } // for
        return palautaVerkonKomponentit();
    }
    
    /**
     * - Syvyys Suuntainen Etsintä
     * - Etsii verkon vahvasti yhtenäiset komponentit
     * @param verkko
     * @param solmu 
     */    
    public static String sse(int[][] verkko, int solmu){  
    //    System.out.println("SSE:"+solmu+" aika:"+aika);
        if (verkko==null){
            return "{}";
        }        
        
        int pinosta;
        String komponenttiMerkkijonona ="";
        color[solmu]=0;                         // solmu käsittelyssä
        syvyys[solmu]=aika;                     // solmun syvyys
        alin[solmu]=aika;                       // solmun komponentin alin
        aika=aika+1;                            // lisää syvyyttä
        pinoS.push(solmu);                        // pinoon C
        pinoP.push(solmu);                        // pinoon  P   
        
        for (int kaari=0;kaari<verkko.length;kaari++){      // joka kaarelle
            if (verkko[solmu][kaari]==1 && color[kaari]==-1){ // if q is not already in T ??
                sse(verkko, kaari);                 // seuraavaan solmuun
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
           komponenttiMerkkijonona = tulostaKomponentti();
         //  System.out.println("T"+komponenttiMerkkijonona);
           lisaaKomponentti(komponenttiMerkkijonona);
        }   
      //  System.out.println("sse:"+komponenttiMerkkijonona);
       return komponenttiMerkkijonona;             
    }  
 
    /**
     * Kerää vahvasti yhtenäisen komponentin solmut yhteen
     * @return vahvasti yhtenäinen komponentti merkkijonona
     */
    public static String tulostaKomponentti(){
        String komponenttiMerkkijonona = "{";
        while (!komponentti.isEmpty()){
            komponenttiMerkkijonona=komponenttiMerkkijonona+komponentti.pollFirst();
            if (!komponentti.isEmpty()){
              komponenttiMerkkijonona=komponenttiMerkkijonona+",";               
            }
        }      
        komponenttiMerkkijonona=komponenttiMerkkijonona+"}"; 
        // System.out.println(komponenttiMerkkijonona);
        return komponenttiMerkkijonona;
    }    
    
    /**
     * - Algoritmin käynnistysmetodi
     * @param verkko 
     */
    public static String pathBased(int[][] verkko){
//    System.out.println("PathBased");
        if (verkko==null){
            return "{}";
        }     
        
    // Alustus
    color = new int[verkko.length];
    syvyys = new int[verkko.length];
    alin= new int[verkko.length];
    pinoS = new Pino();
    pinoP = new Pino();    
    komponentti = new HakuPuu();    

    alustus(verkko);        // Aloitetaan etsintä
    return palautaVerkonKomponentit();
    }
}