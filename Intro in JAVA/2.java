// За даден збор кој се внесува од стандарден влез, да се испечати истиот превртен. На влез во првиот ред се дава број на зборови кои ќе се внесуваат. Во наредните линии се внесуваат самите зборови.

// /

// For a given word entered from standard input, print it reversed. On input in the first line, the number of words that will be entered is given. In the following lines, the words are entered.
import java.util.Scanner;

public class Main
{
    public static void printReversed(String word) {
  for (int i = word.length()-1;i>=0;i--){
      System.out.print(word.charAt(i));
  }
    }

    public static void main (String[] args)
    {
        Scanner obj = new Scanner(System.in);
        int lenght;
        lenght=obj.nextInt();
      String word;
      String [] niza = new String[lenght];
      for(int i=0;i<lenght;i++){
          word=obj.next();
          niza[i]=word;
      }
      for(int i=0;i<lenght;i++){
          printReversed(niza[i]);
          System.out.println("");
      }
    }
}
