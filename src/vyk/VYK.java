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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      //  Kosaraju kosa = new Kosaraju();
        System.out.println("VYK");
        Kosaraju.Kosaraju();    
        
        Tarjan.Tarjan();
    }
}
