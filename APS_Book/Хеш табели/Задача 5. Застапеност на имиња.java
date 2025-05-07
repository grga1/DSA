import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      HashMap<String,Integer> maski = new HashMap<>();
      HashMap<String,Integer> zenski = new HashMap<>();
      int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String ime = sc.next().toUpperCase();
            String pol = sc.next();
            if (pol.equals("F")){
                if (zenski.containsKey(ime)){
                    zenski.put(ime,zenski.get(ime)+1);
                }else{
                    zenski.put(ime,1);
                }
            }else if (pol.equals("M")){
                if (maski.containsKey(ime)){
                    maski.put(ime,maski.get(ime)+1);
                }else{
                    maski.put(ime,1);
                }
            }

        }
        String pol = sc.next();

        String ime;
        if (pol.equals("F")){
            while (!(ime=sc.next()).equals("END")){
                ime = ime.toUpperCase();

                String prviDveBukvi = ime.substring(0,2);
                for (Map.Entry<String,Integer>entry: zenski.entrySet()){
                    if (entry.getKey().startsWith(prviDveBukvi))
                        System.out.println(entry.getKey());
                }
                if (zenski.containsKey(ime))
                    System.out.println("F "+ime+" "+zenski.get(ime));
                else
                    System.out.println("No such name");
            }
        }
    }
}


