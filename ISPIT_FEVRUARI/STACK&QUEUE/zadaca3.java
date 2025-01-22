Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги.
Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја.
Кога библиотеката ќе започне со работа се услужуваат студенти од сите три типа паралелно, 
но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот редослед (два студента што ги бараат книга од тип Наука,
па еден студент што бара книга од тип Научна фантастика, па два студенат што бараат книга од тип Историја).
Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука,
потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).
Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга.
Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, 
а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно),
каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.
Пример:
Иван Ивановски
1
1
0
значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.
Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.
///
A library is visited by students in order to borrow one or more types of books.
A given book can belong to one of three categories: Science, Science Fiction, or History. 
When the library opens, students of all three types are served in parallel, 
but it is important to mention that all 3 counters go with different speeds, 
so the serving of students is in this order (two students that borrow a book of type Science,
then one student who wants to borrow a book of type Science Fiction, then two students who want to borrow a book of type History).
If a student is waiting in line for books of different types, 
he waits in line first for a Science book, then for a Science Fiction book, 
and finally for a History book (depending on whether he is requesting these books for borrowing).
Input: The first line contains the number of students who have come to the library to borrow a book.
Then 4 lines are entered for each student, where the first line is the student's name,
and the remaining 3 lines indicate whether the student will borrow a book of a given type (Science, Science Fiction, and History, respectively),
where 1 means that he intends to borrow a book of that type, 0 means that he will not borrow a book of that type.
Example:
Ivan Ivanovski
1
1
0
means that student Ivan Ivanovski aims to borrow a book of type Science and type Science Fiction, but does not aim to borrow a book of type History.
Output: Print the order of students in the order they finish borrowing all the books.
For example:
Input	Result
2
Иван Ивановски
1
1
0
Марија Маркова
1
0
1
Иван Ивановски
Марија Маркова
3
Иван Ивановски
1
0
1
Марија Маркова
0
1
1
Петар Петров
1
1
0
Иван Ивановски
Марија Маркова
Петар Петров


import java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;

class SLLNode<E> {
	protected E element;
	protected SLLNode<E> succ;

	public SLLNode(E elem, SLLNode<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
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


interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}
 class LinkedQueue<E> implements Queue<E> {

	// Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
       	// Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
    	// Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
       	// Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
    	// Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
    	// Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
    	// Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}


class Student{
    String name;
    int nauka;
    int naucnaFantastika;
    int istorija;

    public Student(String name, int nauka, int naucnaFantastika, int istorija) {
        this.name = name;
        this.nauka = nauka;
        this.naucnaFantastika = naucnaFantastika;
        this.istorija = istorija;
    }
}
public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      Queue<Student> redicaNauka = new LinkedQueue<>();
      Queue<Student> redicaNaucnaFantastika = new LinkedQueue<>();
      Queue<Student> redicaIstorija = new LinkedQueue<>();
      LinkedList<Student> finished = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next()+" "+scanner.next();
            int nauka = scanner.nextInt();
         int  naucnaFantastika = scanner.nextInt();
         int istorija = scanner.nextInt();

         Student s = new Student(name, nauka, naucnaFantastika, istorija);
         if(nauka==1){
             redicaNauka.enqueue(s);
         }else if(naucnaFantastika==1){
             redicaNaucnaFantastika.enqueue(s);
         }
         else {
             redicaIstorija.enqueue(s);
         }
        }

        while(!redicaNauka.isEmpty()||!redicaNaucnaFantastika.isEmpty()||!redicaIstorija.isEmpty()){
            if(!redicaNauka.isEmpty()){
                Student s = redicaNauka.dequeue();
                if(s.naucnaFantastika==1){
                    redicaNaucnaFantastika.enqueue(s);
                }else if(s.istorija==1){
                    redicaIstorija.enqueue(s);
                }
                else {
                    finished.add(s);
                }
            }

            if(!redicaNauka.isEmpty()){
                Student s = redicaNauka.dequeue();
                if(s.naucnaFantastika==1){
                    redicaNaucnaFantastika.enqueue(s);
                }else if(s.istorija==1){
                    redicaIstorija.enqueue(s);
                }
                else {
                    finished.add(s);
                }
            }

            if(!redicaNaucnaFantastika.isEmpty()){
                Student s = redicaNaucnaFantastika.dequeue();
                if(s.istorija==1){
                    redicaIstorija.enqueue(s);
                }else
                    finished.add(s);
            }

            if(!redicaIstorija.isEmpty()){
                Student s = redicaIstorija.dequeue();
                finished.add(s);
            }

            if(!redicaIstorija.isEmpty()){
                Student s = redicaIstorija.dequeue();
                finished.add(s);
            }

        }

        for(Student s : finished){
            System.out.println(s.name);
        }
    }
}

         
    
