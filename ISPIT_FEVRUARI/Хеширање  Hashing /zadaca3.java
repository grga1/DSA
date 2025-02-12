// Даден ви е речник на зборови на кумановски дијалект и како тие се пишуваат на македонски јазик.
// Потоа даден ви е текст којшто е напишан на кумановски дијалект. 
// Потребно е да ги замените сите појавувања на зборовите на кумановскиот дијалект кои се дадени во речникот со соодветни зборови на македонски јазик.

// Забелешка: Треба да се игнорираат интерпункциските знаци точка (.) ,
// запирка (,), извичник(!) и прашалник (?). 
// Исто така зборовите во текстот можат да се појават и со прва голема буква и
// во тој случај неговиот синоним на македонски јазик исто така треба да се отпечати со прва голема буква.

// /

// You are given a dictionary of words in Kumanovo's dialect, 
// and how they are written in formal macedonian language. 
// Then, you are given a text that is written in the dialect.
// You need to replace all occurances of the words in the dialect that are given in the dictionary,
// with the corresponding words in the formal language.

// Note: You need to ignore punctuation marks dot(.), comma(,), exclamation mark(!) and question mark(?).
// Also, the words might appear with a capital first letter in the text and in that case the synonym in 
// the formal macedonian language should also be printed capitalized.



import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
         scanner.nextLine();
        HashMap<String,String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
         String [] zborovi = scanner.nextLine().split(" ");
         String golemaKu = zborovi[0].substring(0,1).toUpperCase()+zborovi[0].substring(1);
         String golemaMk = zborovi[1].substring(0,1).toUpperCase()+zborovi[1].substring(1);
         if(map.get(golemaKu)==null){
             map.put(golemaKu,golemaMk);
         }
         if(map.get(zborovi[0])==null){
             map.put(zborovi[0],zborovi[1]);
         }
        }
String recenica = scanner.nextLine();

        for(String s : map.keySet()){
        recenica=recenica.replaceAll("\\b"+s+"\\b",map.get(s));
        }
        System.out.println(recenica);
    }
}
