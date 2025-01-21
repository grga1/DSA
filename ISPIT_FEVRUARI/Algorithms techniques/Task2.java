// Дадени се N возови со време на пристигање и поаѓање. Да се најде минималниот број на платформи потребен за да се сместат тие возови.
// Влез: Првиот број од влезот е бројот на возови N, а потоа во следниот ред минутата на пристигнување и минутата на поаѓање на возот.
// Излез: Најмалиот потребен број на платформи за да се сместат сите возови
// /
// We are given N trains. Write an algorithm that finds the minimum number of platforms needed to schedule those trains.
// Input: The first number in the input is the number of trains N, then in the next N lines are the arrival and departure minutes for each of the trains.
// Output: The minimum number of needed platforms to accommodate the trains.
// For example:
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
        int [] pristignuvanje=new int[n];
        int [] poaganje= new int[n];


        for (int i = 0; i < n; i++) {
            pristignuvanje[i] = sc.nextInt();
            poaganje[i] = sc.nextInt();
        }
        Arrays.sort(pristignuvanje);
        Arrays.sort(poaganje);

       int pristIndex=0,poagIndex=0;
       int platformi =0,maxPlatformi=0;

       while(pristIndex<n&&poagIndex<n){
           if(pristignuvanje[pristIndex]<=poaganje[poagIndex]){
               platformi++;
               pristIndex++;
               if(platformi>maxPlatformi){
                   maxPlatformi=platformi;
               }
           }else{
               platformi--;
               poagIndex++;
           }
       }

        System.out.println(maxPlatformi);


    }
}
