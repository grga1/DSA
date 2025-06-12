// Задача 1. Родендени
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
   HashMap<String,Integer> mapa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] datum = scanner.next().split("\\.");
         mapa.put(datum[1], mapa.getOrDefault(datum[1],0)+1);
        }
        String datum = scanner.next();
        if (mapa.containsKey(datum)){
            System.out.println(mapa.get(datum));
        }else{
            System.out.println(0);
        }
    }
}
