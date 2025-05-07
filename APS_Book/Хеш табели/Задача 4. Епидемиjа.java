import java.util.*;

class Person{
    String prezime;
    String x;

    public Person(String prezime, String x) {
        this.prezime = prezime;
        this.x = x;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    HashMap<String,Integer> vkupno = new HashMap<>();
    HashMap<String,Integer> pozitivni = new HashMap<>();
    HashMap<String,Integer> negativni = new HashMap<>();
    int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String grad = sc.next();
            String prezime = sc.next();
            String x = sc.next();
            Person p = new Person(prezime,x);
            if (vkupno.containsKey(grad)){
                vkupno.put(grad,vkupno.get(grad)+1);
                if (x.equals("positive")&&pozitivni.containsKey(grad)){
                    pozitivni.put(grad,pozitivni.get(grad)+1);
                }else if (x.equals("positive")){
                    pozitivni.put(grad,1);
                }

                if (x.equals("negative")&&negativni.containsKey(grad)){
                    negativni.put(grad,negativni.get(grad)+1);
                }else if (x.equals("negative")){
                    negativni.put(grad,1);
                }
            }else{
                vkupno.put(grad,1);
                if (x.equals("positive")){
                    pozitivni.put(grad,1);
                }else {
                    negativni.put(grad,1);
                }
            }
        }
        String grad = sc.next();
        if (vkupno.containsKey(grad)){

            float rezultat =(float)pozitivni.get(grad)/(negativni.get(grad)+pozitivni.get(grad));
            System.out.println(rezultat);
        }else{
            System.out.println("ERROR");
        }
    }
}


