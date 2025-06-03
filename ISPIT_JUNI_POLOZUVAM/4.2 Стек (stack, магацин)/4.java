// Задача 1. Поништување топчиња
// Да се напише алгоритам со коj ´ке се имплементира играта “Поништување топчиња”. Во оваа игра на располагање имате топчиња во три различни бои (R-црвена,
// G-зелена и B-сина), обележани со знакот + или -. Поништување на топчиња може да настане само доколку тие се од иста боjа и со спротивен знак. На почеток
// се генерира една случаjна листа со топчиња. Ваша задача е од тоj влез, како
// доа´гаат топчињата да направите поништување и да кажете колку, од каков тип
// (+ или -) и од коjа боjа фалат за да се поништат сите топчиња од влезот.
// Влез: Во влезот е дадена листа од случаjни топчиња и тоа во облик: боjа,
// знак.
// Излез: На излез треба да се испечатат броjот на парови и паровите кои може
// да се формираат.
// Пример:
// Влез: R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
// Парови кои може да се формираат од овоj список се: (R+,R-); (B+, B-); (BB+); (R+, R-); (G-, G+); (R+, R-) Остануваат без партнер: G+, G+, B+, R+
// Излез:
// 4
// R- G- G- B+


import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       Stack<String>R = new Stack<>();
       Stack<String>G = new Stack<>();
       Stack<String>B = new Stack<>();

       String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < line.length; i++) {

       if (line[i].equals("R-")){
           if (!R.isEmpty()&&R.peek().equals("+")){
               R.pop();
               continue;
           }
           R.push("-");
       }else if (line[i].equals("R+")){
           if (!R.isEmpty()&&R.peek().equals("-")){
               R.pop();
               continue;
           }
           R.push("+");
       }else if (line[i].equals("G-")){
           if (!G.isEmpty()&&G.peek().equals("+")){
               G.pop();
               continue;
           }
           G.push("-");
       }else if (line[i].equals("G+")){
           if (!G.isEmpty()&&G.peek().equals("-")){
               G.pop();
            continue;
           }
           G.push("+");
       }else if (line[i].equals("B-")){
           if (!B.isEmpty()&&B.peek().equals("+")){
               B.pop();
               continue;
           }
           B.push("-");
       }else if (line[i].equals("B+")){
           if (!B.isEmpty()&&B.peek().equals("-")){
               B.pop();
               continue;
           }
           B.push("+");
       }

        }

        System.out.println(R.size()+G.size()+B.size());
        while (!R.isEmpty()){
            if (R.pop().equals("-")) {
                System.out.println("R+");
            }else {
                System.out.println("R-");
            }
        }
        while (!G.isEmpty()){
            if (G.pop().equals("-")) {
                System.out.println("G+");
            }else {
                System.out.println("G-");
            }
        }
        while (!B.isEmpty()){
            if (B.pop().equals("-")) {
                System.out.println("B+");
            }else {
                System.out.println("B-");
            }
        }


    }
}
