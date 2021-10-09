package com.scarycoders.learn.hackerEarth.linkedList;


import java.util.Scanner;

public class ReverseLLWithSizeInArray {


    static class SinglyLinkedListNode{
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    static class SinglyLinkedList{
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;
        SinglyLinkedList(){
            this.head=null;
            this.tail=null;
        }

        public SinglyLinkedListNode addNode(int data){
            SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
            if(this.head==null){
                this.head=singlyLinkedListNode;
            }else{
                this.tail.next=singlyLinkedListNode;
            }
            this.tail=singlyLinkedListNode;
            return this.head;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    static void reversePrint(SinglyLinkedListNode head){
        if(head==null)
            return;
        SinglyLinkedListNode node=head;
        int itr=node.data;
        node=node.next;
        int elems=node.data;
        for(int i=1;i<=itr;i++){
            for(int j=1;j<=elems;j++){
                node=node.next;
                if(null!=node)
                    System.out.println(node.data);
            }
            elems=node.data;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.addNode(llistItem);
            }

            reversePrint(llist.head);
        }

        scanner.close();
    }

}
