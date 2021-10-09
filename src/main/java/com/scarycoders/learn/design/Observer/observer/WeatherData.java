package com.scarycoders.learn.design.Observer.observer;

import com.scarycoders.learn.design.Observer.subject.Observer;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

  private String humidity;
  private String temperature;
  private String pressure;
  private List<Observer> observers = new ArrayList<>(10);

  @Override
  public boolean registerObserver(Observer o) {
    observers.add(o);
    return true;
  }

  @Override
  public boolean removeObserver(Observer o) {
    if (!observers.isEmpty() && observers.contains(o)) {
      return observers.remove(o);
    }
    return false;
  }

  @Override
  public void notifyObservers() {
      this.observers.forEach(observer -> observer.update(this.humidity,temperature,pressure));
  }

  public void setMeasurements(String humidity, String temperature, String pressure) {
    this.humidity = humidity;
    this.temperature = temperature;
    this.pressure = pressure;
    this.notifyObservers();
  }
}
