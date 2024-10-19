import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int[] niza = new int[n];
        int x;
        int s=0;
        for (int i = 0; i < n; i++) {
            x=sc.nextInt();
            niza[i]=x;
            s+=x;
        }
        double average=(double)s/n;
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            System.out.print(niza[i]);
            if(i!=n-1){
                System.out.print(",");
            }
        }
        System.out.println("}");

        int brojac=0;
        for (int i = 0; i <n ; i++) {
            if(niza[i]>=average){
 brojac++;
            }
        }
        int j=0;
        int[] newniza = new int[brojac];
        for (int i = 0; i < n; i++) {
           if(niza[i]>=average){
               newniza[j++]=niza[i];
           }

        }
        System.out.print("{");
        for (int i = 0; i < brojac; i++) {
            System.out.print(newniza[i]);
            if(i!=brojac-1){
                System.out.print(",");
            }
        }
        System.out.print("}");

    }
        }
