// Дадена е еднострана поврзана листа од броеви со дупликати. За дадена вредност на info поле во листата, да се обезбеди бројот на повторувања на тој број да биде парен. Доколку за дадената вредност на инфо полето, бројот на елементи со таа вредност е непарен, треба да се додаде истиот елемент пред првото појавување на елементот со таа вредност  во листата.
// Забелешка: 0 е парен број. 
// Влез:
// Во првиот ред се внесуваат бројот на елементи во листата, па потоа самите елементи, а на крај се внесува бројот (вредноста) кој ќе се осигураме дека се појавува парен број на пати.
// Излез:
// Листата со парен број на дупликати за дадената вредност
// Примери:
// Влез:
// 6
// 1 2 5 7 9 12
// 7
// Излез:
// 1 2 5 7 7 9 12
// Влез:
// 8
// 7 1 2 7 5 9 7 12
// 7
// Излез:
// 7 7 1 2 7 5 9 7 12
// /
// A single linked list of duplicate numbers is given. For a given value of an info field in the list, ensure that the number of repetitions (duplicates) of that number is even. If for the given value of the info field, the number of elements with that value is odd, an element with the same value should be added before the first appearance of the value.
// Note: 0 is an even number.
// Input: In the first line, the number of elements in the list are given, then the elements themselves, and finally, the number (value) that will ensure that it appears an even number of times.
// Output: The list with an even number of duplicates for a given value is printed on output.
// Examples:
// Input:
// 6
// 1 2 5 7 9 12
// 7
// Output:
// 1 2 5 7 7 9 12
// Input:
// 8
// 7 1 2 7 5 9 7 12
// 7
// Output:
// 7 7 1 2 7 5 9 7 12



import java.util.*;

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
            ret = "Prazna lista!!!";
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
            System.out.println("Dadenot jazol e null");
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
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
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
            System.out.println("Listata e prazna");
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
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
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
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
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
}
 class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 SLL<Integer> lista = new SLL<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int vlez = scanner.nextInt();
            lista.insertLast(vlez);
        }
        int k = scanner.nextInt();
        
        SLLNode<Integer> tmp = lista.getFirst();
        int counter=0;
        while (tmp!=null){
            if (tmp.element==k)counter++;
            tmp=tmp.succ;
        }

        tmp=lista.getFirst();
        if (counter%2!=0){
            while (tmp != null) {
                if (tmp.element==k){
                    lista.insertBefore(k,tmp);
                    break;
                }
                tmp = tmp.succ;
            }
        }
        tmp=lista.getFirst();

        System.out.println(lista);
    }
}
