// Дадени се Н цифри. Да се напише алгоритам кој ќе го даде најголемиот можен број составен од тие цифри.

// Влез: Првиот број од влезот е бројот на цифри N, а потоа во следниот ред се цифрите.


// Излез: Најголемиот број кој може да се состави од тие цифри

// /

// We are given N digits. Write an algorithm that composes the largest possible number from those digits.

// Input: The first number in the input is the number of digits N, then in the next line are the given digits.

// Output: The maximum possible number containing those digits

// For example:
// Input	Result
// 5
// 1 2 3 4 5
// 54321
// 7
// 9 7 3 7 9 3 1
// 9977331


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]<arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
