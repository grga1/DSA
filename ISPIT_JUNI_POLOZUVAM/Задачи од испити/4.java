// Даден е текст кој е организиран во повеќе делови. Ваша задача е да одредите дали текстот е валиден според правилата за негова организација.

// Почетокот на секој дел е означен со \begin{section}, \begin{subsection} или \begin{subsubsection}

// Крајот на секој дел е означен со \end{section}, \end{subsection}, или \end{subsubsection}. Ознаката на почеток и крај на делот мора да се совпаѓа! (\begin{subsection} секогаш да се затвора со \end{subsection}).

// Делoвите може да бидат вгнездени, при што секој вгнезден дел мора да биде на пониско ниво од оној кој го вгнездил (не може section да вгнезди во subsection, но subsection може да биде вгнезден во section). Нивото мора да бидат последователни (не може subsection да биде директно во section и не може да има subsection кој не е вгнезден во section).

// Освен овие ознаки, може да се појави текст, кој мора да биде ограден во блок кој почнува со \begin{text} и завршува со \end{text}. Во рамките на ваков блок не може да се појави никакво ниво на section. Text дел може да се појави и надвор, и вгнезден во било кое ниво на section.

// Влез: Во првата линија е даден бројот на редови во текстот N, а во секоја од наредните N линии е даден по еден ред од текстот.
// Излез: true ако текстот е валиден, false ако не е.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Stack<String> stack = new Stack<>();
        Boolean isValid = true;
        int counter=0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            counter++;
            if (line.equals("\\begin{section}")) {
                if (!stack.isEmpty() && (stack.peek().equals("\\begin{subsection}") || stack.peek().equals("\\begin{subsubsection}")||stack.peek().equals("\\begin{text}"))) {
                    isValid = false;
                    break;
                }
                stack.push(line);
            }else if(line.equals("\\begin{subsection}")){
                if (!stack.isEmpty() && ( stack.peek().equals("\\begin{subsubsection}")||stack.peek().equals("\\begin{text}"))) {
                    isValid = false;
                    break;
                }
                stack.push(line);
            }else if (line.equals("\\begin{subsubsection}")){
                if (!stack.isEmpty() && stack.peek().equals("\\begin{text}")) {
                    isValid = false;
                    break;
                }
                stack.push(line);
            }else if (line.equals("\\begin{text}")){
                stack.push(line);
            }else if (line.equals("\\end{section}")){
                if (stack.isEmpty()||!stack.peek().equals("\\begin{section}")){
                    isValid=false;
                    break;
                }
                stack.pop();
            }else if (line.equals("\\end{subsection}")){
                if (stack.isEmpty()||!stack.peek().equals("\\begin{subsection}")){
                    isValid=false;
                    break;
                }
                stack.pop();
            }
            else if (line.equals("\\end{subsubsection}")){
                if (stack.isEmpty()||!stack.peek().equals("\\begin{subsubsection}")){
                    isValid=false;
                    break;
                }
                stack.pop();
            }else if (line.equals("\\end{text}")){
                if (stack.isEmpty()||!stack.peek().equals("\\begin{text}")){
                    isValid=false;
                    break;
                }
                stack.pop();
            }

            else {

                if (!stack.peek().equals("\\begin{text}")) {
                    isValid = false;
                    break;
                }

            }

        }

        if (!stack.isEmpty()){
            isValid=false;
        }
        System.out.println(isValid);
    }
}
