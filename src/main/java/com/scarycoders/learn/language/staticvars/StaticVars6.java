package com.scarycoders.learn.language.staticvars;

/**
 * Static blocks are executed first before the static method, like below A and B are printed first before
 * static main method is executed
 */
public class StaticVars6 {

    static
    {
        System.out.println('A');
    }

    static
    {
        System.out.println('B');
    }

    public StaticVars6()
    {
        System.out.println('C');
    }

    public static void main(String[] args)
    {
        System.out.println('D');

        StaticVars6 a = new StaticVars6();
    }
}
