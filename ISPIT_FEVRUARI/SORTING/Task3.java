// Дадена е една двојно поврзана листa и со N јазли кои во себе содржат по еден природен број.
// Треба да се сортира листата со помош на сортирањето со меурчиња (bubble sort). 
// Во првиот ред од влезот е даден бројот на јазли во листата, а потоа во вториот ред се дадени јазлите од кои е составена.
// На излез треба да се испечатат јазлите на сортираната листа.
// Име на класата: BubbleSortDLL
// Забелешка: При реализација на задачата МОРА да се користи дадената структура, а не да користат помошни структури како низи и сл.
// -----------------
// Given is a doubly linked list with N nodes that each contain a natural number. The list should be sorted using bubble sort.
// In the first line of the input, the number of nodes in the list is given, and then in the second line, the nodes of which it is composed are given. 
//   The output should print the nodes of the sorted list
// Class Name: BubbleSortDLL
// Note: When performing the task, the given structure MUST be used, and not auxiliary structures such as arrays, etc.
// For example:
// Input	Result
// 8
// 6 10 13 5 8 17 2 5
// 2 5 5 6 8 10 13 17


import java.util.Arrays;
import java.util.Scanner;

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
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

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
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
            DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

    public void mirror() {

        DLLNode<E> tmp = null;
        DLLNode<E> current = first;
        last = first;
        while(current!=null) {
            tmp = current.pred;
            current.pred = current.succ;
            current.succ = tmp;
            current = current.pred;
        }

        if(tmp!=null && tmp.pred!=null) {
            first=tmp.pred;
        }
    }
}

 class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;
    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < n; i++) {
            dll.insertLast(scanner.nextInt());
        }
    
        bubbleSort(dll,n);
        
         DLLNode<Integer> dll2 = dll.getFirst();
        for (int i = 0; i < n; i++) {
            System.out.print(dll2.element+" ");
            dll2=dll2.succ;
        }
    }

    static void bubbleSort(DLL<Integer> dll, int n) {
        int i, j, temp;

        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            DLLNode<Integer>node1 = dll.getFirst();
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (node1.element>node1.succ.element) {

                    // Swap arr[j] and arr[j+1]
                    temp = node1.element;
                    node1.element = node1.succ.element;
                    node1.succ.element= temp;
                    swapped = true;
                }
                node1 = node1.succ;
            }

node1=node1.succ;
            
            if (swapped == false)
                break;
        }
    }
}


