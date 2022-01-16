package com.scarycoders.learn.algo.language;

public class SingletonClass {
    private static volatile SingletonClass classInstance=null;
    public static SingletonClass getInstance(){
        synchronized (SingletonClass.class){
            if(classInstance==null){
                classInstance=new SingletonClass();
            }
        }
        return classInstance;
    }
    private SingletonClass(){}
}
