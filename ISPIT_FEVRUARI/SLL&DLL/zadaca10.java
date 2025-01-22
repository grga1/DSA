// Дадена е двострано поврзана листа од цели броеви. 
// Дополнително, дадени се и уште еден цел број M и еден природен број k.
// Треба да се најде првото појавување на M во листата и тој број да се помести k места на десно.
// Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, 
//   па во следните следниот ред самите елементи одделени со празно место. На крај, во последните два реда дадени се целиот број M и природниот број k.
// Излез: На излез треба да се испечати листата пред и после промената.
// /
// You are given a doubly-linked list of integers. Additionally,
//   there is one more integer M and a natural number k. You need to find the first occurence of M in the list and move that node k times to the right.
// Input: The first number in the input is the number of integers in the list - N, 
// then in the next line the elements are given, separated by spaces. Then, in the last two lines, the integer M and the natural number k are given.
// Output: The list before and after the transformation
// For example:
// Input	Result
// 5
// 1 2 3 4 5
// 3
// 2
// 1<->2<->3<->4<->5
// 1<->2<->4<->5<->3
// 9
// 5 3 8 6 2 4 1 9 7
// 4
// 7
// 5<->3<->8<->6<->2<->4<->1<->9<->7
// 5<->3<->8<->4<->6<->2<->1<->9<->7
// 10
// 1 2 3 4 5 6 7 8 9 10
// 11
// 7
// 1<->2<->3<->4<->5<->6<->7<->8<->9<->10
// Elementot ne postoi vo listata
// 1<->2<->3<->4<->5<->6<->7<->8<->9<->10



import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < n; i++) {
            dll.insertLast(scanner.nextInt());
        }
        int M = scanner.nextInt();
        int k = scanner.nextInt();

        DLLNode<Integer> tmp = dll.getFirst();
boolean postoi = false;
boolean after = false;
        System.out.println(dll);

        for (int i = 0; i < n; i++) {
            if(tmp.element==M){
                postoi=true;

                dll.delete(tmp);
                for (int j = 0; j < k; j++) {
                    tmp=tmp.succ;
                    if(tmp==null)
                    {
                        tmp=dll.getFirst();
                     after=true;
                    }
                }
                if(after==true){
                    dll.insertBefore(M,tmp);
                }else
                dll.insertAfter(M,tmp);

                break;
            }
         tmp=tmp.succ;
        }
        if(postoi==false) {
            System.out.println("Elementot ne postoi vo listata");
        }
        System.out.println(dll);

    }
}



