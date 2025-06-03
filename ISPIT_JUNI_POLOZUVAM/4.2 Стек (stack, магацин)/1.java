// Задача 1. Загради
// Да се провери коректноста на заградите во еден израз. Еден израз има коректни
// загради ако:
// - За секоjа лева заграда, подоцна следува соодветна десна заграда - За секоjа
// десна заграда претходно постои лева заграда
// - Секоj под-израз ме´гу пар од две загради содржи коректен броj на загради.
// Примери на изрази со коректни и некоректни загради: s x (s – a) x (s – b) x
// (s - c) коректни
// (– b + sqrt[b2 – 4ac]) / 2a коректни
// s x (s – a) x (s – b x (s – c) некоректни
// s x (s – a) x s – b) x (s – c) некоректни



import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vlez = scanner.nextLine();
        String[] niza = vlez.split("");
        Stack<String> stack = new Stack<>();
        Boolean isValid = true;
        for (int i = 0; i < niza.length; i++) {
            if (niza[i].equals("(")){
                stack.add("(");
            }else if (niza[i].equals("[")){
                stack.add("[");
            }else if (niza[i].equals("{")){
                stack.add("{");
            }else if (niza[i].equals(")")){
                if (!stack.isEmpty()&&stack.peek().equals("(")){
                    stack.pop();
                }else if (stack.isEmpty()||!stack.peek().equals("(")){
                    isValid=false;
                    break;
                }
            }else if (niza[i].equals("]")){
                if (!stack.isEmpty()&&stack.peek().equals("[")){
                    stack.pop();
                }else if (stack.isEmpty()||!stack.peek().equals("[")){
                    isValid=false;
                    break;
                }
            }else if (niza[i].equals("}")){
                if (!stack.isEmpty()&&stack.peek().equals("{")){
                    stack.pop();
                }else if (stack.isEmpty()||!stack.peek().equals("{")){
                    isValid=false;
                    break;
                }
            }



        }
        if (!stack.isEmpty()) isValid=false;

        if (isValid==true){
            System.out.println(vlez+" ima korektni zagradi");
        }else {
            System.out.println(vlez+" nema korektni zagradi");
        }
    }
}
