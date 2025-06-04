// Даден ви е речник на зборови на кумановски дијалект и како тие се пишуваат на македонски јазик. Потоа даден ви е текст којшто е напишан на кумановски дијалект. Потребно е да ги замените сите појавувања на зборовите на кумановскиот дијалект кои се дадени во речникот со соодветни зборови на македонски јазик.

// Забелешка: Треба да се игнорираат интерпункциските знаци точка (.) , запирка (,), извичник(!) и прашалник (?). Исто така зборовите во текстот можат да се појават и со прва голема буква и во тој случај неговиот синоним на македонски јазик исто така треба да се отпечати со прва голема буква.

// /


import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,String> recnik = new HashMap<>();
        
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String ku = scanner.next();
            String mk = scanner.next();
            recnik.put(ku,mk);
        }
        scanner.nextLine();
        String[] recenica = scanner.nextLine().split(" ");

        for (int i = 0; i < recenica.length; i++) {
           Boolean golemaBukva=false;
           Boolean znakFlag=false;
           Character znak = null;
           String tmp = recenica[i];

           if(Character.isUpperCase(tmp.charAt(0))){
                golemaBukva=true;
                tmp=tmp.toLowerCase().charAt(0)+tmp.substring(1);
            }

            if (recenica[i].charAt(recenica[i].length()-1)=='.'||recenica[i].charAt(recenica[i].length()-1)==','||recenica[i].charAt(recenica[i].length()-1)=='?'||recenica[i].charAt(recenica[i].length()-1)=='!'){
                znakFlag=true;
                znak=recenica[i].charAt(recenica[i].length()-1);
                tmp=tmp.substring(0,tmp.length()-1);
            }

             if (recnik.get(tmp)!=null){
                 tmp=recnik.get(tmp);
             }

         if (tmp!=null){
             recenica[i]=tmp;
         }
            if (golemaBukva){
                recenica[i]=Character.toUpperCase(recenica[i].charAt(0))+recenica[i].substring(1);
            }
            if (znakFlag){
                recenica[i]+=znak;
            }

        }
       String x = String.join(" ",recenica);
        System.out.println(x);

    }
}
