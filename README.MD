# Tree parser

This was a simple test task for russian Clojure MOOC.

The tree is given by a one-dimensional sequence of numbers and brackets: [1 [2 3] 4 [5 [6 7]] [8]]
In Java, this sequence is specified by an array of strings:

String[] treeStr =
{"[","1","[","2","3","]","4","[","5","[","6","7","]","]","[","8","]","]"};

If you record a tree in a two-dimensional form, it will look like this:

            1,4
           / | \
        2,3  5  8
             |
            6,7

   
Class is given:

public class Node {
    public List<Node> childList;
    public List<Integer> numberList;
}

Develop an algorithm that:
1) on the specified one-dimensional sequence builds a tree from objects of class Node
(child nodes are written in the childList field, the numbers entering in the node are in numberList);
2) performs a traversal of the tree and outputs to the console the sum of numbers from the numberList field for each
node.