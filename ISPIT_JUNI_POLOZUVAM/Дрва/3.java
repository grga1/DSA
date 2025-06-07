// Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку јазли со точно две деца има во поддрвото на избран јазол“.

// Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво. 

// Влезот ќе содржи N+Q редови од видот

// root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime

// add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name

// ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name

// Пример и структура на влезот:

// Влез

// Објаснување

// Излез

// 11 9
// root bravo
// add bravo echo LEFT
// add echo beard LEFT
// ask beard
// ask bravo
// add bravo foxtrot RIGHT
// add beard hotel LEFT
// add beard india RIGHT
// ask echo
// add foxtrot golf LEFT
// add golf juliet RIGHT
// add india sierra RIGHT
// ask foxtrot
// ask bravo
// ask beard
// add echo mike RIGHT
// add foxtrot tango RIGHT
// ask echo
// ask bravo
// ask foxtrot	
// Прикажано е изгледот на дрвото при секоја од 4те групи прашања во влезот
// 0
// 0
// 1
// 0
// 2
// 1
// 2
// 4
// 1

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BTree<String> drvo = new BTree<>();
        HashMap<String,BNode<String>> mapa = new HashMap<>();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <n+q; i++) {
        String[] komandi = scanner.nextLine().split(" ");
        switch (komandi[0]){
            case "root":
                String zbor = komandi[1];
                drvo.makeRoot(zbor);
                mapa.put(zbor,drvo.root);
                break;
            case "add":
                String naKoj = komandi[1];
                String sto = komandi[2];
                String kade = komandi[3];
                if (kade.equals("RIGHT")){
                    BNode<String> curr = drvo.addChild(mapa.get(naKoj),1,sto);
                    mapa.put(sto,curr);
                }else if(kade.equals("LEFT")){
                    BNode<String> curr = drvo.addChild(mapa.get(naKoj),2,sto);
                    mapa.put(sto,curr);
                }
                 break;
            case "ask":
                int broj = kolkuVnatresniJazliIma(mapa.get(komandi[1]));
                System.out.println(broj);
                break;
        }
        }
    }
public static int kolkuVnatresniJazliIma(BNode<String>curr){
        if (curr==null)
            return 0;
        if (curr.left!=null&&curr.right!=null) return 1+kolkuVnatresniJazliIma(curr.left)+kolkuVnatresniJazliIma(curr.right);
 return kolkuVnatresniJazliIma(curr.left)+kolkuVnatresniJazliIma(curr.right);
    }

}
