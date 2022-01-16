package com.scarycoders.learn.language.staticvars;

/**
 * Instance initializing block is called multiple times whenever we make object of the
 * class
 */
class ClassOne
{
    {
        System.out.println(1);
    }

    static
    {
        System.out.println(2);
    }

    public ClassOne(int i)
    {
        System.out.println(3);
    }

    public ClassOne()
    {
        System.out.println(4);
    }
}

public class StaticVars5
{
    {
        System.out.println(5);
    }

    public static void main(String[] args)
    {
        System.out.println(6);

        ClassOne one = new ClassOne();

        ClassOne two = new ClassOne(10);
    }
}
