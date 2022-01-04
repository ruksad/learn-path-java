package com.scarycoders.learn.dataStructure.tree;

import com.scarycoders.learn.dataStructure.Traverse;
import com.scarycoders.learn.dataStructure.Tree;

/**
 * Binary search tee has at most two children at current node, and left node should be less than
 * current node and right node should be greater than current node i.e BST does not allow duplicates
 * to support duplicate values node can store counter for number of time particular node is inserted in
 * BST
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>, Traverse {
    private Node<T> root;
    private int length;

    class Node<T extends Comparable<T>>{
        private T data;
        private Node<T> left,right;
        private int counter=1;
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
        Node(T data){
            this.data=data;
            this.left=this.right=null;
        }

        public int getCounter() {
            return counter;
        }
    }

    @Override public void inOrderDFS() {

    }

    @Override public void preOrderDFS() {

    }

    @Override public void postOrderDFS() {

    }

    @Override public void BFS() {

    }

    @Override public boolean add(T data) {
        final Node<T> node = new Node<T>(data);
        this.root=addRecursive(this.root,node);
        length++;
        return true;
    }

    @Override public boolean contains(T data) {
        final Node<T> tNode = new Node<>(data);
        return false;
    }

    @Override public T delete() {
        return null;
    }

    private Node<T> addRecursive(Node<T> current,Node<T> node){
        if(current==null){
            return root=node;
        }
        if(node.getData().compareTo(current.getData())<0){
            current.left=addRecursive(current.left,node);
        }else if(node.getData().compareTo(current.getData()) > 0){
            current.right=addRecursive(current.right,node);
        }else{
            /**
             *value already exists, increase counter and decrease on delete
             */
            current.counter ++;
            return current;
        }
        return current;
    }
}
