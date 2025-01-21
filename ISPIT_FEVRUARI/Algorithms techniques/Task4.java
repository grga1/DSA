// Дадени се N состаноци со време на почеток и крај. Да се најде минималниот број на сали за состаноци потребен за да се одржат сите состаноци.
// Влез: Првиот број од влезот е бројот на состаноци N, а потоа во следниот ред минутата на почнување и минутата на завршување на состанокот.
// Излез: Најмалиот потребен број на соби за состаноци за да можат да се одржат сите состаноци
// /
// We are given N scheduled meetings. Write an algorithm that finds the minimum number of meeting rooms needed to schedule those meetings.
// Input: The first number in the input is the number of meetings N, then in the next N lines are the start and end time for each of the meetings.
// Output: The minimum number of needed meeting rooms to schedule the meetings.
//   For example:
// Input	Result
// 5
// 1 2
// 1 2
// 5 10
// 11 14
// 15 20
// 2
// 5
// 1 2
// 2 3
// 3 4
// 4 5
// 5 6
// 2


import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
          int[] pocetok = new int[n];
          int[] kraj = new int[n];

        for (int i = 0; i < n; i++) {
            pocetok[i] = sc.nextInt();
            kraj[i] = sc.nextInt();
        }

        Arrays.sort(pocetok);
        Arrays.sort(kraj);

        int pocetokIndex=0, krajIndex=0;
        int prostorii=0,maxProstorii=0;

        while(pocetokIndex<n&&krajIndex<n){
           if(pocetok[pocetokIndex]<=kraj[krajIndex]){
               prostorii++;
               pocetokIndex++;
               if(prostorii>maxProstorii){
                   maxProstorii=prostorii;
               }
           }else {
               prostorii--;
               krajIndex++;
           }
        }
        System.out.println(maxProstorii);

    }
}
