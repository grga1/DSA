// Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот редослед (два студента што ги бараат книга од тип Наука, па еден студент што бара книга од тип Научна фантастика, па два студенат што бараат книга од тип Историја).

// Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука, потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).


// Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.

// Пример:

// Иван Ивановски

// 1

// 1

// 0

// значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.

// Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.

// ///
// A library is visited by students in order to borrow one or more types of books. A given book can belong to one of three categories: Science, Science Fiction, or History. When the library opens, students of all three types are served in parallel, but it is important to mention that all 3 counters go with different speeds, so the serving of students is in this order (two students that borrow a book of type Science, then one student who wants to borrow a book of type Science Fiction, then two students who want to borrow a book of type History).

// If a student is waiting in line for books of different types, he waits in line first for a Science book, then for a Science Fiction book, and finally for a History book (depending on whether he is requesting these books for borrowing).

// Input: The first line contains the number of students who have come to the library to borrow a book. Then 4 lines are entered for each student, where the first line is the student's name, and the remaining 3 lines indicate whether the student will borrow a book of a given type (Science, Science Fiction, and History, respectively), where 1 means that he intends to borrow a book of that type, 0 means that he will not borrow a book of that type.

// Example:

// Ivan Ivanovski

// 1

// 1

// 0

// means that student Ivan Ivanovski aims to borrow a book of type Science and type Science Fiction, but does not aim to borrow a book of type History.

// Output: Print the order of students in the order they finish borrowing all the books.

// For example:

// Input	Result
// 2
// Иван Ивановски
// 1
// 1
// 0
// Марија Маркова
// 1
// 0
// 1
// Иван Ивановски
// Марија Маркова
// 3
// Иван Ивановски
// 1
// 0
// 1
// Марија Маркова
// 0
// 1
// 1
// Петар Петров
// 1
// 1
// 0

// Иван Ивановски
// Марија Маркова
// Петар Петров


import java.util.*;

class Student{
    String ime;
    String prezime;
    int nauka;
    int naucnaFantastika;
    int istorija;

    public Student(String ime, String prezime, int nauka, int naucnaFantastika, int istorija) {
        this.ime = ime;
        this.prezime = prezime;
        this.nauka = nauka;
        this.naucnaFantastika = naucnaFantastika;
        this.istorija = istorija;
    }
}
public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
       Queue<Student> Nauka = new LinkedList<>();
       Queue<Student> NaucnaFantastika = new LinkedList<>();
       Queue<Student> Istorija = new LinkedList<>();
       int n = scanner.nextInt();
       for (int i = 0; i <n; i++) {
           String ime = scanner.next();
           String prezime = scanner.next();
           int nauka = scanner.nextInt();
           int naucnaFantastika =scanner.nextInt();
           int istorija=scanner.nextInt();
           Student s = new Student(ime,prezime,nauka,naucnaFantastika,istorija);
           if (nauka==1){
               Nauka.add(s);
           }else if (naucnaFantastika==1){
                NaucnaFantastika.add(s);
           }else if(istorija==1){
               Istorija.add(s);
           }
        }
       LinkedList<Student> finished = new LinkedList<>();


       while (!Nauka.isEmpty()||!NaucnaFantastika.isEmpty()||!Istorija.isEmpty()) {

           if(!Nauka.isEmpty()) {
               Student s = Nauka.poll();
               if (s.naucnaFantastika == 1) {
                   NaucnaFantastika.add(s);
               } else if (s.istorija == 1) {
                   Istorija.add(s);
               } else {
                   finished.add(s);
               }
           }
           if(!Nauka.isEmpty()) {
               Student s = Nauka.poll();
               if (s.naucnaFantastika == 1) {
                   NaucnaFantastika.add(s);
               } else if (s.istorija == 1) {
                   Istorija.add(s);
               } else {
                   finished.add(s);
               }
           }
           if(!NaucnaFantastika.isEmpty()) {
               Student s = NaucnaFantastika.poll();
               if (s.istorija == 1) {
                   Istorija.add(s);
               } else {
                   finished.add(s);
               }
           }
           if(!Istorija.isEmpty()) {
               Student s = Istorija.poll();
               finished.add(s);
           }
           if(!Istorija.isEmpty()) {
               Student s = Istorija.poll();
               finished.add(s);
           }
       }
        for(Student student : finished){
            System.out.println(student.ime+" "+student.prezime);
        }

    }
}
