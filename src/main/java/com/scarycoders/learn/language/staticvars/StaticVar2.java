package com.scarycoders.learn.language.staticvars;

public class StaticVar2 {

    private static String zero="0";
    static{
        System.out.println("1");
    }
    static {
        System.out.println("2");
    }
    static {
        System.out.println("3");
    }

    public static void main(String[] args) {
        StaticVar2 staticVar2;
    }
}
