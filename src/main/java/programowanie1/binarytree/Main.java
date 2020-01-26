package programowanie1.binarytree;

public class Main {








    public static void main(String[] args) {
        Tree tree = new Tree(new Node(1));

        tree.getRoot().setLeft(new Node(2));
        tree.getRoot().setRight(new Node(3));

        tree.getRoot().getLeft().setLeft(new Node(4));
        tree.getRoot().getLeft().setRight(new Node(5));
        tree.getRoot().getRight().setLeft(new Node(6));
        tree.getRoot().getRight().setRight(new Node(7));

        tree.getRoot().getRight().getRight().setRight(new Node(8));
//        tree.getRoot().getRight().getRight().getRight().setRight(new Node(9));


        tree.viewHorizontal();
        tree.viewVertical(tree.getRoot(),0);



       // print2D(tree.getRoot());


    }



}
