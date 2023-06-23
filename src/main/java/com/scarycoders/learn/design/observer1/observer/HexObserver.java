package com.scarycoders.learn.design.observer1.observer;

import com.scarycoders.learn.design.observer1.subject.Subject;

public class HexObserver extends Observer{

    public HexObserver(Subject subject){
        this.subject=subject;
        this.subject.attachObserver(this);
    }
    @Override
    public boolean update(int data) {
        System.out.printf("Update from Hex Observer: %s \n",Integer.toHexString(data));
        return true;
    }
}
