package com.scarycoders.learn.design.pattern.strategy;

public class CreditCardStrategy implements Strategy{
  private String creditCardNumber;
  private String creditCardType;
  private String CVV;

  @Override
  public void pay(int amount) {
    System.out.println(amount+"Paid by Credit Card");
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public String getCreditCardType() {
    return creditCardType;
  }

  public void setCreditCardType(String creditCardType) {
    this.creditCardType = creditCardType;
  }

  public String getCVV() {
    return CVV;
  }

  public void setCVV(String CVV) {
    this.CVV = CVV;
  }
}
