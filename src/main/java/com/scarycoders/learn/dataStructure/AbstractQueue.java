package com.scarycoders.learn.dataStructure;

import java.util.Iterator;

public interface AbstractQueue<T> extends AbstractDLL<T> {
    T peekFirst();
    T peekLast();
    boolean offer(T element);
    T poll();
    Iterator<T> iterator();
}
