// За дадена низа од N цели броеви, да се избришат елементите со вредност помала од просекот на сите елементи во низата.
// На пример за низата 1, 2, 3, 4, 5 просекот е (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3, 
// што значи треба да се избришат елементите 1 и 2, што значи низата после оваа трансформација ќе биде 3, 4, 5.
// Влез: Првиот број од влезот е бројот на елементи во низата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
// Излез: Низата пред и после направената трансформација.
// /
// For a given array with N integers, all the elements that are lower than the average of the whole array need to be deleted.
// For example for the array 1, 2, 3, 4, 5 the average is (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3 which means that the elements 1 and 2 should be deleted, 
// so the array after the transformation will be 3, 4, 5.
// Input: The first number in the input is the number of integers in the array N, then in the next line the elements are given, separated by spaces.
// Output: The array before and after the transformation.
// For example:
// Input	Result
// 5
// 1 2 3 4 5
// {1,2,3,4,5}
// {3,4,5}

import java.lang.reflect.Array;
import  java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        int s=0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            s+=x;
            array.add(x);
        }
        double prosek = (double)s/n;
        System.out.print("{");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (array.get(i)>=prosek) {
                array2.add(array.get(i));
            }
            if (i<array.size()-1)
                System.out.print(",");
        }
        System.out.println("}");

        System.out.print("{");
        for (int i = 0; i < array2.size(); i++) {
            System.out.print(array2.get(i));
            if (i < array2.size() - 1)
                System.out.print(",");

        }
        System.out.println("}");

    }
}
