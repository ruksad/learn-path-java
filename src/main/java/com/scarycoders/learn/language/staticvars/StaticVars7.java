package com.scarycoders.learn.language.staticvars;

public class StaticVars7 {

    static int methodOne(int i)
    {
        i = i++ + --i;

        return i;
    }

    static int methodTwo(int i)
    {
        int a=i,b=i;
        i = b-- + ++a ;//+ methodOne(i);

        return i;
    }

    public static void main(String[] args)
    {
        int i = 11;

        System.out.println(methodTwo(i) + ++i - --i);
    }
}
