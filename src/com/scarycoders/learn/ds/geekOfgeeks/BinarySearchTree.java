package com.scarycoders.learn.ds.geekOfgeeks;

public class BinarySearchTree {

    class Node {

        int key;
        Node left, right;

        Node(int i) {
            this.key = i;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inOrder() {
        inOrderRec(root);
    }

    void preOrder() {
        preOrderRec(root);
    }

    void postOrder() {
        postOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }

    void preOrderRec(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    void postOrderRec(Node root) {
        if (root != null) {
            preOrderRec(root.left);
            preOrderRec(root.right);
            System.out.println(root.key);
        }
    }

    public static void main(String[] args) {
        final BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(40);
        binarySearchTree.insert(23);
        binarySearchTree.insert(21);
        System.out.println("------------ inorder");
        binarySearchTree.inOrder();
        System.out.println("------------ preorder");
        binarySearchTree.preOrder();
        System.out.println("------------ postOrder");
        binarySearchTree.postOrder();
    }

}
