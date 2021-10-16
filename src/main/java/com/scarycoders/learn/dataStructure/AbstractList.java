package com.scarycoders.learn.dataStructure;

import java.util.Iterator;

public interface AbstractList<T> {
    boolean add(T element);
    boolean addAt(int index,T element);
    T remove(T element);
    T removeAt(int index);
}
