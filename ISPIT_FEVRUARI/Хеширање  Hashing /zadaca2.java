// На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
// Ime Prezime budzhet ip_adresa vreme grad cena
// Пример
// Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
// Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари,
// има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.
// Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.
// Од редот за тестирање треба да го извадите градот и потоа да го одговорите следното прашање со овој град:
// Од сите N лица на влез, кои купуваат билет за до истиот град
// колку од нив имале доволно буџет за да го купат билетот; и
// од овие, кој од нив платил најголем износ?
// (погледнете го тест примерот!)
// (доколку има повеќе со ист најголем износ тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
// Ова ќе треба да го направите за сите M редови за тестирање!
// Препорака, користете OBHT и/или CBHT.
// ----------------------
// At the input of this task you will be given rows with the following format:
// First_name Last_name budget ip_address time city price
// Example
// Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
// Which means that the person with First name and Last name Jovan Todorov, has a budget of 1000 denars, 
// has an IP address with network 10.73.112 and host number 200, and joined at 15:30 to buy a ticked to Bitola which costs 760 denars.
// You will be given N such rows, followed by an empty row and M more rows of the same format, which we will use for testing.
// From the test row you need to extract the city and then answer the following question with this city:
// Of the N people at the input, from the ones who buy a ticket to the same city
// how many of them had enough budget to buy the ticket; and
// of these, which one paid the highest amount?
// (if there are more with the same highest amount then which one is the first one in the input?) (there will always be at least one such)
// You will need to do this for all M rows for testing!
// Recommendation, use OBHT and/or CBHT.

import java.util.Objects;
import java.util.Scanner;

class Person{
    String ime;
    String prezime;
    int buget;
    String ipAdresa;
    String vreme;
    String grad;
    int cena;

    public Person(String ime, String prezime, int buget, String ipAdresa, String vreme, String grad, int cena) {
        this.ime = ime;
        this.prezime = prezime;
        this.buget = buget;
        this.ipAdresa = ipAdresa;
        this.vreme = vreme;
        this.grad = grad;
        this.cena = cena;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        CBHT<String,Person> mapa = new CBHT<>(2*n-1);
        CBHT<String,Integer> brojac = new CBHT<>(2*n-1);

        for (int i = 0; i < n; i++) {
            String ime= sc.next();
            String prezime=sc.next();
            int buget=sc.nextInt();
            String ipAdresa=sc.next();
            String vreme=sc.next();
            String grad=sc.next();
            int cena=sc.nextInt();

            Person p = new Person(ime,prezime,buget,ipAdresa,vreme,grad,cena);
  SLLNode<MapEntry<String,Person>> tmp = mapa.search(grad);
  if (tmp!=null){
      if(p.buget>=p.cena) {
          brojac.insert(grad, brojac.search(grad).element.value + 1);
          Person covek = tmp.element.value;
          if (p.cena>covek.cena){
              mapa.insert(grad,p);
          }
      }
  }else {
      if(p.buget>=p.cena) {
          mapa.insert(grad, p);
          brojac.insert(grad, 1);
      }  }

        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            String ime= sc.next();
            String prezime=sc.next();
            int buget=sc.nextInt();
            String ipAdresa=sc.next();
            String vreme=sc.next();
            String grad=sc.next();
            int cena=sc.nextInt();

            Person p = new Person(ime,prezime,buget,ipAdresa,vreme,grad,cena);

            int brojacValue = brojac.search(grad).element.value;
            Person mapaValue = mapa.search(grad).element.value;

            System.out.println("City: "+grad+" has the following number of customers:");
            System.out.println(brojacValue);
            System.out.println("The user who spent the most purchasing for that city is:");
            System.out.println(mapaValue.ime+" "+mapaValue.prezime+" with salary "+mapaValue.buget+" from address "+mapaValue.ipAdresa+" who spent "+mapaValue.cena);
            System.out.println();
        }
    }
}



