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
        Node<T> temp=this.head;
        final Node<T> newNode = new Node<>(element, null);
        if(head==null){
            head=newNode;
            len++;
            return true;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
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
        Node<T> next=this.head.next,temp=this.head;
        for(int i=0;i<len;i++){
            if(index==0){
                tNode.next=head;
                head=tNode;
                len++;
                return true;
            }else if(i+1==index){
                temp.next=tNode;
                tNode.next=next;
                len++;
                return true;
            }
            temp=temp.next;
            if(next!=null){
                next=next.next;
            }
        }
        return false;
    }

    @Override public T remove(T element) {
        Node<T> next=head.next,returnElement = null,temp=head;
        final Node<T> tNode = new Node<>(element, null);
        if(tNode.equals(head)){
            returnElement=head;
            head= head.next;
            len--;
            return returnElement.data;
        }

        while(next!=null){
            if(next.equals(tNode)){
                returnElement=next;
                len--;
                temp.next=next.next;
                return returnElement.data;
            }
            next=next.next;
            temp=temp.next;
        }

        return null;
    }

    @Override public T removeAt(int index) {
        Node<T> next=head.next,temp=head,returnElement;
        if(index<0){
            throw new IllegalArgumentException("Invalid index");
        }else if(index>len-1){
            throw new IllegalArgumentException("Invalid index");
        }
        for(int i=0;i<len;i++){
            if(index==0){
                returnElement=temp;
                head=next;
                len--;
                return returnElement.data;
            }else if(i+1==index){
                returnElement=next;
                temp.next=next.next;
                len--;
                return returnElement.data;
            }
            if(next!=null){
                next=next.next;
            }
            temp=temp.next;
        }
        return null;
    }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            int length=len;
            Node<T> temp =head;
            @Override public boolean hasNext() {
                return length>0;
            }
            @Override public T next() {
                if(length<1)
                    return null;
                Node<T> temp= this.temp;
                this.temp = this.temp.next;
                length--;
                return temp.data;
            }
        };
    }
}
