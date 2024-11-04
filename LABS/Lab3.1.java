// Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.

// Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.


// Излез: Најголемиот број кој може да се состави од тие цифри

// /

// We are given N digits. Write an algorithm that composes the largest possible number from those digits.

// Input: The first number in the input is the number of digits N, then in the next line are the given digits.

// Output: The maximum possible number containing those digits

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] niza =  new int[n];
        int x;
        for (int i = 0; i < n; i++) {
            x=sc.nextInt();
            niza[i]=x;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(niza[i]<niza[j]){
                    int temp=niza[i];
                    niza[i]=niza[j];
                    niza[j]=temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(niza[i]);
        }
    }
}
