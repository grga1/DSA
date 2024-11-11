// Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа.
//   Со помош на методата „раздели па владеј“ да се имплементира бинарно пребарување, 
//   да се најде бараниот број во таа низа и да се испечати неговата позиција.
//   Доколку бројот не е во низата да е испечати "Ne postoi".

// Влез: Првиот број од влезот е големината на низата N и бараниот број М, 
//   а потоа во следниот ред се елементите на низата.


// Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.

// /

// We are given an array of N numbers.
//   Using the method "divide and conquer" write a binary search algorithm that searches for a given number M. 
//   If the number is found, print the position of the number in the array. If the number is not in the array,
//   print "Ne postoi".

// Input: The first number in the input is the size of the array N,
//   and the number we are searching M. Then in the next line are the array elements.

// Output: The position of the number we are searching,
//   or "Ne postoi" if no such number exists in the array.

import java.util.Scanner;

public class Main {
    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int result = binarySearch(arr, m);

        if (result == -1) {
            System.out.println("Ne postoi");
        } else {
            System.out.println(result);
        }
    }
}
