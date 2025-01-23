// 2.Листа септември 2019 термин 2
//  Za dadena edinecno povrzana lista i cel broj X treba da se promeni listata taka sto site
// jazli so vrednost pomala od X ke se premestat pred jazlite koi imaat vrednost pogolema
// ili ednakva na X. Treba da se zacuva originalniot relativen redosled na jazlite na dvata
// dela od listata (pomali i pogolemi od X). Prviot red od vlezot e daden brojot N (N <= 100
// ) na jazli vo listata, vo vtoriot red se dadeni broevite (celi broevi) od koi e sostavena
// listata, a vo tret red e daden brojot X.


import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer>sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            sll.insertLast(sc.nextInt());
        }
        System.out.println("Vnesi broj X");
        int x=sc.nextInt();

        SLLNode<Integer> tmp = sll.getFirst();

        SLL<Integer>sll2 = new SLL<>();

        for (int i = 0; i < n; i++) {
         if (tmp.element<x){
             sll2.insertLast(tmp.element);
             sll.delete(tmp);

         }
         tmp=tmp.succ;
        }
        System.out.println(sll2+"->"+sll);
    }
}
