package com.scarycoders.learn.dataStructure;

import java.util.Iterator;

public interface AbstractDLL<T> {
    T peekFirst();
    T peekLast();
    void clear();
    int size();
    boolean isEmpty();
    Iterator<T> iterator();
}
