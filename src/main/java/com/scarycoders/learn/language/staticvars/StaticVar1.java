package com.scarycoders.learn.language.staticvars;

/**
 *  static block is called just before the class access, static block cannot be nested
 *  you cannot initialize non-static vars inside static block
 * output will be
 * 2
 * 3
 * 1
 * 100
 */

class A
{
    static int i;

    static
    {
        System.out.println(1);

        i = 100;
    }
}

public class StaticVar1
{
    static
    {
        System.out.println(2);
    }

    public static void main(String[] args)
    {
        System.out.println(3);

        System.out.println(A.i);
    }
}
