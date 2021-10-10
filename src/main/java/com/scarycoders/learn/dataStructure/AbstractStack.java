package com.scarycoders.learn.dataStructure;

public interface AbstractStack<T>{
    int size();
    boolean isEmpty();
    boolean push(T element);
    T pop();
}
