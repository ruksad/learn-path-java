package com.scarycoders.learn.logical;

import java.util.ArrayList;

public class SumANumberUntilOneDigit1 {
   /* public static Integer sumit(Integer number1){
        int sum=0;
        int number=number1;
        while(number>9){

            *//*if(number<10 && sum>10) {
                sum+=number;
                number = sum;
            }*//*
            sum+=number % 10;
            number/=10;

        }

      // sum+=number;
        return sum;
    }*/


    static int digSum1(int n ){
       int sum=0;
       while(n>0 || sum >9){
           if(n==0){
               n=sum;
               sum=0;
           }
           sum+=n%10;
           n/=10;
       }
       return sum;
    }
    /*
    if number is divisible be 9 then it will return 9 if not then adding them recursively untill it become single digit will yeild
    number%9 same
     */
    static int digSum(int n)
    {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }

    public static void main(String[] args) {
        System.out.println(digSum1(998));
    }
}
