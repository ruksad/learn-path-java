package com.scarycoders.learn.language.inheritance.test;

import com.scarycoders.learn.language.inheritance.model.ClassA;
import com.scarycoders.learn.language.inheritance.model.ClassB;

class Testing extends ClassB {

  /**
   * Protected member can not be used outside the package but Protected member can be inherited to any subclass
   */
  public void methodOfClassTesting(){
    System.out.println(x);
    ClassB classB=new ClassB();
    //System.out.println(classB.k);
  }
  public static void main(String[] args) {
    ClassA a =new ClassB();
    a.testing();
  }

}