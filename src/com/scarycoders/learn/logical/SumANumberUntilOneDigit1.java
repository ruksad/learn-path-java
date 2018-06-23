package com.scarycoders.learn.logical;

import java.util.ArrayList;

public class SumANumberUntilOneDigit1 {
    public static Integer sumit(Integer number1){
        int sum=0;
        int number=number1;
        while(number>9){

            if(number<10 && sum>10) {
                sum+=number;
                number = sum;
            }
            sum+=number % 10;
            number/=10;
        }

      // sum+=number;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumit(1234));

        
    }
}
