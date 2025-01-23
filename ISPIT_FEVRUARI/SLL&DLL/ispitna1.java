// 1.Листа јуни 2020 термин 1
//  Ova e prvata zadaca bese dadena dvojno povrzana lista i trebase da se pocne od prviot i
// posledniot element, da se soberat i da se vmetne zbirot vo listata a posle toa da se
// vmetne i pogolemiot broj od dvata a da se izbrise elementot od prviot pokazuvac (onoj
// so pocnal od pocetokot na listata ne od krajot) i taka naizmenicno (vtoriot i
// predposledniot, tretiot i toj pred predposledniot itn) se dodeka ne dojdat do polovina od
// listata t.e. ako e dadena listata 10 4 5 3 6 trebase da se dobie 16 10 7 4 5 3 6 na izlez


import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n%2==0){
            System.out.println("Invalid");
         return;
        }

        int sredina = (n-1)/2;
        int counter = 0;

        DLL<Integer> dll = new DLL<>();

        for (int i = 0; i < n; i++) {
            dll.insertLast(sc.nextInt());
        }
        System.out.println(dll);

        DLLNode<Integer> posleden = dll.getLast();
        DLLNode<Integer> prv = dll.getFirst();

        DLL<Integer> dll2 = new DLL<>();



        for (int i = 0; i < sredina; i++) {
            dll2.insertLast(posleden.element+ prv.element);
            if(posleden.element>prv.element){
                dll2.insertLast(posleden.element);
            }
            else  dll2.insertLast(prv.element);
            posleden=posleden.pred;
            prv=prv.succ;
        }


        while(posleden!=null){
            dll2.insertLast(posleden.element);
            posleden=posleden.succ;
        }
        System.out.println(dll2);
    }
}
