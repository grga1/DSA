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

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        SLL<String> lista = new SLL<>();
        for (int i = 0; i < n; i++) {
            String zbor = scanner.next();
            lista.insertLast(zbor);
        }
        System.out.println(lista);
        SLLNode<String> tmp = lista.getFirst();
        while (tmp!=null){
            SLLNode<String> next = tmp.succ;
            if (Character.isLowerCase(tmp.element.charAt(0))){
                lista.insertLast(tmp.element);
                lista.delete(tmp);
            tmp=tmp.succ;
            }
            tmp=tmp.succ;
        }
        System.out.println(lista);
    }
}
