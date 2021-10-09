package com.scarycoders.learn.design.pattern.strategy;

import java.util.ArrayList;

/**
 * Strategy design pattern is used when we have multiple ways to implement specific task,
 * java's Collections.sort() user strategy design pattern as Comparator can implement its own ways to
 * implement sorting
 */
public class StrategyPatternTest {

  public static void main(String[] args) {

    Item item = new Item();
    item.setItemName("watch");
    item.setPrice(1500);
    Item item1 = new Item();
    item1.setItemName("Perfume");
    item1.setPrice(700);

    StrategyShopingCart strategyShopingCart = new StrategyShopingCart();
    strategyShopingCart.addItem(item);
    strategyShopingCart.addItem(item1);
    /**
     * at client decides the strategy used at run time
     */
    strategyShopingCart.pay(new PaypalStrategy());
    strategyShopingCart.pay(new CreditCardStrategy());
  }
}
