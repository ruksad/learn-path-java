package com.scarycoders.learn.language.inheritance;

/**
 * 1. Jvm introduced super() default constructor
 * 2. Immediately after it calls
 * 3. Initialization instance block
 * 4. Resumes with next line of constructor
 */


class A
{
    {
        System.out.println(1);
    }
    A(){
        System.out.println("a");
    }
}

class B extends A
{
    {
        System.out.println(2);
    }
    B(){
        System.out.println("b");
    }
}

class C extends B
{
    {
        System.out.println(3);
    }
    C(){
        System.out.println("c");
    }
}

public class Inheritance1 {
    public static void main(String[] args)
    {
        C c = new C();
    }
}
