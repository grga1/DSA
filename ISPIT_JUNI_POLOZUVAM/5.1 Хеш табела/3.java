// Задача 3. Анаграми
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
                HashMap<String,Integer> mapa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            String word = sortiraj(input);
            mapa.put(word, mapa.getOrDefault(word,0)+1);
        }
        String zborce = scanner.next();
        zborce=sortiraj(zborce);
        if (mapa.containsKey(zborce)){
            System.out.println(mapa.get(zborce));
        }else{
            System.out.println("Nema takov zbor");
        }
    }
    public static String sortiraj(String word){
       List<Character> lista = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            lista.add(word.charAt(i));
        }
        Collections.sort(lista);
        String newWord="";
        for (int i = 0; i < lista.size(); i++) {
            newWord+=Character.toString(lista.get(i));
        }
        return newWord;
    }
}
