package com.scarycoders.learn.logical;

public class Singletonclass {
  private static volatile Singletonclass singletonclass=null;
  public static Singletonclass getInstance(){
    synchronized (Singletonclass.class){
      if(singletonclass==null)
      {
        singletonclass=new Singletonclass();
      }
      return singletonclass;
    }
  }
  private Singletonclass(){ }
}
