// Задача 2. Наjдобра понуда
import java.util.*;

class Predavanje{
    String vreme;
    String grad;
    int iznos;

    public Predavanje(String vreme, String grad, int iznos) {
        this.vreme = vreme;
        this.grad = grad;
        this.iznos = iznos;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
       HashMap<String,Predavanje> mapa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
           Predavanje p = new Predavanje(input[1],input[2],Integer.parseInt(input[3]));
            if (mapa.containsKey(input[0])){
               if (mapa.get(input[0]).iznos<Integer.parseInt(input[3])){
                   mapa.put(input[0],p);
               }
           }else {
               mapa.put(input[0],p);
           }
        }
        String datum = scanner.next();
        if (mapa.containsKey(datum)){
            System.out.println(mapa.get(datum).vreme+" "+mapa.get(datum).grad+" "+mapa.get(datum).iznos);
        }else{
            System.out.println("Nema takov datum");
        }
    }
}
