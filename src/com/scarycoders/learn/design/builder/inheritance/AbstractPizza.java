package com.scarycoders.learn.design.builder.inheritance;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractPizza {

  public enum Toppings {HAM, MUSHROOM, ONION, CHEESE, PEPPER, SAUSAGE}

  ;
  final Set<Toppings> toppingsSet;

  abstract static class Builder<T extends Builder<T>> {

    final Set<Toppings> toppings = EnumSet.noneOf(Toppings.class);

    public Builder addTopping(Toppings toppings) {
      this.toppings.add(Objects.requireNonNull(toppings));
      return self();
    }

    abstract AbstractPizza build();

    protected abstract T self();
  }

  AbstractPizza(Builder<?> builder) {
    this.toppingsSet = builder.toppings;
  }

}
