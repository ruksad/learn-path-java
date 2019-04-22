package com.scarycoders.learn.design.Observer.observer;

import com.scarycoders.learn.design.Observer.subject.Observer;

public interface Subject {

  boolean registerObserver(Observer o);
  boolean removeObserver(Observer o);
  public void notifyObservers();
}
