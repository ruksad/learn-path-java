package com.scarycoders.learn.language.staticvars;
class A2
{
    static int i;

    static
    {
        i = 100;

        System.out.println(1);
    }

    static void staticMethod()
    {
        System.out.println(i);

        System.out.println(2);
    }
}

public class StaticVar4 {
    static
    {
        System.out.println(3);
    }

    public static void main(String[] args)
    {
        System.out.println(4);

        System.out.println(A2.i);

        A2.staticMethod();
    }
}
