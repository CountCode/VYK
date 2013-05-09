package tahtia;

public class Tahtia{

    static int kutsut;
    static int[] summa;
    
private static void  tahtia(int lkm){
    int kutsunNumero=kutsut++;
    if (lkm>1) tahtia(lkm-1);
     if (lkm>1) tahtia(lkm-1);
     if (lkm>1) tahtia(lkm-1);    
 for (int i=0; i<lkm;i++){
     System.out.print("*");
     if (i==lkm-1) System.out.println(" "+kutsunNumero);
 }

    int[] kilo = new int[20];
    
    summa = new int[kilo.length];
    
    System.out.print(summa.length);
         
}

    public static void main(String[] args) {
        // TODO code application logic here
        kutsut=1;
        tahtia(3);
       // System.out.print("Anna luku: ");
       // int luku = Integer.parseInt(lukija.nextLine());

       // int vastaus = kertoma(luku);

       // System.out.println("Kertoma: " + vastaus);
    }
}