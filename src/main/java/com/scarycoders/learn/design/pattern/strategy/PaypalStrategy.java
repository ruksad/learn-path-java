package com.scarycoders.learn.design.pattern.strategy;

import java.util.Objects;

public class PaypalStrategy implements Strategy {
  private String userName;
  private String payPalId;
  @Override
  public void pay(int amount) {
    System.out.println(amount+"Paid by paypal");
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PaypalStrategy)) {
      return false;
    }
    PaypalStrategy that = (PaypalStrategy) o;
    return Objects.equals(getUserName(), that.getUserName()) &&
        Objects.equals(payPalId, that.payPalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserName(), payPalId);
  }
}
