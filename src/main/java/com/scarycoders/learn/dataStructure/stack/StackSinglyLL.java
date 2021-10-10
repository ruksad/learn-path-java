package com.scarycoders.learn.dataStructure.stack;

import com.scarycoders.learn.dataStructure.AbstractStack;

public class StackSinglyLL<T> implements AbstractStack<T> {
    int len;

    @Override public int size() {
        return 0;
    }

    @Override public boolean isEmpty() {
        return false;
    }

    @Override public boolean push(T element) {
        return false;
    }

    @Override public T pop() {
        return null;
    }
}
