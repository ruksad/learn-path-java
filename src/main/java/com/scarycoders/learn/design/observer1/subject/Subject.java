package com.scarycoders.learn.design.observer1.subject;

import com.scarycoders.learn.design.observer1.observer.Observer;

public interface Subject {
    boolean attachObserver(Observer observer);
    boolean notifyAllObservers();
}
