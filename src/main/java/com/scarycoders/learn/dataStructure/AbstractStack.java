package com.scarycoders.learn.dataStructure;

import java.util.Iterator;

public interface AbstractStack<T>{
    int size();
    boolean isEmpty();
    boolean push(T element);
    T pop();
    Iterator<T> iterator();
}
