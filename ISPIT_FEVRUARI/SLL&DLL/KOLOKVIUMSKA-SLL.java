// SLL - Влезна задача

// Се внесува број на стрингови, се печати низата пред промени, секој стринг што почнува со мала буква се преместува на крајот од листата, и па се печате листата

// Input
// 4
// ova
// Eden
// Zdravo
// hawaii

// Output
// ova -> Eden -> Zdravo -> hawaii
// Eden -> Zdravo -> ova -> hawaii

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SLL<String> sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            sll.insertLast(scanner.next());
        }

        System.out.println(sll);

        SLLNode<String> tmp = sll.getFirst();
        String element ="";
        for (int i = 0; i < n; i++) {
            if(!Character.isUpperCase(tmp.element.charAt(0))){
               element=tmp.element;
                sll.delete(tmp);
                sll.insertLast(element);
            }
            tmp=tmp.succ;
        }
        System.out.println(sll);
    }
}
            
