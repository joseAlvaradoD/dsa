package binarySearchTree;

import utils.Node;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int item){
        root = insert(root, item);
    }

    private Node insert(Node node, int item){
        if(node == null){
            node = new Node(item);
            return node;
        }
        if(item < node.val){
            node.left = insert(node.left, item);
        }
        if(item > node.val){
            node.right = insert(node.right, item);
        }
        return node;
    }

    public void print(){
        Node dummy = root;
        this.print(dummy);
    }

    private void print(Node root){
        if(root != null){
            print(root.left);
            System.out.print(root.val + ", ");
            print(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.print();
        System.out.println();
        bst.print();
    }
}
