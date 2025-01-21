// Дадена е сортирана низа од N броеви и број М кој го бараме во таа низа.
// Со помош на методата „раздели па владеј“ да се имплементира бинарно пребарување, 
//   да се најде бараниот број во таа низа и да се испечати неговата позиција. 
//   Доколку бројот не е во низата да е испечати "Ne postoi".
// Влез: Првиот број од влезот е големината на низата N и бараниот број М, а потоа во следниот ред се елементите на низата.
// Излез: Позицијата на која се наоѓа бараниот број, или "Ne postoi" доколку бројот не се наоѓа во низата.
// /
// We are given an array of N numbers.
//   Using the method "divide and conquer" write a binary search algorithm that searches for a given number M. 
//   If the number is found, print the position of the number in the array.
//   If the number is not in the array, print "Ne postoi".
// Input: The first number in the input is the size of the array N, and the number we are searching M. 
//   Then in the next line are the array elements.
// Output: The position of the number we are searching, or "Ne postoi" if no such number exists in the array.
// For example:
// Input	Result
// 5 3
// 1 2 3 4 5
// 2
// 7 7
// 1 2 3 4 5 6 7
// 6

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
  int key = sc.nextInt();
        int index = Integer.MAX_VALUE;
 int low = 0;
 int high = n-1;

 int[] sortedArray = new int[n];

        for (int i = 0; i < n; i++) {
            sortedArray[i] = sc.nextInt();
        }
        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        if(index == Integer.MAX_VALUE) {
            System.out.println("Ne postoi");
        }
        else
        System.out.println(index);
    }
}
