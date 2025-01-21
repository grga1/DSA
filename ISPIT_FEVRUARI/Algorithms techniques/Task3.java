// Дадени се N задачи кои треба да се изработат. За секоја од задачите го знаеме времето за изработка (во часови) и заработката која ја носи. Да се најде максималната заработка во рок од една 40 часовна работна недела. Напомена дека и делумно сработени задачи носат делумна заработка, во зависност од процентот на завршеност.
// Влез: Првиот број од влезот е бројот на задачи N, а потоа во следниот ред времетраењето на задачата во часови и заработката која ја носи.
// Излез: Максимална заработка која можеме да ја направиме за 40 часа.
// /
// We are given N tasks with estimated completion time and the amount we can earn from that task. Write an algorithm that finds the maximum earnings we can have for 40 hours. Note that we can have a partial earning from a partially completed task.
// Input: The first number in the input is the number of tasks N, then in the next N lines are the time needed for the task and the amount of money we can earn from it.
// Output: The maximum amount we can earn in 40 hours
// For example:
// Input	Result
// 3
// 10 60
// 20 100
// 30 120
// 200
// 1
// 10 60
// 60


import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
          int[] vreme = new int[n];
          int[] zarabotka = new int[n];

        for (int i = 0; i < n; i++) {
            vreme[i] = sc.nextInt();
            zarabotka[i] = sc.nextInt();
 }
        int zarabotka1=0;
        int zarabotka2=0;
 int brojac=0;
        int tmp=40;
        int tmp2=40;

        for (int i = 0; i < n; i++) {

            if(vreme[i]<=tmp) {
                tmp -= vreme[i];
                zarabotka1 += zarabotka[i];
            }
            else if(vreme[i]>tmp) {
                int x = zarabotka[i]/vreme[i];
                zarabotka1+=x*tmp;
                tmp=0;
            }

        }

        tmp=40;
        for (int i = n-1; i >=0 ; i--) {
            if(vreme[i]<=tmp) {
                tmp -= vreme[i];
                zarabotka2 += zarabotka[i];
            }
            else if(vreme[i]>tmp) {
                int x = zarabotka[i]/vreme[i];
                zarabotka2+=x*tmp;
                tmp=0;
            }
        }
tmp=40;
        int zarabotka3=0;
        for (int i = 1; i < n; i++) {

            if(vreme[i]<=tmp) {
                tmp -= vreme[i];
                zarabotka3 += zarabotka[i];
            }
            else if(vreme[i]>tmp) {
                int x = zarabotka[i]/vreme[i];
                zarabotka3+=x*tmp;
                tmp=0;
            }

        }

        int a =Math.max(zarabotka1,zarabotka2);
        int end=Math.max(zarabotka3,a);
        System.out.println(end);
    }
}
