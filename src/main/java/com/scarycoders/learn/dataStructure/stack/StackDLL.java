package com.scarycoders.learn.dataStructure.stack;

import com.scarycoders.learn.dataStructure.AbstractDLL;
import com.scarycoders.learn.dataStructure.AbstractStack;
import com.scarycoders.learn.dataStructure.linkedList.DoublyLinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;

public class StackDLL<T> implements AbstractStack<T>, AbstractDLL<T> {
    int len;
    final DoublyLinkedList<T> tDoublyLinkedList = new DoublyLinkedList<>();
    public StackDLL(){};
    @Override public int size() {
        return tDoublyLinkedList.size();
    }

    @Override public boolean isEmpty() {
        return tDoublyLinkedList.size()==0;
    }

    @Override public boolean push(T element) {
        return tDoublyLinkedList.add(element);
    }

    @Override public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return tDoublyLinkedList.removeAt(tDoublyLinkedList.size()-1);
    }

    @Override public Iterator<T> iterator() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return tDoublyLinkedList.iterator();
    }

    @Override public T peekFirst() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return tDoublyLinkedList.peekFirst();
    }

    @Override public T peekLast() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return tDoublyLinkedList.peekLast();
    }

    @Override public void clear() {
        tDoublyLinkedList.clear();
    }
}
