package com.scarycoders.learn.design.builder;


import com.scarycoders.learn.design.builder.NutritionalFacts.Builder;

public class BuilderClientCode {

  public static void main(String[] args) {
    Builder builder = new Builder(50, 5);
    NutritionalFacts build = builder.calories(10).carbohydrates(30).sodium(10).build();
    System.out.println(build);

  }
}
