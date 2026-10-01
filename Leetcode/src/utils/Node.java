package utils;

public class Node {
    public int val;
    public Node left,right;

    public Node(){
        val = 0;
        left = right = null;
    }

    public Node(int val){
        this.val = val;
        left = right = null;
    }
}
