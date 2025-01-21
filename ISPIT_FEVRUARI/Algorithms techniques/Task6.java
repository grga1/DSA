// Даден е бинарен стринг S. Бинарен стринг е стринг којшто во себе соджи само ‘1’ и ‘0’.
//   Подстринг на бинарен стринг се нарекува позитивен ако бројот на '1' во подстрингот е строго поголем од бројот на '0'. 
//   Да се испечати бројот на позитивни подстрингови за внесениот стринг.
// Влез: Во првиот ред на влезот е должината на стрингот N. Во вториот ред е бинарниот стринг S
// 5
// 10011
// Излез: На излез треба да се испечати бројот на позитивни подстрингови во S
// 6
// Објаснување: За дадениот стринг 10011, позитивни подстрингови се:
// 1(позиција 0)
// 1(позиција 3)
// 1 (позиција 4)
// 11 (позиции 3 и 4)
// 011 (позиции 2 до 4)
// 10011 (целиот стринг)
// You are given a binary string S. A binary string is a string that contains only '1's and '0's.
//   A substring of a binary string is called positive if the number of '1's in the substring is strictly greater than the number of '0's.
//   Print the number of positive substrings for the given string.
// Input: The first line of the input contains the length of the string N. The second line contains the binary string S.
// 5
// 10011
// Output: The output should print the number of positive substrings in S
// 6
// Explanation: For the given string 10011, the positive substrings are:
// 1(position 0)
// 1(position 3)
// 1 (position 4)
// 11 (positions 3 и 4)
// 011 (positions from 2 to 4)
// 10011 (the entire string)
// For example:
// Input	Result
// 5
// 10011
// 6
// 3
// 101
// 3

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int s = scanner.nextInt();
       String niza = scanner.next();
     int sum=0;
        for (int i = 0; i < niza.length(); i++) {
            int kecovi = 0;
            int nuli = 0;
            for (int j = i; j < niza.length(); j++) {
 if(niza.charAt(j)=='1'){
     kecovi++;
 }else nuli++;
 if (kecovi>nuli){
     sum++;
 }
            }
        }

        System.out.println(sum);

 }
}

