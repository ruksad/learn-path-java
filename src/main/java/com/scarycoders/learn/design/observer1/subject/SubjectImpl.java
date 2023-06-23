package com.scarycoders.learn.design.observer1.subject;

import com.scarycoders.learn.design.observer1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
    private List<Observer> allObservers=new ArrayList<>();
    private int notifyData;


    @Override
    public boolean attachObserver(Observer observer) {
        return this.allObservers.add(observer);
    }

    @Override
    public boolean notifyAllObservers() {
        this.allObservers.forEach(x->x.update(this.notifyData));
        return true;
    }

    public int getNotifyData() {
        return notifyData;
    }

    public void setNotifyData(int notifyData) {
        this.notifyData = notifyData;
        notifyAllObservers();
    }
}
