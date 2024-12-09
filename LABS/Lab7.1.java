// Во следната задача треба да изградите неподредено (општо) дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку лисја има поддрвото на избран јазол“.

// Секој јазол ќе има уникатен индекс од 1 до N. Коренот на дрвото секогаш ќе има индекс 1. Сите деца ќе имаат индекси поголеми од индексите на родителите.

// Влезот ќе содржи N+Q редови од видот 

// root 1 - Треба да го поставите коренот на дрвото да биде јазелот со индекс 1

// add parent_index child_index - Треба да додадете дете јазел со индекс child_index на јазелот со индекс parent_index

// ask node_index - Треба да одговорите колку листови има во поддрвото на јазелот со индекс node_index

// Пример и структура на влезот:

// Влез

// Објаснување

// Излез

// 11 5
// root 1
// add 1 2
// add 2 3
// ask 1
// add 1 4
// add 2 5
// add 3 6
// ask 2
// add 3 7
// ask 1
// add 1 8
// add 4 9
// add 2 10
// add 4 11
// ask 2
// ask 1

// Прикажано е изгледот на дрвото при секое од 5те прашања во влезот

// прашање 1



// прашање 1: ask 1: Во поддрвото на јазелот 1 има 1 лист.
// прашање 2: ask 2: Во поддрвото на јазелот 2 има 2 листови.
// прашање 3: ask 1: Во поддрвото на јазелот 1 има 4 листови.
// прашање 4: ask 2: Во поддрвото на јазелот 2 има 4 листови
// прашање 5: ask 1: Во поддрвото на јазелот 1 има 7 листови
// 1
// 2
// 4
// 4
// 7



// ------


// In the following task you need to build an unordered (general) tree with N nodes, for which you will need to answer Q questions of the type "how many leaves does the subtree of a selected node have".

// Each node will have a unique index from 1 to N. The root of the tree will always have an index 1. All children will have indices greater than the parent indices.

// The input will contain N+Q rows of the type

// root 1 - You need to set the root of the tree to be the node with index 1

// add parent_index child_index - You need to add a child node with index child_index to the node with index parent_index

// ask node_index - You need to answer how many leaves are in the subtree of the node with index node_index

// Example and structure of the input:

// Input

// Explanation

// Output

// 11 5
// root 1
// add 1 2
// add 2 3
// ask 1
// add 1 4
// add 2 5
// add 3 6
// ask 2
// add 3 7
// ask 1
// add 1 8
// add 4 9
// add 2 10
// add 4 11
// ask 2
// ask 1

// The tree view is shown for each of the 5 questions in the input

// question 1


// question 1: ask 1: In the subtree of node 1 there is 1 leaf.
// question 2: ask 2: In the subtree of node 2 there are 2 leaves.
// question 3: ask 1: In the subtree of node 1 there are 4 leaves.
// Question 4: ask 2: In the subtree of node 2 there are 4 leaves
// Question 5: ask 1: In the subtree of node 1 there are 7 sheets
// 1
// 2
// 4
// 4
// 7

import java.util.Scanner;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String[] inputLines = inputScanner.nextLine().split(" ");
        int totalOperations = Integer.parseInt(inputLines[0]) + Integer.parseInt(inputLines[1]);
        SLLTree<Integer> treeStructure = new SLLTree<>();
        Map<Integer, Tree.Node<Integer>> nodeMap = new HashMap<>();

        for (int operationIndex = 0; operationIndex < totalOperations; operationIndex++) {
            String[] command = inputScanner.nextLine().split(" ");

            if (Objects.equals(command[0], "root")) {
                treeStructure.makeRoot(Integer.parseInt(command[1]));
                Tree.Node<Integer> rootNode = treeStructure.root();
                nodeMap.put(Integer.parseInt(command[1]), rootNode);
            } else if (Objects.equals(command[0], "add")) {
                Tree.Node<Integer> parentNode = nodeMap.get(Integer.parseInt(command[1]));
                Tree.Node<Integer> newChildNode = treeStructure.addChild(parentNode, Integer.parseInt(command[2]));
                nodeMap.put(Integer.parseInt(command[2]), newChildNode);
            } else {
                Tree.Node<Integer> subtreeNode = nodeMap.get(Integer.parseInt(command[1]));
                int leafNodeCount = calculateLeafNodes(treeStructure, subtreeNode);
                System.out.println(leafNodeCount);
            }
        }
    }

    public static <E> int calculateLeafNodes(SLLTree<E> tree, Tree.Node<E> currentNode) {
        int leafCount = 0;
        if (tree.childCount(currentNode) == 0) {
            return 1;
        }
        for (Tree.Node<E> childNode : tree.childrenNodes(currentNode)) {
            leafCount += calculateLeafNodes(tree, childNode);
        }
        return leafCount;
    }
}
