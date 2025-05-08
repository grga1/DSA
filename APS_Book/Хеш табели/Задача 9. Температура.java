import java.util.*;

class city{
    String lokacija;
    String odKoga;
    String doKoga;
    float stepeni;

    public city(String lokacija,String odKoga, String doKoga, float stepeni) {
         this.lokacija=lokacija;
        this.odKoga = odKoga;
        this.doKoga = doKoga;
        this.stepeni = stepeni;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      HashMap<String,city> mapa = new HashMap<>();
      int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String lokacija = sc.next();
            String odKoga = sc.next();
            String doKoga = sc.next();
            float stepeni = sc.nextFloat();
         city c = new city(lokacija,odKoga,doKoga,stepeni);
        String[] grad = lokacija.split(",");
            if (!mapa.containsKey(grad[0])){
                mapa.put(grad[0],c);
            }else if (mapa.get(grad[0]).stepeni<stepeni){
                mapa.put(grad[0],c);
            }
        }

        String[] grad = sc.next().split(",");
       if (!mapa.containsKey(grad[0])){
           System.out.println("Not found");
       }else {
           System.out.println(mapa.get(grad[0]).lokacija+": "+mapa.get(grad[0]).odKoga+" - "+mapa.get(grad[0]).doKoga+" "+mapa.get(grad[0]).stepeni);
       }
    }
}


