package com.scarycoders.learn.design.observer1.observer;

import com.scarycoders.learn.design.observer1.subject.Subject;

public abstract class Observer {
    protected Subject subject;
    public abstract boolean update(int data);
}
