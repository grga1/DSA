// Потребно е да се направи проверка на текст даден на англиски, дали е во ред напишан (односно дали правилно се напишани зборовите). За таа цел прво се даваат речник на зборови (односно листа на зборови кои ги содржи англискиот јазик), а потоа се дава текст. Како резултат треба да се испечатат сите зборови кои се направилно напишани или ги нема во речникот.

// Влез: Прво се дава број N на поими кои ќе ги содржи речникот, а во наредните N реда се дадени зборовите кои ги содржи англискиот јазик. Потоа се дава еден текст, кој треба да се провери дали е правилно напишан.

// Излез: Се печати листа на зборови кои се неправилно напишани (секој во посебен ред). Доколку сите зборови се добро напишани се печати: Bravo.

// Забелешка: Треба да се игнорираат интерпункциски знаци како точка (.), запирка (,), извичник (!) и прашалник (?). Исто така да се внимава на голема и мала буква, односно иако зборовите во речникот се со мали букви, во реченица може да појават со голема почетна буква и притоа се сметаат за точни. Работете со хеш табела со отворени кофички. Сами треба да го одредите бројот на кофички и хеш функцијата.

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> recnik = new HashMap<>();
         int n = scanner.nextInt();
         String zbor="";
        for (int i = 0; i < n; i++) {
            zbor= scanner.next().toLowerCase();
            recnik.put(zbor,1);
        }
        scanner.nextLine();
        ArrayList<String> lista = new ArrayList<>();
        String[] recenica = scanner.nextLine().toLowerCase().split(" ");

        for (int i = 0; i < recenica.length; i++) {

            if (recenica[i].charAt(recenica[i].length()-1)=='.'||recenica[i].charAt(recenica[i].length()-1)==','||recenica[i].charAt(recenica[i].length()-1)=='!'||recenica[i].charAt(recenica[i].length()-1)=='?'){
                recenica[i]=recenica[i].substring(0,recenica[i].length()-1);
            }
            if (!recenica[i].isEmpty() && recnik.get(recenica[i])==null){
                lista.add(recenica[i]);
            }
        }
        if (lista.isEmpty()){
            System.out.println("Bravo");
        }else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
        }
    }
}
