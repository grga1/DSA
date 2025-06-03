// На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
// Ime Prezime budzhet ip_adresa vreme grad cena
// Пример
// Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
// Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.

// Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.

// Од редот за тестирање треба да го извадите градот и потоа да го одговорите следното прашање со овој град:

// Од сите N лица на влез, кои купуваат билет за до истиот град
// колку од нив имале доволно буџет за да го купат билетот; и
// од овие, кој од нив платил најголем износ?

// (погледнете го тест примерот!)

// (доколку има повеќе со ист најголем износ тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)


// Ова ќе треба да го направите за сите M редови за тестирање!

// Препорака, користете OBHT и/или CBHT.


import java.util.*;

class Person{
    String Ime;
    String Prezime;
    int Budget;
    String Ip_adresa;
    String Vreme;
    String Grad;
    int Cena;

    public Person(String ime, String prezime, int budget,  String ip_adresa,String vreme, String grad, int cena) {
        Ime = ime;
        Prezime = prezime;
        Budget = budget;
        Vreme = vreme;
        Ip_adresa = ip_adresa;
        Grad = grad;
        Cena = cena;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       HashMap<String,Integer> brojac = new HashMap<>();
       HashMap<String,Person> mapa = new HashMap<>();
       int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String ime = scanner.next();
            String prezime = scanner.next();
            int budget = scanner.nextInt();
            String ip_adresa = scanner.next();
            String vreme = scanner.next();
            String grad = scanner.next();
            int cena = scanner.nextInt();
            Person p = new Person(ime,prezime,budget,ip_adresa,vreme,grad,cena);
              if (budget>=cena){
                  if (brojac.get(grad)!=null) {
                      brojac.put(grad, brojac.get(grad) + 1);
                  }else{
                      brojac.put(grad,1);
                  }
                  if (mapa.get(grad)!=null) {
                      if (mapa.get(grad).Cena < cena) {
                          mapa.put(grad, p);
                      }
                  }else {
                      mapa.put(grad,p);
                  }
              }
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            String ime = scanner.next();
            String prezime = scanner.next();
            int budget = scanner.nextInt();
            String ip_adresa = scanner.next();
            String vreme = scanner.next();
            String grad = scanner.next();
            int cena = scanner.nextInt();
            System.out.println("City: "+grad+" has the following number of customers:");
            System.out.println(brojac.get(grad));
            System.out.println("The user who spent the most purchasing for that city is:");
            System.out.println(mapa.get(grad).Ime+" "+mapa.get(grad).Prezime+" with salary "+mapa.get(grad).Budget+" from address "+mapa.get(grad).Ip_adresa+" who spent "+mapa.get(grad).Cena);
            System.out.println();
        }
    }
}
