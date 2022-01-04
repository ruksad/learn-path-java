package com.scarycoders.learn.dataStructure;

public interface Tree<T> {
    boolean add(T data);
    boolean contains(T data);
    T delete();
}
