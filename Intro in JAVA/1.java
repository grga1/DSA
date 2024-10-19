// За дадена низа од случајни броеви кои се внесуваат од стандарден влез, да се направи преместување на сите нули на почеток на низата. На стандарден излез да се испечати трансформираната низа.

// /

// For a given array of random numbers given from standard input, perform a shift of all zeros at the beginning of the sequence. Print the transformed array to standard output.
import java.util.Scanner;

public class Main
{
    static void pushZerosToBeginning(int[] arr, int n)
    {
        int size = arr.length;
        int brojac_nuli=0;

        for(int i = 0; i < size; i++)
        {
            if(arr[i]==0){
                brojac_nuli++;
            }
        }
        int arr2[] = new int[n];
        for (int i = 0; i < brojac_nuli; i++){
            arr2[i]=0;
        }
   for(int i = 0; i < size; i++){
       if(arr[i]!=0){
           arr2[brojac_nuli++]=arr[i];
       }
   }
  for(int i = 0; i < size; i++){
          System.out.print(arr2[i]+" ");
  }
    }

    public static void main (String[] args)
    {
      Scanner obj = new Scanner(System.in);
      int n;
      int x;
      n=obj.nextInt();
      int niza[] = new int[n];


      for(int i=0;i<n;i++)
      {
          x=obj.nextInt();
          niza[i]=x;
      }
        System.out.println("Transformiranata niza e:");
      pushZerosToBeginning(niza, n);
    }
}
