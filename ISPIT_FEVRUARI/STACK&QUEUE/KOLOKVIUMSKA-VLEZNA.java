// Queue - Влезна задача
// Наредени луѓе со број на барања, им се извршува едно барање и се враќаат назад во редот. 
// Печати редослед на завршување на луѓето. 
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

import java.util.LinkedList;
import java.util.Scanner;

class covek{
    String name;
    int x;

    public covek(String name, int x) {
        this.name = name;
        this.x = x;
    }
}

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

        Queue<covek> redica = new LinkedQueue<>();
        LinkedList<covek> finished = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int broj = scanner.nextInt();
            covek c = new covek(name,broj);
            redica.enqueue(c);
        }

        while (!redica.isEmpty()){
            covek c = redica.dequeue();
            if(c.x==3){
                c.x--;
                redica.enqueue(c);
            }else if(c.x==2){
                c.x--;
                redica.enqueue(c);
            }
            else finished.add(c);
        }
        for (covek c:finished){
            System.out.println(c.name);
        }
    }
}
            
