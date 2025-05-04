import java.util.*;

class Ponuda{
  String vreme_na_pocetok;
  String grad;
  int iznos;

    public Ponuda( String vreme_na_pocetok, String grad, int iznos) {
        this.vreme_na_pocetok = vreme_na_pocetok;
        this.grad = grad;
        this.iznos = iznos;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Ponuda> mapa = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String datum=sc.next();
            String vreme_na_pocetok=sc.next();
            String grad=sc.next();
            int iznos=sc.nextInt();
            Ponuda p = new Ponuda(vreme_na_pocetok,grad,iznos);
            if (mapa.containsKey(datum)){
                if (mapa.get(datum).iznos<iznos){
                    mapa.put(datum,p);
                }
            }else{
                mapa.put(datum,p);
            }
        }
        String datum = sc.next();
        if (mapa.get(datum)!=null){
            System.out.println(mapa.get(datum).vreme_na_pocetok+" "+mapa.get(datum).grad+" "+mapa.get(datum).iznos);
        }else {
            System.out.println("No offers");
        }
    }
}


