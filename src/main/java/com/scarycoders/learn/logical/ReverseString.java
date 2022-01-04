package com.scarycoders.learn.logical;

import java.util.Objects;

public class ReverseString {
    public static String reverse(String str){
        if(Objects.isNull(str)|| str.length()<=1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("ruksad"));
    }

    public static String stringRev(String str){
        if(Objects.isNull(str)|| str.length()<=1){
            return str;
        }
        return stringRev(str.substring(1))+str.charAt(0);
    }
}
