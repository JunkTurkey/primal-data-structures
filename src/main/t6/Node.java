package main.t6;

public class Node {

    public int data;
    public boolean RightTag;
    public boolean LeftTag;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right, boolean rightTag, boolean leftTag) {
        this.data = data;
        RightTag = rightTag;
        LeftTag = leftTag;
        this.left = left;
        this.right = right;
    }
}
