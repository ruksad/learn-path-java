package com.scarycoders.learn.language.staticvars;

/**
 * static block is executed before the static method as given in the below program
 * 3 is printed before 4, as we can see through
 * output will be
 * 3
 * 4
 * 1
 * 2
 * 100
 * SECOND
 */
class A1
{
    static int first;

    static String second;

    static
    {
        System.out.println(1);

        first = 100;
    }

    static
    {
        System.out.println(2);

        second = "SECOND";
    }
}

public class StaticVar3 {

    static
    {
        System.out.println(3);
    }

    public static void main(String[] args)
    {
        System.out.println(4);

        System.out.println(A1.first);

        System.out.println(A1.second);
    }
}
