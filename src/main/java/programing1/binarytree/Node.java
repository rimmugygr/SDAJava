package programing1.binarytree;
//pojedynczy wezeł
public class Node {
    private int data;
    private Node left,right;
    {
        left=null;
        right=null;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        this.right = right;
        return right;
    }

    public int getData() {
        return data;
    }


}
