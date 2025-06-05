// Да се напише алгоритам кој ќе пресметува (евалуира) математички израз составен од броеви и операциите за собирање (+) и множење (*). 

// Забелешка: Операцијата множење има предност пред операцијата собирање. 

// /

// Write an algorithm that will calculate (evaluate) a mathematical expression that consists of numbers and operations for adding (*) and multiplying (*).

// Note: The operation of multiplying has precedence before the operation of adding.

// For example:

// Input	Result
// 2+2*2*2*2*2*2+2*2
// 70

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String recenica= scanner.nextLine();
        String[] nizaZaMnozenje = recenica.split("\\+");
   int sum=0;

    for (String blok:nizaZaMnozenje){
        String [] mnoziteli = blok.split("\\*");
        int proizvod=1;
        for (String s: mnoziteli){
            proizvod*=Integer.parseInt(s);
        }
        sum+=proizvod;
    }
        System.out.println(sum);



    }

}
