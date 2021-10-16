package com.scarycoders.learn.dataStructure.linkedList;

import com.scarycoders.learn.dataStructure.AbstractDLL;
import com.scarycoders.learn.dataStructure.AbstractList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements AbstractList<T>, AbstractDLL<T> {

    Node<T> head;
    Node<T> tail;
    int len = 0;

    public DoublyLinkedList() {
    }

    private class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override public int size() {
        return len;
    }

    @Override public boolean isEmpty() {
        return len == 0;
    }

    @Override public boolean add(T element) {
        Node<T> temp = head;
        if (temp == null) {
            head = tail = new Node<T>(element, null, null);
            len++;
            return true;
        } else {
            final Node<T> tNode = new Node<>(element, null, null);
            if (tail == head) {
                head.next = tNode;
                tNode.prev = head;
            } else {
                tail.next = tNode;
                tNode.prev = tail;
            }
            tail = tail.next;
            len++;
            return true;
        }
    }

    @Override public boolean addAt(int index, T element) {
        Node<T> temp = head;
        if (index < 0) {
            index = 0;
        } else if (index > len) {
            index = len;
        }
        if (temp == null) {
            add(element);
        } else {
            final Node<T> tNode = new Node<>(element, null, null);
            for (int i = 0; i < len; i++) {
                if (i == index) {
                    tNode.prev = temp.prev;
                    tNode.next = temp;

                    if (temp.prev == null) {
                        head = tNode;
                    } else {
                        temp.prev.next = tNode;
                    }

                    temp.prev = tNode;
                    len++;
                    return true;
                }
                temp = temp.next;
            }
            if (index == len) {
                add(element);
            }
        }
        return false;
    }

    @Override public T remove(T element) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(element)) {
                if (temp == head) {
                    return removeFirst();
                } else {
                    if (temp == tail) {
                        return removeLast();
                    }
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    temp.prev = null;
                    temp.next = null;
                    len--;
                    return temp.data;
                }
            }
            temp = temp.next;
        }
        return null;
    }

    @Override public T removeAt(int index) {
        Node<T> temp = head;
        if (index < 0) {
            throw new IllegalArgumentException("Illegal argument");
        } else if (index > len - 1) {
            throw new IllegalArgumentException("Illegal argument");
        }

        for (int i = 0; i < len; i++) {
            if (index == 0) {
                return removeFirst();
            } else if (i == len - 1) {
                return removeLast();
            } else if (index == i) {
                len--;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = null;
                temp.prev = null;
                return temp.data;
            }
        }
        return null;
    }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            int length = len;
            Node<T> node = head;

            @Override public boolean hasNext() {
                return length > 0;
            }

            @Override public T next() {
                if (length == 0)
                    return null;
                final T data = (T) node.data;
                node = node.next;
                length--;
                return data;
            }
        };
    }

    @Override public T peekFirst() {
        return head.data;
    }

    @Override public T peekLast() {
        return tail.data;
    }

    @Override public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> temp = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = temp;
            len--;
        }
        head = tail = null;
    }

    private T removeFirst() {
        Node<T> temp = head;
        len--;
        if (head == tail) {
            tail = null;
        }
        head = head.next;
        head.prev = null;
        temp.next = null;
        return temp.data;
    }

    private T removeLast() {
        Node<T> temp = tail;
        len--;
        if (head == tail) {
            head = null;
        }
        tail = temp.prev;
        temp.prev = null;
        return temp.data;
    }
}
