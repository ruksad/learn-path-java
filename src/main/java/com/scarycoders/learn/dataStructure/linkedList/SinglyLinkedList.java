package com.scarycoders.learn.dataStructure.linkedList;

import com.scarycoders.learn.dataStructure.AbstractList;

import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedList<T> implements AbstractList<T> {

    private class Node<T>{
        T data = null;
        Node<T> next=null;
        Node(T data,Node<T> next){
            this.data=data;
            this.next=next;
        }

        @Override public String toString() {
            if(this.data!=null)
                return data.toString();
            return "";
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data);
        }

        @Override public int hashCode() {
            return Objects.hash(data);
        }
    }

    private Node<T> head=null;
    private int len=0;
    @Override public int size() {
        return len;
    }

    @Override public boolean isEmpty() {
        return len==0;
    }

    @Override public boolean add(T element) {
        Node<T> tail=this.head;
        final Node<T> newNode = new Node<>(element, null);
        if(head==null){
            head=newNode;
            len++;
            return true;
        }
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=newNode;
        len++;
        return true;
    }

    @Override public boolean addAt(int index, T element) {
        if(index<0){
            index=0;
        }else if(index>len-1){
            index=len;
        }
        final Node<T> tNode = new Node<>(element, null);
        if(0==len){
            this.add(element);
            return true;
        }
        Node<T> tail=this.head.next,temp=this.head;
        for(int i=0;i<len;i++){
            if(index==0){
                tNode.next=head;
                head=tNode;
                len++;
                return true;
            }else if(i+1==index){
                temp.next=tNode;
                tNode.next=tail;
                len++;
                return true;
            }
            temp=temp.next;
            if(tail!=null){
                tail=tail.next;
            }
        }
        return false;
    }

    @Override public T remove(T element) {
        Node<T> tail=head.next,returnElement = null,temp=head;
        final Node<T> tNode = new Node<>(element, null);
        if(tNode.equals(head)){
            returnElement=head;
            head= head.next;
            len--;
            return returnElement.data;
        }

        while(tail!=null){
            if(tail.equals(tNode)){
                returnElement=tail;
                len--;
                temp.next=tail.next;
                return returnElement.data;
            }
            tail=tail.next;
            temp=temp.next;
        }

        return null;
    }

    @Override public T removeAt(int index) {
        Node<T> tail=head.next,temp=head,returnElement;
        if(index<0){
            throw new IllegalArgumentException("Invalid index");
        }else if(index>len-1){
            throw new IllegalArgumentException("Invalid index");
        }
        for(int i=0;i<len;i++){
            if(index==0){
                returnElement=temp;
                head=tail;
                len--;
                return returnElement.data;
            }else if(i+1==index){
                returnElement=tail;
                temp.next=tail.next;
                len--;
                return returnElement.data;
            }
            if(tail!=null){
                tail=tail.next;
            }
            temp=temp.next;
        }
        return null;
    }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            int length=len;
            Node<T> tail=head;
            @Override public boolean hasNext() {
                return length>0;
            }
            @Override public T next() {
                if(length<1)
                    return null;
                Node<T> temp=tail;
                tail=tail.next;
                length--;
                return temp.data;
            }
        };
    }
}
