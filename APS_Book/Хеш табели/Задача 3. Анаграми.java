import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
HashMap<String,Integer> mapa = new HashMap<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {

            String[] abc = sc.next().split("");
            Arrays.sort(abc);
            String x = "";
            for (int j = 0; j < abc.length; j++) {
                x += abc[j];
            }
            if (mapa.containsKey(x)){
                mapa.put(x,mapa.get(x)+1);
            }else{
                mapa.put(x,1);
            }
        }
        String[] zbor = sc.next().split("");
        Arrays.sort(zbor);
        String x = "";
        for (int j = 0; j < zbor.length; j++) {
            x += zbor[j];
        }
        if (mapa.get(x)!=null) {
            System.out.println(mapa.get(x));
        }else {
            System.out.println("Nema takov zbor");
        }
    }
}


