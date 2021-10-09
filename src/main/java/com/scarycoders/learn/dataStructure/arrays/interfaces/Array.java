package com.scarycoders.learn.dataStructure.arrays.interfaces;

public interface Array<T> {
    int size();
    boolean isEmpty();
    boolean add(T element);
    boolean addAt(int index,T element);
    T remove(T element);
    T removeAt(int index);
}
