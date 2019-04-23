package com.scarycoders.learn.design.builder.inheritance;

public class NyPizza extends AbstractPizza {

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("NyPizza{");
    sb.append("size=").append(size);
    sb.append(", toppingsSet=").append(toppingsSet);
    sb.append('}');
    return sb.toString();
  }

  public enum Size {SMALL, MEDIUM, LARGE}

  ;
  private final Size size;

  public static class Builder extends AbstractPizza.Builder<Builder> {

    private final Size size;

    Builder(Size size) {
      this.size = size;
    }

    @Override
    NyPizza build() {
      return new NyPizza(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private NyPizza(Builder builder) {
    super(builder);
    this.size = builder.size;
  }
}
