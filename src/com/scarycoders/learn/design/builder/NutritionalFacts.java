package com.scarycoders.learn.design.builder;

public class NutritionalFacts {

  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fats;
  private final int sodium;
  private final int carbohydrates;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("NutritionalFacts{");
    sb.append("servingSize=").append(servingSize);
    sb.append(", servings=").append(servings);
    sb.append(", calories=").append(calories);
    sb.append(", fats=").append(fats);
    sb.append(", sodium=").append(sodium);
    sb.append(", carbohydrates=").append(carbohydrates);
    sb.append('}');
    return sb.toString();
  }

  public static class Builder {

    private final int servings;
    private final int servingSize;
    private int calories;
    private int fats;
    private int sodium;
    private int carbohydrates;

    Builder(int servingSize, int servings) {
      this.servings = servings;
      this.servingSize = servingSize;
    }

    public Builder calories(int calories) {
      this.calories = calories;
      return this;
    }

    public Builder fats(int fats) {
      this.fats = fats;
      return this;
    }

    public Builder sodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder carbohydrates(int carbohydrates) {
      this.carbohydrates = carbohydrates;
      return this;
    }

    public NutritionalFacts build() {
      return new NutritionalFacts(this);
    }
  }

  private NutritionalFacts(Builder builder) {
    this.servings = builder.servings;
    this.servingSize = builder.servingSize;
    this.calories = builder.calories;
    this.fats = builder.fats;
    this.sodium = builder.sodium;
    this.carbohydrates = builder.carbohydrates;
  }

}
