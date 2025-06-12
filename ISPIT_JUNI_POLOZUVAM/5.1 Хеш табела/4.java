// Задача 1. Епидемиjа
import java.util.*;


class Pacient{
    String prezime;
    String virus;

    public Pacient(String prezime, String virus) {
        this.prezime = prezime;
        this.virus = virus;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String,List<Pacient>> mapa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
           Pacient p = new Pacient(input[1],input[2]);
            if (mapa.containsKey(input[0])){
          mapa.get(input[0]).add(p);
            }else{
                mapa.put(input[0],new ArrayList<>());
                mapa.get(input[0]).add(p);
            }
        }
        String opstina = scanner.next();
        List<Pacient> lista = mapa.get(opstina);
         double pozitivni=0;
         double negativni=0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).virus.equals("positive")){
                pozitivni++;
            }else{
                negativni++;
            }
        }

        System.out.printf("%.2f\n",pozitivni/(pozitivni+negativni));
    }

}
