// Дадена е двострано поврзана листа од цели броеви. 
// Дополнително, дадени се и уште еден цел број M и еден природен број k.
// Треба да се најде првото појавување на M во листата и тој број да се помести k места на лево.
// Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, 
//   па во следните следниот ред самите елементи одделени со празно место.
//   На крај, во последните два реда дадени се целиот број M и природниот број k.
// Излез: На излез треба да се испечати листата пред и после промената.
// /
// You are given a doubly-linked list of integers.
//   Additionally, there is one more integer M and a natural number k. 
//   You need to find the first occurence of M in the list and move that node k times to the left.
// Input: The first number in the input is the number of integers in the list - N,
//   then in the next line the elements are given, separated by spaces. Then, in the last two lines, the integer M and the natural number k are given.
// Output: The list before and after the transformation

// For example:
// Input	Result
// 5
// 1 2 3 4 5
// 3
// 2
// 1<->2<->3<->4<->5
// 3<->1<->2<->4<->5
// 9
// 5 3 8 6 2 4 1 9 7
// 4
// 7
// 5<->3<->8<->6<->2<->4<->1<->9<->7
// 5<->3<->8<->6<->2<->1<->9<->4<->7
// 10
// 1 2 3 4 5 6 7 8 9 10
// 11
// 7
// 1<->2<->3<->4<->5<->6<->7<->8<->9<->10
// Elementot ne postoi vo listata
// 1<->2<->3<->4<->5<->6<->7<->8<->9<->10



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
                    tmp=tmp.pred;
                    if(tmp==null)
                    {
                        tmp=dll.getLast();
                     after=true;
                    }
                }
                if(after==true){
                    dll.insertAfter(M,tmp);
                } else dll.insertBefore(M,tmp);
                
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






