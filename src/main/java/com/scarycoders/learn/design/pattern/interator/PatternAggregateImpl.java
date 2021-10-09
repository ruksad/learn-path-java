package com.scarycoders.learn.design.pattern.interator;

import java.util.ArrayList;
import java.util.List;

public class PatternAggregateImpl implements PatternAggregate {

  private List<DesignPattern> list=new ArrayList<DesignPattern>();
  @Override
  public boolean addPattern(DesignPattern designPattern) {
    return list.add(designPattern);
  }

  @Override
  public boolean removePattern(DesignPattern designPattern) {
    return list.remove(designPattern);
    }

  @Override
  public PatternIterator getPatternIterator() {
    return new PatternIteratorImpl(list);
  }
}
