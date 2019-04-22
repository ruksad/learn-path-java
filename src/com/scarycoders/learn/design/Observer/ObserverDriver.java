package com.scarycoders.learn.design.Observer;

import com.scarycoders.learn.design.Observer.observer.WeatherData;
import com.scarycoders.learn.design.Observer.subject.CurrentDisplay;

public class ObserverDriver {

  public static void main(String[] args) {
    WeatherData weatherData=new WeatherData();
    CurrentDisplay currentDisplay=new CurrentDisplay(weatherData);
    weatherData.setMeasurements("80","85","40");
  }

}
