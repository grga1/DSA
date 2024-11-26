// Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа првин се услужени студентите кои чекаат ред за книга од тип Наука, потоа студентите кои чекаат ред за книга од тип научна фантастика и на крај студентите кои чекаат ред за книга од тип Историја.

// Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука, потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).


// Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.

// Пример:

// Иван Ивановски

// 1

// 1

// 0

// значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука
// и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.

// Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.

// ///
// A library is visited by students in order to borrow one or more types of books. 
// A given book can belong to one of three categories: Science, Science Fiction, or History. 
// When the library opens, students waiting in line for a Science book are served first, 
//   then students waiting in line for a Science Fiction book, and finally students waiting in line for a History book.

// If a student is waiting in line for books of different types, he waits in line first for a Science book,
// then for a Science Fiction book, and finally for a History book (depending on whether he is requesting these books for borrowing).

// Input: The first line contains the number of students who have come to the library to borrow a book. 
// Then 4 lines are entered for each student, where the first line is the student's name,
//   and the remaining 3 lines indicate whether the student will borrow a book of a given type (Science, Science Fiction, and History, respectively), 
// where 1 means that he intends to borrow a book of that type, 0 means that he will not borrow a book of that type.

// Example:

// Ivan Ivanovski

// 1

// 1

// 0

// means that student Ivan Ivanovski aims to borrow a book of type Science and type Science Fiction,
// but does not aim to borrow a book of type History.

// Output: Print the order of students in the order they finish borrowing all the books.

import java.util.Scanner;
import java.util.NoSuchElementException;

interface Queue<E> {
    public boolean isEmpty();
    public int size();
    public E peek();
    public void clear();
    public void enqueue(E x);
    public E dequeue();
}

class ArrayQueue<E> implements Queue<E> {
    E[] elems;
    int length, front, rear;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public E peek() {
        if (length > 0) {
            return elems[front];
        } else {
            throw new NoSuchElementException();
        }
    }

    public void clear() {
        length = 0;
        front = rear = 0;
    }

    public void enqueue(E x) {
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else {
            throw new NoSuchElementException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();


        Queue<String> scienceQueue = new ArrayQueue<>(n);
        Queue<String> sciFiQueue = new ArrayQueue<>(n);
        Queue<String> historyQueue = new ArrayQueue<>(n);

        for (int i = 0; i < n; i++) {
            String studentName = sc.nextLine();
            int wantsScience = sc.nextInt();
            int wantsSciFi = sc.nextInt();
            int wantsHistory = sc.nextInt();
            sc.nextLine();

            if (wantsScience == 1) scienceQueue.enqueue(studentName);
            else
            if (wantsSciFi == 1) sciFiQueue.enqueue(studentName);
            else
            if (wantsHistory == 1) historyQueue.enqueue(studentName);
        }


        while (!scienceQueue.isEmpty()) {
            System.out.println(scienceQueue.dequeue());
        }
        while (!sciFiQueue.isEmpty()) {
            System.out.println(sciFiQueue.dequeue());
        }
        while (!historyQueue.isEmpty()) {
            System.out.println(historyQueue.dequeue());
        }

        sc.close();
    }
}
