import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      HashMap<String,ArrayList<String>> mapa = new HashMap<>();
      int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String ime = sc.next();
            String datum = sc.next();
            String[] mesec = datum.split("\\.");
            mapa.putIfAbsent(mesec[1], new ArrayList<>());
            if (!mapa.get(mesec[1]).contains(ime)){
                mapa.get(mesec[1]).add(ime);
            }
        }
        String c = sc.next();
        if (mapa.containsKey(c)){
            for (int i = 0; i < mapa.get(c).size(); i++) {
                System.out.println(mapa.get(c).get(i));
            }
        }else {
            System.out.println("Not found");
        }

    }
}


