package com.scarycoders.learn.design.builder.inheritance;

import com.scarycoders.learn.design.builder.inheritance.AbstractPizza.Toppings;
import com.scarycoders.learn.design.builder.inheritance.NyPizza.Builder;
import com.scarycoders.learn.design.builder.inheritance.NyPizza.Size;

public class BuilderClientCode {

  public static void main(String[] args) {
    AbstractPizza build = new Builder(Size.SMALL).addTopping(Toppings.CHEESE)
        .addTopping(Toppings.MUSHROOM).addTopping(Toppings.HAM).build();

    AbstractPizza build1 = new CalZonePizza.Builder().sauceInside(true)
        .addTopping(Toppings.MUSHROOM).build();

    System.out.println(build);
    System.out.println(build1);
  }
}
