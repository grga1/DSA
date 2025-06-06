// Stack
// Најди ја фунцкијата што повикува највеќе фунцкии во неа. Секоја фунцкија има Call x - x е името на фунцкијата - и Return.
// Input
// 12
// Call a
// Call b
// Call c
// Return
// Call d
// Return
// Call e
// Return
// Return
// Call f
// Return
// Return
// Output
// b 3
// Објаснување: во b се повикани c d и e

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       Stack<String> stack = new Stack<>();
       HashMap<String,Integer> mapa = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] komandi = scanner.nextLine().split(" ");
            if (komandi[0].equals("Call")){
                if (!stack.isEmpty()){
                    String povikuvac = stack.peek();
                    mapa.put(povikuvac,mapa.getOrDefault(povikuvac,0)+1);
                }
                    stack.add(komandi[1]);
            }else if (komandi[0].equals("Return")){
                stack.pop();
            }
        }
        int max=-100;
        String bukva = "/";
        for (Map.Entry<String,Integer>entry: mapa.entrySet()){
              if (entry.getValue()>max){
                  max=entry.getValue();
                  bukva=entry.getKey();
              }
        }
        System.out.println(bukva+" "+max);
    }


}
