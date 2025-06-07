// Даден е текст кој е организиран во повеќе делови. Ваша задача е да одредите дали текстот е валиден според правилата за негова организација.

// Валиден текст е оној во кој секој дел се означува со #HeadingN (каде што N е број од 1 до 6) (можни ознаки за почеток се #Heading1, #Heading2, #Heading3, #Heading4, #Heading5 и #Heading6).

// Делот мора да заврши со означување со HeadingN (може само со означка без #).

// Означките за почеток и крај на делот мора да имаат ист број (пример #Heading1 започнува дел и тој дел завршува со Heading1#).

// Дел може да содржи други делови со ознаки HeadingN, но секој внатрешен Heading мора да има број поголем од оној во кој е вгнезден (не може #Heading1 да е вгнезден во #Heading3, но може #Heading3 да е вгнезден во #Heading1).

// Броевите на Heading-ите не мора да бидат последователни.

// Телото на секој дел се означува со #Body на почеток и Body# на крај. Во рамките на ознаките #Body и Body# не може да биде вгнезден никаков Heading. Body дел може да се појави на ниво, но не и надвор, во текстот кој не е во Heading.

// Влез: Во првиот ред е даден бројот на редови во текстот N, а во секој од наредните N линии е даден по еден ред од текстот.

// Излез: Доколку текстот е валиден, испечатете true, во спротивно false.

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       Stack<String> stack = new Stack<>();
       int n = scanner.nextInt();
       scanner.nextLine();
       Boolean isValid = true;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.startsWith("#Heading")) {
                int brojce = Integer.parseInt(Character.toString(line.charAt(8)));
                if (!stack.isEmpty() && (Integer.parseInt(Character.toString(stack.peek().charAt(8))) >= brojce || stack.peek().equals("#Body"))) {
                    isValid = false;
                    System.out.println("1-");
                    break;
                }
                stack.push(line);
            } else if (line.equals("#Body")) {
                stack.push(line);
            } else if (line.equals("Body#")) {
                if (stack.isEmpty() || !stack.peek().equals("#Body")) {
                    isValid = false;
                    System.out.println("2-");
                    break;
                }
                stack.pop();
            } else if (line.startsWith("Heading")) {
                if (stack.isEmpty()||!stack.peek().startsWith("#Heading")){
                    isValid=false;
                    System.out.println(stack.peek());
                    System.out.println("PRUBLEM1");
                    break;
                }
                int brojce = Integer.parseInt(Character.toString(line.charAt(7)));
                if (stack.isEmpty()||(!stack.peek().equals("#Heading")&&brojce!=Integer.parseInt(Character.toString(stack.peek().charAt(8))))){
                    isValid=false;
                    System.out.println(stack.peek());
                    System.out.println("PRUBLEM2");
                    break;
                }
                stack.pop();
            }
        }
        System.out.println(stack.size());
        if (!stack.isEmpty()) isValid=false;
        System.out.println(isValid);
    }
}
