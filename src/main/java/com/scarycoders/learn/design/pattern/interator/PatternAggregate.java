package com.scarycoders.learn.design.pattern.interator;

public interface PatternAggregate {
  boolean addPattern(DesignPattern designPattern);
  boolean removePattern(DesignPattern designPattern);
  PatternIterator getPatternIterator();
}
