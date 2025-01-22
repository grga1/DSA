Студентска служба е посетена од студентите со цел да приложат/земат документи.
Студентот може да приложи документи, да побара да си го земе индексот или пак да побара да си ги земе документите од средно.
Кога студентската служба ќе започне со работа се услужуваат студенти од сите три типа паралелно, 
но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот редослед (еден студент што приложува документи,
па еден студент што сака да си го земе индексот, па еден студент што сака да си ги земе документите од средно).
Доколку студент чека ред за повеќе услуги кај студентската служба, 
тој чека ред првин во редицата за приложување на документи, 
потоа во редицата за земање на индекс и на крај во редицата за земање на документи од средно.
Влез: Во првата линија е даден број на студенти кои имаат дојдено за да бидат услужени од студентската служба.
Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент,
а во останатите 3 редици се внесува дали има потреба од дадена услуга (приложување документи, земање на индекс, земање на документи од средно соодветно), 
каде 1 значи дека има потреба од услуга од тој тип, 0 значи дека нема потреба од услуга од тој тип.
Пример:
Иван Ивановски
1
1
0
значи дека студентот Иван Ивановски има за цел да приложи документи и да си го земе индексот.
Излез: Испечати го редоследот на студентите по редослед како завршуваат со сите услуги од студенстката служба.
///
Student Administration is visited by students in order to submit/receive documents.
The student can submit documents, request to receive his/her index card, 
or request to receive his/her high school documents. 
When the student services start working, students of all three types are served in parallel,
but it is important to mention that all 3 counters go with different speeds, so the serving of students is
in this order (one student submitting documents, then one student who want to receive their index card, 
then one student who wants to receive his/her high school documents).
If a student is waiting in line for more than one service at the student services,
he/she waits in line first for submitting documents, then in line for receiving his/her index card,
and finally in line for receiving his/her high school documents.
Input: The first line contains the number of students who have come to be served by the student service.
Then 4 lines are entered for each student, where the first line is the name of the student, 
and the remaining 3 lines indicate whether there is a need for a given service
(submitting documents, taking an index, taking documents from high school, respectively),
where 1 means that there is a need for a service of that type, 0 means that there is no need for a service of that type.
Example:
Ivan Ivanovski
1
1
0
means that student Ivan Ivanovski aims to submit documents and get his index.
Output: Print the order of students in the order they complete all services from the student administration.
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
Петар Петров
Марија Маркова



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
    int dokumenti;
    int indeksi;
    int dokumentiSredno;

    public Student(String name, int dokumenti, int indeksi, int dokumentiSredno) {
        this.name = name;
        this.dokumenti = dokumenti;
        this.indeksi = indeksi;
        this.dokumentiSredno = dokumentiSredno;
    }
}
public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

        Queue<Student> redicaDokumenti = new LinkedQueue<>();
        Queue<Student> redicaIndeksi = new LinkedQueue<>();
        Queue<Student> redicaDokumentiSredno = new LinkedQueue<>();

        LinkedList<Student> finished =  new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next()+" "+scanner.next();
            int  dokumenti = scanner.nextInt();
            int indeksi = scanner.nextInt();
            int dokumentiSredno = scanner.nextInt();

            Student s  = new Student(name, dokumenti, indeksi, dokumentiSredno);
            if(dokumenti==1){
                redicaDokumenti.enqueue(s);
            }
            else if(indeksi==1){
                redicaIndeksi.enqueue(s);
            }
            else {
                redicaDokumentiSredno.enqueue(s);
            }
        }

        while(!redicaDokumenti.isEmpty()||!redicaIndeksi.isEmpty()||!redicaDokumentiSredno.isEmpty()){

            if(!redicaDokumenti.isEmpty()){
                Student s = redicaDokumenti.dequeue();
                if(s.indeksi==1){
                    redicaIndeksi.enqueue(s);
                }
                else if(s.dokumentiSredno==1){
                    redicaDokumentiSredno.enqueue(s);
                }
                else finished.add(s);
            }

            if(!redicaIndeksi.isEmpty()){
                Student s = redicaIndeksi.dequeue();
                if(s.dokumentiSredno==1){
                    redicaDokumentiSredno.enqueue(s);
                }
                else finished.add(s);
            }

            if(!redicaDokumentiSredno.isEmpty()){
                Student s = redicaDokumentiSredno.dequeue();
                finished.add(s);
            }
        }

        for (Student s : finished) {
            System.out.println(s.name);
        }
    }
}
