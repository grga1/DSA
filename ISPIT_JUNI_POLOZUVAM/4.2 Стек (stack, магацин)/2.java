// Задача 2. Постфикс
// Да се напише алгоритам коj ´ке врши евалуациjа на израз во постфикс нотациjа.
// Пример 5 9 + 2 * 6 5 * + изразот е во постфикс нотациjа, и го претставува
// изразот (5 + 9) * 2 + 6 * 5, со што по евалуациjата резултатот треба да биде 14
// * 2 + 30 = 58.
// Влез: Во влезот е даден изразот коj се внесува.
// Излез: На излез треба да се испечати резултатот од евалуациjата на изразот.
// Пример:
// Влез: 5 9 + 2 * 6 5 * +
// Излез: Rezultatot e 58.0

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x,y;
        double vkupno=0;
        Stack<Double>stack = new Stack<>();
        String[] niza = scanner.nextLine().split(" ");
        for (int i = 0; i < niza.length; i++) {
            if (number(niza[i])){
                stack.push(Double.parseDouble(niza[i]));
            }else {
                double a = stack.pop();
                double b = stack.pop();
                switch (niza[i]){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                }
            }
        }
        System.out.println(stack.peek());
    }
    public static boolean number(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
