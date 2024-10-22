// Дадена е еднострана поврзана листа чии што јазли содржат по еден String. Дополнително, даден е и уште еден природен број L.
// Во дадената листа потребно е сите јазли коишто содржат String со должина L да се поместат на крај на листата, задржувајќи го и оригиналниот распоред на елементите.

// Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните N редови се дадени самите елементи (String-ови) од листата.
// На крај, во последниот ред е даден бројот L. 

// Излез: На излез треба да се испечати листата пред и после промената.

// /

// You are given a single linked list with String nodes. Additionally, you are given one more integer L.
//   You need to move all nodes from the list that contain a String with exactly L characters to the end of the list, keeping the original order of elements as well.

// Input: In the first line from the input the number of elements in the list is given - N, and then in the next N lines the elements themselves.
//   In the last line, the integer L is given.

// Output: The list before and after the transformation

 import java.util.Scanner;
 class SLLNode<E> {
     protected E element;
     protected SLLNode<E> succ;

     public SLLNode(E elem, SLLNode<E> succ) {
         this.element = elem;
         this.succ = succ;
     }
 }
 class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp.element;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "->" + tmp.element;
            }
        } else
//            MKD version
//            ret = "Prazna lista!!!";
            ret = "Empty list!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
//            MKD version
//            System.out.println("Dadenot jazol e null");
            System.out.println("Given node is null");
        }
    }
    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);;
            } else {
//                MKD version
//                System.out.println("Elementot ne postoi vo listata");
                System.out.println("Element does not exist in the list");
            }
        } else {
//            MKD version
//            System.out.println("Listata e prazna");
            System.out.println("The list is empty");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
//            MKD version
//            System.out.println("Listata e prazna");
            System.out.println("The list is empty");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
//                MKD version
//                System.out.println("Elementot ne postoi vo listata");
                System.out.println("Element does not exist in the list");
                return null;
            }
        } else {
//            MKD version
//            System.out.println("Listata e prazna");
            System.out.println("The list is empty");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
//                MKD version
//                System.out.println("Elementot ne postoi vo listata");
                System.out.println("Element does not exist in the list");
            }
        } else {
//            MKD version
//            System.out.println("Listata e prazna");
            System.out.println("The list is empty");
        }
        return null;
    }

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int n=sc.nextInt();
   int pamti;
        SLL<String> lista = new SLL<String>();
        String sniza;
        int L;
        for (int i = 0; i < n; i++) {
            sniza = sc.next();
            lista.insertLast(sniza);
        }
    L=sc.nextInt();
        System.out.println(lista);
        SLLNode<String> tmp = lista.getFirst();
        String element=" ";
        for (int i = 0; i < n; i++) {

            if(tmp.element.length()==L)
            {
                element=tmp.element;
                lista.delete(tmp);
                lista.insertLast(element);

            }
            tmp=tmp.succ;
        }
        System.out.println(lista);
    }

}
