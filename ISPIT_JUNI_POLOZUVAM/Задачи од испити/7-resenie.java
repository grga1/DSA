import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,String> mapa = new HashMap<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String tablicka = scanner.next();
            String imePrezime = scanner.nextLine();
            mapa.put(tablicka,imePrezime);
        }
        int brzina = scanner.nextInt();

        ArrayList<String> kazneti = new ArrayList<>();
      HashMap<String,String> mapa2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tablicka = scanner.next();
            int brzi = scanner.nextInt();
            String vreme = scanner.next();
            if (brzi>brzina){
                mapa2.put(vreme,mapa.get(tablicka));
                kazneti.add(vreme);
            }
        }
        Collections.sort(kazneti);
        for (int i = 0; i < kazneti.size(); i++) {
            System.out.println(mapa2.get(kazneti.get(i)));
        }
    }

}
