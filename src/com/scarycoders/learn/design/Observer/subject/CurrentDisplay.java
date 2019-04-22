package com.scarycoders.learn.design.Observer.subject;

import com.scarycoders.learn.design.Observer.observer.WeatherData;

public class CurrentDisplay implements Observer, DisplayElement {

  private String humidity;
  private String temperature;
  private WeatherData weatherData;

  public CurrentDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    this.weatherData.registerObserver(this);
  }

  @Override
  public void update(String humidity, String temperature, String pressure) {
    this.humidity = humidity;
    this.temperature = temperature;
    this.display();
  }

  @Override
  public void display() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return "CurrentDisplay{" +
        "humidity='" + humidity + '\'' +
        ", temperature='" + temperature +
        '}';
  }
}
