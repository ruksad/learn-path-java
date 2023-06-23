package com.scarycoders.learn.design.pattern.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;

public class StrategyShopingCart {
  private List<Item> itemList=new ArrayList<>();

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  public boolean addItem(Item item){
    return this.itemList.add(item);
  }

  public boolean removeItem(Item item){
    return this.itemList.remove(item);
  }

  /**
   * this method decides which to use at runtime
   * @param strategy
   * @return
   */
  public void pay(Strategy strategy){
    int amount =calculateAmount();
    strategy.pay(amount);
  }

  private int calculateAmount() {

    OptionalInt reduce = this.itemList.stream().mapToInt(Item::getPrice).reduce(Integer::sum);
    return reduce.isPresent() ? reduce.getAsInt():0;
  }
}
