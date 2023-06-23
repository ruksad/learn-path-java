package com.scarycoders.learn.design.observer1.observer;

import com.scarycoders.learn.design.observer1.subject.Subject;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject=subject;
        this.subject.attachObserver(this);
    }
    @Override
    public boolean update(int data) {
        System.out.printf("Update from BinaryObserver: %s \n",Integer.toBinaryString(data));
        return true;
    }
}
