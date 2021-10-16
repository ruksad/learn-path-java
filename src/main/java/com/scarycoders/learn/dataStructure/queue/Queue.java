package com.scarycoders.learn.dataStructure.queue;

import com.scarycoders.learn.dataStructure.linkedList.DoublyLinkedList;
import com.scarycoders.learn.dataStructure.AbstractQueue;

import java.util.Iterator;

public class Queue<T> implements AbstractQueue<T> {

    DoublyLinkedList<T> dll = new DoublyLinkedList<T>();

    @Override public T peekFirst() {
        if (dll.isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return dll.peekFirst();
    }

    @Override public T peekLast() {
        if (dll.isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return dll.peekLast();
    }

    @Override public void clear() {
        dll.clear();
    }

    @Override public int size() {
        return dll.size();
    }

    @Override public boolean isEmpty() {
        return dll.isEmpty();
    }

    @Override public boolean offer(T element) {
        if (element == null) {
            throw new RuntimeException("Null are not supported in this queue");
        }
        return dll.addAt(dll.size(), element);
    }

    @Override public T poll() {
        if (dll.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return dll.removeAt(0);
    }

    @Override public Iterator<T> iterator() {
        return dll.iterator();
    }
}
