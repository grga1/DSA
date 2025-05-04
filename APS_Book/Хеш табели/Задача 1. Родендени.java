import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> mapa = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] datum = sc.next().split("\\.");
            if (mapa.containsKey(datum[1])) {
                mapa.put(datum[1], mapa.get(datum[1]) + 1);
            } else {
                mapa.put(datum[1], 1);
            }
        }
        String mesec = sc.next();
        if (mapa.get(mesec) != null) {
            System.out.println(mapa.get(mesec));
        }else {
            System.out.println("Empty");
        }
    }
}


