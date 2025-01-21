// Дадена е еднострана поврзана листа чии што јазли содржат по еден String. Дополнително, даден е и уште еден природен број L. Во дадената листа потребно е сите јазли коишто содржат String со должина L да се поместат на крај на листата, задржувајќи го и оригиналниот распоред на елементите.

// Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните N редови се дадени самите елементи (String-ови) од листата. На крај, во последниот ред е даден бројот L. 

// Излез: На излез треба да се испечати листата пред и после промената.

// /

// You are given a single linked list with String nodes. Additionally, you are given one more integer L. You need to move all nodes from the list that contain a String with exactly L characters to the end of the list, keeping the original order of elements as well.

// Input: In the first line from the input the number of elements in the list is given - N, and then in the next N lines the elements themselves. In the last line, the integer L is given.

// Output: The list before and after the transformation

// For example:

// Input	Result
// 3
// Sky
// Blue
// Cloud
// 5
// Sky->Blue->Cloud
// Sky->Blue->Cloud
// 4
// Apple
// Banana
// Pear
// Watermelon
// 6
// Apple->Banana->Pear->Watermelon
// Apple->Pear->Watermelon->Banana

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SLL<String> sll = new SLL<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sll.insertLast(sc.next());
        }

        int L = sc.nextInt();
        SLLNode<String> tmp = sll.getFirst();
        String element = " ";
        for (int i = 0; i < n; i++) {
            if(tmp.element.length()==L){
                element = tmp.element;
                sll.delete(tmp);
                sll.insertLast(element);
            }
            tmp=tmp.succ;
        }
        System.out.println(sll);
    }
}
