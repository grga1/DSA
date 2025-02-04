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
значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика,
но не има за цел да позајми книга од тип Историја.
Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.
///
A library is visited by students in order to borrow one or more types of books.
A given book can belong to one of three categories: Science, Science Fiction, or History. 
When the library opens, students of all three types are served in parallel,
but it is important to mention that all 3 counters go with different speeds, 
so the serving of students is in this order (two students that borrow a book of type Science, then one student who wants to borrow a book of type Science Fiction, 
then two students who want to borrow a book of type History).
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


  import java.util.Scanner;
import java.util.*;


class Studenti{
 String imePrezime;
 int nauka;
 int nacunaFant;
 int istorija;

    public Studenti(String imePrezime, int nauka, int nacunaFant, int istorija) {
        this.imePrezime = imePrezime;
        this.nauka = nauka;
        this.nacunaFant = nacunaFant;
        this.istorija = istorija;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();

         Queue<Studenti> naukaRedica = new LinkedList<>();
         Queue<Studenti> naucnaFantastikaRedica = new LinkedList<>();
         Queue<Studenti> istorijaRedica = new LinkedList<>();

        for (int i = 0; i < n; i++) {
             String imePrezime = sc.next()+" "+sc.next();
           int nauka = sc.nextInt();
           int naucnaFantastika = sc.nextInt();
           int istorija = sc.nextInt();
           Studenti s = new Studenti(imePrezime,nauka,naucnaFantastika,istorija);
           if(nauka==1){
               naukaRedica.add(s);
           }
           else if(naucnaFantastika==1){
               naucnaFantastikaRedica.add(s);
           }
           else istorijaRedica.add(s);
        }

        LinkedList<Studenti> finished =  new LinkedList<>();


        while (!naukaRedica.isEmpty()||!naucnaFantastikaRedica.isEmpty()||!istorijaRedica.isEmpty()){

            if(!naukaRedica.isEmpty()){
                Studenti s = naukaRedica.poll();
                if(s.nacunaFant==1){
                    naucnaFantastikaRedica.add(s);
                }
                else if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else finished.add(s);
            }

            if(!naukaRedica.isEmpty()){
                Studenti s = naukaRedica.poll();
                if(s.nacunaFant==1){
                    naucnaFantastikaRedica.add(s);
                }
                else if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else finished.add(s);
            }

            if(!naucnaFantastikaRedica.isEmpty()){
                Studenti s = naucnaFantastikaRedica.poll();
                if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else finished.add(s);
            }

            if(!istorijaRedica.isEmpty()){
                Studenti s = istorijaRedica.poll();
                finished.add(s);
            }

            if(!istorijaRedica.isEmpty()){
                Studenti s = istorijaRedica.poll();
                finished.add(s);
            }


        }

        for (Studenti s : finished){
            System.out.println(s.imePrezime);
        }
    }
}
