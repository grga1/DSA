// Дадено ви е бинарно пребарувачко дрво со N цели броеви.

// Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:

// ќе најдете колку елементи во дрвото се помали од T
// Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.

// Влезот ќе содржи N+Q редови од видот 

// insert value - Треба да ја вметнете вредноста value во дрвото.

// ask value - Треба да одговорите колку елементи во дрвото имаат вредност помала од value

// Пример и структура на влезот:

// Влез

// Објаснување

// Излез


// 10 7
// insert 6
// insert 3
// insert 7
// ask 3
// ask 6
// insert 4
// insert 1
// insert 2
// insert 5
// insert 9
// ask 3
// ask 9
// insert 8
// insert 10
// ask 8
// ask 4
// ask 5
// Прикажано е изгледот на дрвото при секое од 7те прашања во влезот
// 0
// 1
// 2
// 7
// 7
// 3
// 4

import java.util.*;

public class Main {

    public static int lessThan(BNode<Integer> node,int value){
        if(node==null){
            return 0;
        }
        int counter=0;
        if(node.info<value){
            counter++;
        }
        return counter+lessThan(node.left,value)+lessThan(node.right,value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int q= scanner.nextInt();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        scanner.nextLine();
        for (int i = 0; i < n+q; i++) {
      String[] komanda = scanner.nextLine().split(" ");
      if(komanda[0].equals("insert")){
          tree.insert(Integer.parseInt(komanda[1]));
      }
      else if(komanda[0].equals("ask")){
          int answer = lessThan(tree.getRoot(),Integer.parseInt(komanda[1]));
          System.out.println(answer);
      }
        }
    }
}

