// Задача 2. Молекула на вода
// Да се напише алгоритам со коj ´ке се имплементира играта “Направи молекула
// на вода”. Во оваа игра на располагање имате два типа атоми (H-водород, и Oкислород). За да се направи молекула на вода (H2O) потребно е да имате два
// атоми на водород и еден атом на кислород. На почеток се генерира една случаjна
// секвенца од атоми. Ваша задача е од тоj влез, како доа´гаат атомите да генерирате
// молекули и да кажете колку такви молекули се креирале, и кои атоми останале
// несврзани.
// Влез: Во влезот е дадена секвенца од случаjни атоми
// Излез: На излез треба да се испечати броjот на молекули H2O, и несврзаните
// атоми од водород и кислород.
// Пример:
// Влез:
// H H O H H O H H O H H H H H O H O H O O H O O H H H
// Излез:
// 8
// H
// O

import java.util.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        Stack<String> pomosen = new Stack<>();
        String[] niza = scanner.nextLine().split("");
        int counter=0;
        for (int i = 0; i < niza.length; i++) {
            if (niza[i].equals("H")){
                stack.push("H");
            }else if (niza[i].equals("O")){
                if (stack.size()>=2){
                    counter++;
                    stack.pop();
                    stack.pop();
                }else{
                    pomosen.add("O");
                }
            }
        }

        if (stack.size()>=2&&pomosen.size()>=1) {
            for (int i = 0; i < pomosen.size(); i++) {
                stack.pop();
                stack.pop();
                pomosen.pop();
       counter++;
            }
        }
        System.out.println(counter);
        System.out.println(stack);
        System.out.println(pomosen);
    }
}

