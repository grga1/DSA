import java.util.*;

class Lek{
    int posneg;
    int cena;
    int brParcinja;

    public Lek(int posneg, int cena, int brParcinja) {
        this.posneg = posneg;
        this.cena = cena;
        this.brParcinja = brParcinja;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      HashMap<String,Lek> mapa = new HashMap<>();
      int n = sc.nextInt();
        for (int i = 0; i <n; i++) {
            String ime=sc.next();
            int posneg=sc.nextInt();
            int cena=sc.nextInt();
            int kolicina = sc.nextInt();
            Lek l = new Lek(posneg,cena,kolicina);
            mapa.put(ime.toUpperCase(),l);
        }
        String vlez ="";
        while (!(vlez=sc.next().toUpperCase()).equals("END")){
            int broj = sc.nextInt();
            if (!mapa.containsKey(vlez)){
                System.out.println("No such drug");
            }else if (mapa.get(vlez).brParcinja>broj){
                System.out.print(vlez);
                if (mapa.get(vlez).posneg==1){
                    System.out.print(" POS ");
                }else{
                    System.out.print(" NEG ");
                }
                System.out.println(mapa.get(vlez).brParcinja+" "+mapa.get(vlez).cena);
                System.out.println("Order made");
            }else {
                System.out.println("No drugs available");
            }
        }

    }
}


