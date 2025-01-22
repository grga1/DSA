Даден е код на модифициран програмски јазик каде функциите се претставени со отворен и затворен таг ("imeFunkcija" и "endimeFunkcija"). 
Ваша задача е да дефинирате дали даден програмски код е валиден.
Пример валиден код:
func1
func2
endfunc2
func3
endfunc3
endfunc1
Пример невалиден код (испуштен е затворен таг за func3):
func1
func2
endfunc2
func3
endfunc1
Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред. Се внесуваат тагови се додека не се внесе "x".
Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.
/
We are given code in a modified programming language is given, 
where functions are represented by an opening and closing tag ("functionName" and "endfunctionName").
Your task is to determine whether the given code is valid.
Example of valid code:
func1
func2
endfunc2
func3
endfunc3
endfunc1
Example of invalid code (missing closing tag for func3):
func1
func2
endfunc2
func3
endfunc1
Input: Code in a modified programming language, where each tag is written in a new line. Tags are entered until "x" is entered.
Output: "Valid" if the code is valid, "Invalid" if the code is not valid.
For example:
Input	Result
func1
func2
endfunc2
func3
endfunc3
endfunc1
x
Valid
func1
func2
endfunc2
func3
endfunc1
x
Invalid

  import java.util.Scanner;
import java.util.NoSuchElementException;

 class SLLNode<E> {
	protected E element;
	protected SLLNode<E> succ;

	public SLLNode(E elem, SLLNode<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}


interface Stack<E> {
    // Elementi na stekot se objekti od proizvolen tip.
    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:
    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}


class LinkedStack<E> implements Stack<E> {
    // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
    private SLLNode<E> top;
    int size;

    public LinkedStack() {
        // Konstrukcija na nov, prazen stek.
        top = null;
        size = 0;
    }

    public String toString() {
        SLLNode<E> current = top;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.element);
            s.append(" ");
            current = current.succ;
        }
        return s.toString();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (top == null);
    }

    public void clear() {
        // Go prazni stekot.
        top = null;
        size = 0;
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        top = new SLLNode<E>(x, top);
        size++;
    }

    public int size() {
        // Ja vrakja dolzinata na stekot.
        return size;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        size--;
        top = top.succ;
        return topElem;
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stek = new LinkedStack<>();
      while(true){
          String input = scanner.next();
          if(input.equals("x")){
              break;
          }
          if(!stek.isEmpty()&&stek.peek().equals(input.substring(3))){
              stek.pop();
          }else
          stek.push(input);

      }
      if(stek.isEmpty()){
          System.out.println("Valid");
          return;
      }else System.out.println("Invalid");

    }
}
