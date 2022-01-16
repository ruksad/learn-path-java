package com.scarycoders.learn.logical.duplicate;

public class StringRev {

    private static String rev(String str){
        if(str.length()==1 || str.isBlank() || str.isEmpty())
            return str;

            return str.charAt(str.length()-1)+rev(str.substring(0,str.length()-1));
    }
    public static void main(String[] args) {
        System.out.println(rev("Ruksad siddiqui") );
    }
}
