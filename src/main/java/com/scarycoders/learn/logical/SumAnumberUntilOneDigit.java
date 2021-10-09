package com.scarycoders.learn.logical;

import java.util.ArrayList;
import java.util.Objects;

public class SumAnumberUntilOneDigit {

    public static int sumIt(String number){
       if(Objects.isNull(number)|| number.length()<=1){
           return Integer.parseInt(number);
       }


        int i = sumIt(number.substring(1)) + Character.getNumericValue(number.charAt(0));
       if(i<10)
        return i;
       else
          return sumIt(String.valueOf(i));
    }

    public static void main(String[] args) {

        System.out.println(sumIt("28101991"));
        //ArrayList<String> strings = new ArrayList<>();
    }
}
