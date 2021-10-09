package com.scarycoders.learn.language.inheritance.model;

/**
 * Compiler will force you to write constructor in Class B. Because, we are not defining constructor
 * for Class B. So, compiler will be providing default constructor. In that default constructor,
 * first statement is super() – it is a calling statement to default constructor of Class A. But it
 * is not defined in Class A. Therefore you will get a compile time error. To avoid this error,
 * write the constructor for sub class. From that constructor call super class constructor
 * explicitly
 */
public class ClassB extends ClassA {
  protected int k=10;
  public int a=20;
  int b=10;
  public ClassB() {
    //Explicitly Calling Class A constructor
    super(10);
  }


  /*ClassB(int j) {
    this();
  }*/

  public static void testing(){
    System.out.println("class b");
  }
}
