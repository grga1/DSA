// На влез во оваа задача ќе ви бидат дадени редови како следниот формат:
// Ime Prezime budzhet ip_adresa vreme grad cena
// Пример
// Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
// Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари.

// Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови од истиот формат, кои ќе ги користиме за тестирање.

// Од редот за тестирање треба да ја извадите IP адресата на мрежата и потоа да го одговорите следното прашање со оваа мрежа:

// Од сите N лица на влез, кои што се поврзуваат со истата мрежа (од било кој домаќин во мрежата)
// колку од нив се вклучиле подоцна од 11:59; и
// од овие, кој од нив се вклучил најрано? 

// (погледнете го тест примерот!)

// (доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)


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

            String[] niza = ip_adresa.split("\\.");
            String ip = "";
            for (int j = 0; j<3; j++) {
                ip+=niza[j];
                if (j<2)
                    ip+=".";
            }

            if (vreme.compareTo("11:59")>0){
                if (mapa.get(ip)!=null&&brojac.get(ip)!=null){
                    brojac.put(ip,brojac.get(ip)+1);
                    if (vreme.compareTo(mapa.get(ip).Vreme)<0){
                        mapa.put(ip,p);
                    }
                }else {
                    mapa.put(ip,p);
                    brojac.put(ip,1);
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

            String[] niza = ip_adresa.split("\\.");
            String ip = "";
            for (int j = 0; j<3; j++) {
                ip+=niza[j];
                if (j<2)
                    ip+=".";
            }
            System.out.println("IP network: "+ip+" has the following number of users: ");
            System.out.println(brojac.get(ip));
            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.println(mapa.get(ip).Ime+" "+mapa.get(ip).Prezime+" with salary "+mapa.get(ip).Budget+" from address "+mapa.get(ip).Ip_adresa+" who logged in at "+mapa.get(ip).Vreme);
            System.out.println();
        }
    }
}
