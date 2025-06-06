// Дадено ви е бинарно пребарувачко дрво со N цели броеви.
// Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
// ќе најдете на која длабочина се наоѓа елементот T во дрвото
// Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.
// Влезот ќе содржи N+Q редови од видот 
// insert value - Треба да ја вметнете вредноста value во дрвото.
// ask value - Треба да одговорите на која длабочина во дрвото се наоѓа јазелот со вредност value
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
// 2
// 1
// 2
// 3
// 4
// 3
// 4

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i <= n+q; i++) {
            String[] komandi = scanner.nextLine().split(" ");
            if (komandi[0].equals("insert")){
                bst.insert(Integer.parseInt(komandi[1]));
            }else if (komandi[0].equals("ask")){
                int broj = deep(bst.getRoot(),Integer.parseInt(komandi[1]));
                System.out.println(broj);
            }
        }
    }
    public static int deep(BNode<Integer> node,int n ){
        if (node==null)
            return 0;
        if (node.info==n)
            return 1;
        int left = deep(node.left,n);
        if (left!=0)
            return left+1;
        int right = deep(node.right,n);
        if (right!=0)
            return right+1;
        return 0;
    }

}
