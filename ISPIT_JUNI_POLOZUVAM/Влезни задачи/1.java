// Queue - Влезна задача
// Наредени луѓе со број на барања, им се извршува едно барање и се враќаат назад во редот. Печати редослед на завршување на луѓето. 
// Input
// 5
// Nenad 3
// Slave 1
// Martin 2
// Ana 1
// Igor 2
// Output
// Slave
// Ana
// Martin
// Igor
// Nenad


import java.util.*;

class Person{
    String ime;
    int brBaranja;

    public Person(String ime, int brBaranja) {
        this.ime = ime;
        this.brBaranja = brBaranja;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       Queue<Person> redica = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String ime = scanner.next();
            int baranja = scanner.nextInt();
            Person p = new Person(ime,baranja);
            redica.add(p);
        }
        LinkedList<Person> finished = new LinkedList<>();
        while (!redica.isEmpty()){
            Person p = redica.poll();
            p.brBaranja--;
            if (p.brBaranja==0){
                finished.add(p);
            }else{
                redica.add(p);
            }
        }
        for (Person p : finished){
            System.out.println(p.ime);
        }
    }


}
