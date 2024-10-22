
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

  ArrayList<Integer> niza = new ArrayList<>();
  Scanner sc = new Scanner(System.in);
  int x;
  int n=sc.nextInt();
  double prosek=0;
        for (int i = 0; i < n; i++) {
            x=sc.nextInt();
            niza.add(x);
           prosek+=x;
        }
        prosek=prosek/n;
        System.out.print("{");
        for (int i = 0; i < niza.size(); i++) {
            System.out.print(niza.get(i));
            if (i<niza.size()-1)
            {
                System.out.print(",");
            }
        }
        System.out.println("}");
        for (int i = niza.size()-1; i >= 0; i--) {
            if(niza.get(i)<prosek){
                niza.remove(i);
            }
        }
        System.out.print("{");
        for (int i = 0; i < niza.size(); i++) {
            System.out.print(niza.get(i));
         if (i<niza.size()-1){
             System.out.print(",");
         }
        }
        System.out.print("}");
    }
}
