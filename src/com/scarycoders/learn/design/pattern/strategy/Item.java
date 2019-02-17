package com.scarycoders.learn.design.pattern.strategy;

import java.util.Objects;

public class Item {
  private String itemName;
  private int price;

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    Item item = (Item) o;
    return price == item.price &&
        Objects.equals(itemName, item.itemName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemName, price);
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
