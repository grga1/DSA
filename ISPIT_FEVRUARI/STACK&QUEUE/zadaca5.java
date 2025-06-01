// Студентска служба е посетена од студентите со цел да приложат/земат документи. Студентот може да приложи документи, да побара да си го земе индексот или пак да побара да си ги земе документите од средно. Кога студентската служба ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера не одат со иста брзина па услужувањето е со следниот редослед (два студента што ги приложуваат документите, па три студенти што сакаат да си го земат индексот, па еден студент што сака да си ги земе документите од средно).

// Доколку студент чека ред за повеќе услуги кај студентската служба, тој чека ред првин во редицата за приложување на документи, потоа во редицата за земање на индекс и на крај во редицата за земање на документи од средно.


// Влез: Во првата линија е даден број на студенти кои имаат дојдено за да бидат услужени од студентската служба. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали има потреба од дадена услуга (приложување документи, земање на индекс, земање на документи од средно соодветно), каде 1 значи дека има потреба од услуга од тој тип, 0 значи дека нема потреба од услуга од тој тип.

// Пример:

// Иван Ивановски

// 1

// 1

// 0

// значи дека студентот Иван Ивановски има за цел да приложи документи и да си го земе индексот.

// Излез: Испечати го редоследот на студентите по редослед како завршуваат со сите услуги од студенстката служба.

// ///
// Student Administration is visited by students in order to submit/receive documents. The student can submit documents, request to receive his/her index card, or request to receive his/her high school documents. When the student services start working, students of all three types are served in parallel, but it is important to mention that all 3 counters go with different speeds, so the serving of students is in this order (two students submitting documents, then three students who want to receive their index card, then one student who wants to receive his/her high school documents).

// If a student is waiting in line for more than one service at the student services, he/she waits in line first for submitting documents, then in line for receiving his/her index card, and finally in line for receiving his/her high school documents.

// Input: The first line contains the number of students who have come to be served by the student service. Then 4 lines are entered for each student, where the first line is the name of the student, and the remaining 3 lines indicate whether there is a need for a given service (submitting documents, taking an index, taking documents from high school, respectively), where 1 means that there is a need for a service of that type, 0 means that there is no need for a service of that type.

// Example:

// Ivan Ivanovski

// 1

// 1

// 0

// means that student Ivan Ivanovski aims to submit documents and get his index.

// Output: Print the order of students in the order they complete all services from the student administration.

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

// Петар Петров
// Иван Ивановски
// Марија Маркова






import java.util.*;

class Student{
    String ime;
    String prezime;
    int nauka;
    int naucnaFantastika;
    int  istorija;

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
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      Queue<Student> naukaRedica = new LinkedList<>();
      Queue<Student> naucnaFantastikaRedica = new LinkedList<>();
      Queue<Student> istorijaRedica = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String ime=sc.next();
            String prezime=sc.next();
            int nauka=sc.nextInt();
            int naucnaFantastika=sc.nextInt();
            int  istorija=sc.nextInt();

            Student s = new Student(ime,prezime,nauka,naucnaFantastika,istorija);

            if(nauka==1){
                naukaRedica.add(s);
            }
            else if(naucnaFantastika==1){
                naucnaFantastikaRedica.add(s);
            }
            else if(istorija==1){
                istorijaRedica.add(s);
            }

        }

        LinkedList<Student> finished = new LinkedList<>();

        while (!naukaRedica.isEmpty()||!naucnaFantastikaRedica.isEmpty()||!istorijaRedica.isEmpty()){

            if(!naukaRedica.isEmpty()){
                Student s = naukaRedica.poll();
                if(s.naucnaFantastika==1){
                    naucnaFantastikaRedica.add(s);
                }
                else if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else  finished.add(s);
            }


            if(!naukaRedica.isEmpty()){
                Student s = naukaRedica.poll();
                if(s.naucnaFantastika==1){
                    naucnaFantastikaRedica.add(s);
                }
                else if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else  finished.add(s);
            }


            if(!naucnaFantastikaRedica.isEmpty()){
                Student s = naucnaFantastikaRedica.poll();
                if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else  finished.add(s);
            }

            if(!naucnaFantastikaRedica.isEmpty()){
                Student s = naucnaFantastikaRedica.poll();
                if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else  finished.add(s);
            }

            if(!naucnaFantastikaRedica.isEmpty()){
                Student s = naucnaFantastikaRedica.poll();
                if(s.istorija==1){
                    istorijaRedica.add(s);
                }
                else  finished.add(s);
            }

            if (!istorijaRedica.isEmpty()){
                Student s = istorijaRedica.poll();
                finished.add(s);
            }
        }

        for (Student s : finished){
            System.out.println(s.ime+" "+s.prezime);
        }
    }
}

