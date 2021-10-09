package com.scarycoders.learn.design.pattern.interator;

import java.util.List;

public class PatternIteratorImpl implements PatternIterator {

  private final List<DesignPattern> designPatterns;
  private int position;
  private DesignPattern designPattern;
  public PatternIteratorImpl(
      List<DesignPattern> designPatterns) {
    this.designPatterns = designPatterns;
  }

  @Override
  public DesignPattern nextPattern() {
    DesignPattern designPattern = designPatterns.get(position++);
    return designPattern;
  }

  @Override
  public boolean isLastPattern() {
    return position<designPatterns.size()?false:true;
  }
}
