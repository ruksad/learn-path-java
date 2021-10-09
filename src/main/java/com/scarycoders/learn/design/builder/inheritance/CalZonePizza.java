package com.scarycoders.learn.design.builder.inheritance;

public class CalZonePizza extends AbstractPizza {

  private final boolean isSauceInside;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CalZonePizza{");
    sb.append("isSauceInside=").append(isSauceInside);
    sb.append(", toppingsSet=").append(toppingsSet);
    sb.append('}');
    return sb.toString();
  }

  public static class Builder extends AbstractPizza.Builder<Builder> {

    private boolean isSauceInside = false;

    public Builder sauceInside(boolean isSauceInside) {
      this.isSauceInside = isSauceInside;
      return self();
    }

    @Override
    CalZonePizza build() {
      return new CalZonePizza(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  CalZonePizza(Builder builder) {
    super(builder);
    this.isSauceInside = builder.isSauceInside;
  }
}
