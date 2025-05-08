import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      HashMap<String,String> mapa = new HashMap<>();
      int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String telefon = sc.next();
            String korisnik = sc.next();
            mapa.put(telefon,korisnik);
        }

        String baraj = sc.next();
 if (baraj.startsWith("+")){
     baraj="0"+baraj.substring(4);
 }
        
        String x = "Unknown number";
        for (Map.Entry<String,String>entry: mapa.entrySet()){
            if (baraj.contains(entry.getKey())){
                x=entry.getValue();
                break;
            }
        }
        System.out.println(x);

    }
}


