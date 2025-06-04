// Даден е стринг. Треба да се најде најчестиот под-стринг кој е дел од него и да се испечати. Доколку два под-стринга се исто фреквентни, тогаш се печати подолгиот. Доколку и овој услов го исполнуваат тогаш се печати лексикографски помалиот.

// Пример: За стрингот "abc" под-стрингови се "a", "b", "c", "ab", "bc", "abc". Сите имаат иста честота па затоа се печати најдолгиот "abc".

// /

// Given a string, you need to find the most frequent sub-string that is a part of the original and print it. If two sub-strings are equally frequent, you should print the longer one. If they are with the same length as well, then you should print the one that is lexicographically smaller.

// Example: Sub-strings of the string "abc" are "a", "b", "c", "ab", "bc", "abc". They all have the same frequency, so the longest one is printed - "abc".
// For example:

// Input	Result
// bab
// b


import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        HashMap<String,Integer> mapa = new HashMap<>();
        for (int i = 0; i < input.length() ; i++) {
            for (int j = i+1; j <= input.length(); j++) {
                if (mapa.get(input.substring(i,j))==null){
                    mapa.put(input.substring(i,j),1);
                }else{
                    mapa.put(input.substring(i,j),mapa.get(input.substring(i,j))+1);
                }
            }
        }
        String word = "";
        int maxLength = -100;
        int maxCounter=-100;
         for (Map.Entry<String,Integer> entry : mapa.entrySet()){
             if (entry.getValue()>maxCounter){
                 maxCounter=entry.getValue();
                 word=entry.getKey();
             }else if (entry.getValue()>=maxCounter){
                 if (entry.getKey().length()>word.length()){
                     word=entry.getKey();
                 }
             }
         }
        System.out.println(word);
    }
}
