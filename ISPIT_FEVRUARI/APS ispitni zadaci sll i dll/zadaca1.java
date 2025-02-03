import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DLL<Integer> dll = new DLL<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            dll.insertLast(x);
        }

  DLLNode<Integer> tmpPocetok = dll.getFirst();
  DLLNode<Integer> tmpKraj = dll.getLast();

        DLL<Integer> dllNew = new DLL<>();
        while (tmpPocetok!=null){
            if(tmpPocetok.element==tmpKraj.element){
 break;
            }else {
                dllNew.insertLast(tmpKraj.element+ tmpPocetok.element);

                if(tmpPocetok.element>tmpKraj.element){
                    dllNew.insertLast(tmpPocetok.element);
                }
                else {
                    dllNew.insertLast(tmpKraj.element);
                }
            }
            tmpPocetok=tmpPocetok.succ;
            tmpKraj=tmpKraj.pred;
        }

        while (tmpPocetok!=null){
            dllNew.insertLast(tmpPocetok.element);
            tmpPocetok=tmpPocetok.succ;
        }
        System.out.println(dllNew);
    }
}
