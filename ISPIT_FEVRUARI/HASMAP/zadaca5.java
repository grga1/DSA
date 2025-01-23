На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
Ime Prezime budzhet ip_adresa vreme grad cena
Пример
Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари,
има IP адреса со мрежа 10.73.112 и домаќин (host number) 200,
и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.
Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.
Од редот за тестирање треба да ја извадите IP адресата на мрежата и потоа да го одговорите следното прашање со оваа мрежа:
Од сите N лица на влез, кои што се поврзуваат со истата мрежа (од било кој домаќин во мрежата)
колку од нив имале доволно буџет за да го купат билетот; и
од овие, кој од нив платил најголем износ.
(погледнете го тест примерот!)
(доколку има повеќе со ист најголем износ тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
Ова ќе треба да го направите за сите M редови за тестирање!
Препорака, користете OBHT и/или CBHT.
----------------------
At the input of this task you will be given rows with the following format:
First_name Last_name budget ip_address time city price
Example
Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Which means that the person with First name and Last name Jovan Todorov, 
has a budget of 1000 denars, has an IP address with network 10.73.112 and host number 200, and joined at 15:30 to buy a ticked to Bitola which costs 760 denars.
You will be given N such rows, followed by an empty row and M more rows of the same format, which we will use for testing.
From the test line you need to extract the IP address of the network and then answer the following question with this network:
Of the N people at the input, from the ones who connect from the same network (from any host on the network)
how many of them had enough budget to buy the ticket; and
of these, which one paid the highest amount?
(if there are more with the same highest amount then which one is the first one in the input?) (there will always be at least one such)
You will need to do this for all M rows for testing!
Recommendation, use OBHT and/or CBHT.
For example:
Input	Result
5
Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760
Mitko Janev      4350    132.28.112.200    12:15   Krusevo    4000
Sara Dobreva     2700    10.73.60.29       14:35   Bitola     2500
Mence Trajanova  4000    10.73.112.112     11:25   Bitola     4200
Viktor Jovev     2200    10.73.112.79      15:15   Strumica   1800

1
Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760
IP network: 10.73.112 has the following number of users:
2
The user who spent the most from that network is:
Viktor Jovev with salary 2200 from address 10.73.112.79 who spent 1800
25
Marko Stankovic    1200       192.168.0.10     10:45  Skopje     1500  
Ana Petrovska      800        192.168.0.20     15:00  Bitola     760  
Stefan Jovanovic   1500       192.168.0.30     11:30  Ohrid      1100  
Elena Pavlova      600        192.168.0.40     14:15  Tetovo     750  
Ivan Mitrevski     1300       192.168.0.50     16:45  Veles      900  
Mila Nikolova      900        10.0.1.10        10:00  Skopje     700  
Kristina Ristevska 500        10.0.1.20        15:30  Bitola     1200  
Darko Nikolic      1500       10.0.1.30        12:00  Ohrid      1500  
Marija Filipova    850        10.0.1.40        17:45  Tetovo     600  
Aleksandar Kosta   1000       10.0.1.50        13:15  Veles      1400  
Petar Jovanovski   2000       172.16.5.10      08:45  Skopje     1000  
Ivana Velickova    800        172.16.5.20      14:45  Bitola     700  
Dejan Stojanov     900        172.16.5.30      13:30  Ohrid      1300  
Tamara Ilijevska   1500       172.16.5.40      16:00  Tetovo     1700  
Filip Atanasov     2100       172.16.5.50      09:00  Veles      2050  
Simona Milanova    600        192.168.2.10     15:00  Skopje     650  
Aleksandra Petrova 1200       192.168.2.20     14:30  Bitola     800  
Goran Kostadinov   850        192.168.2.30     11:15  Ohrid      700  
Maja Georgieva     1600       192.168.2.40     18:00  Tetovo     1200  
Nikola Nikolovski  1400       192.168.2.50     08:30  Veles      1450  
Lazar Angelov      700        10.1.2.10         09:45  Skopje     1200  
Milena Stojanovska 1300       10.1.2.20         16:30  Bitola     900  
Aleksandar Dimeski 800        10.1.2.30         11:15  Ohrid      850  
Katerina Trajkoska 1500       10.1.2.40         14:45  Tetovo     1400  
Viktor Pejkovski   950        10.1.2.50         13:00  Veles      800  
5
Marko Stankovic    1200       192.168.0.10     10:45  Skopje     1500  
Kristina Ristevska 500        10.0.1.20        15:30  Bitola     1200  
Dejan Stojanov     900        172.16.5.30      13:30  Ohrid      1300  
Maja Georgieva     1600       192.168.2.40     18:00  Tetovo     1200  
Viktor Pejkovski   950        10.1.2.50         13:00  Veles      800  
IP network: 192.168.0 has the following number of users:
3
The user who spent the most from that network is:
Stefan Jovanovic with salary 1500 from address 192.168.0.30 who spent 1100
IP network: 10.0.1 has the following number of users:
3
The user who spent the most from that network is:
Darko Nikolic with salary 1500 from address 10.0.1.30 who spent 1500
IP network: 172.16.5 has the following number of users:
3
The user who spent the most from that network is:
Filip Atanasov with salary 2100 from address 172.16.5.50 who spent 2050
IP network: 192.168.2 has the following number of users:
3
The user who spent the most from that network is:
Maja Georgieva with salary 1600 from address 192.168.2.40 who spent 1200
IP network: 10.1.2 has the following number of users:
3
The user who spent the most from that network is:
Katerina Trajkoska with salary 1500 from address 10.1.2.40 who spent 1400

  
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
            String ime = sc.next();
            String prezime = sc.next();
            int buget = sc.nextInt();
            String ipAdresa = sc.next();
            String vreme = sc.next();
            String grad = sc.next();
            int cena = sc.nextInt();

            Person covek = new Person(ime,prezime,buget,ipAdresa,vreme,grad,cena);

            String [] niza = ipAdresa.split("\\.");

            String result = String.join(".", niza[0], niza[1], niza[2]);

                   SLLNode<MapEntry<String,Person>> tmp = mapa.search(result);
            if (tmp!=null){
          if(covek.buget>=covek.cena){
              brojac.insert(result,brojac.search(result).element.value+1);
              Person p = tmp.element.value;
              if(covek.cena>p.cena){
                  mapa.insert(result,covek);
              }
          }
            }else {
                if(covek.buget>= covek.cena) {
                    mapa.insert(result, covek);
                    brojac.insert(result, 1);
                }
            }

        }
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            String ime = sc.next();
            String prezime = sc.next();
            int buget = sc.nextInt();
            String ipAdresa = sc.next();
            String vreme = sc.next();
            String grad = sc.next();
            int cena = sc.nextInt();

            Person covek = new Person(ime,prezime,buget,ipAdresa,vreme,grad,cena);

            String [] niza = ipAdresa.split("\\.");

            String result = String.join(".", niza[0], niza[1], niza[2]);

            int counter = brojac.search(result).element.value;
            Person value = mapa.search(result).element.value;

            System.out.println("IP network: "+result+" has the following number of users:");
            System.out.println(counter);
            System.out.println("The user who spent the most from that network is:");
            System.out.println(value.ime+" "+value.prezime+" with salary "+value.buget+" from address "+value.ipAdresa+" who spent "+value.cena);
            System.out.println("");

        }
    }
}
