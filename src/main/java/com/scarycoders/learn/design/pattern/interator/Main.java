package com.scarycoders.learn.design.pattern.interator;

public class Main {

  public static void main(String[] args) {
    DesignPattern pattern1 = new DesignPattern("Creational", "Factory Method");
    DesignPattern pattern2 = new DesignPattern("Creational", "Abstract Factory");
    DesignPattern pattern3 = new DesignPattern("Structural", "Adapter");
    DesignPattern pattern4 = new DesignPattern("Structural", "Bridge");
    DesignPattern pattern5 = new DesignPattern("Behavioral", "Chain of Responsibility");
    DesignPattern pattern6 = new DesignPattern("Behavioral", "Iterator");
    PatternAggregate patternAggregate=new PatternAggregateImpl();
    patternAggregate.addPattern(pattern1);
    patternAggregate.addPattern(pattern2);
    patternAggregate.addPattern(pattern3);
    patternAggregate.addPattern(pattern4);
    patternAggregate.addPattern(pattern5);
    patternAggregate.addPattern(pattern6);
    System.out.println("----------------------");
    printPattern(patternAggregate);
    patternAggregate.removePattern(pattern1);
    System.out.println("------------------------");
    printPattern(patternAggregate);
  }
  public static void printPattern(PatternAggregate patternAggregate){
    PatternIterator patternIterator = patternAggregate.getPatternIterator();
    while (!patternIterator.isLastPattern()){
      DesignPattern designPattern = patternIterator.nextPattern();
      System.out.println("pattern: "+designPattern.patternType);
    }
  }
}
