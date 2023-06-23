package com.scarycoders.learn.design.observer1.observer;


import com.scarycoders.learn.design.observer1.subject.Subject;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject=subject;
        this.subject.attachObserver(this);
    }
    @Override
    public boolean update(int data) {
        System.out.printf("Update from octal observer: %s \n",Integer.toOctalString(data));
        return true;
    }
}
