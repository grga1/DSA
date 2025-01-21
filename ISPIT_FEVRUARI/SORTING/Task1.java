// Дадена е низа со N природни броеви.
// Треба да се сортира низата така што во првиот дел од низата ќе бидат подредени непарните броеви од неа во растечки редослед, 
// а во вториот дел парните броеви во опаѓачки редослед. 
// Во првиот ред од влезот даден е бројот на елементи во низата N, 
// а во вториот ред се дадени броевите. 
// На излез треба да се испечати сортираната низа.
// Име на класата: OddEvenSort
// ----------------
// Given a sequence of N natural numbers.
//   It is necessary to sort the sequence so that in the first part of the sequence the odd numbers from it will be sorted in ascending order,
//   and in the second part the even numbers will be sorted in descending order.
// In the first line of the input, the number of elements in the array N is given, 
//   and in the second line, the numbers are given. The output should print the sorted array.
// Class Name: OddEvenSort
// For example:
// Input	Result
// 7
// 2 5 3 5 8 6 10
// 3 5 5 10 8 6 2


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n=scanner.nextInt();
       int[] niza = new int[n];
       int p=0;
       int ne =0;
       for (int i = 0; i < n; i++) {
            niza[i]=scanner.nextInt();
          if(niza[i]%2==0) p++;
          else ne++;
        }
        int[]parni =new int[p];
        int[]neparni=new int[ne];
        int brojac1=0,brojac2=0;
        for (int i = 0; i <n; i++) {
         if(niza[i]%2==0){
             parni[brojac1++]=niza[i];
         }
         else {
             neparni[brojac2++]=niza[i];
         }
        }
        Arrays.sort(neparni);
        Arrays.sort(parni);
        for (int i = 0; i < ne; i++) {
            System.out.print(neparni[i]+" ");
        }

        for (int i = p-1; i >=0 ; i--) {
            System.out.print(parni[i]+" ");
        }
 }
 }


