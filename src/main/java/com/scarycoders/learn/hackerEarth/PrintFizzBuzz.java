package com.scarycoders.learn.hackerEarth;

import java.util.stream.IntStream;

/**
 * print fizz buzz for multiples of 3 and 5
 */
public class PrintFizzBuzz {

  public static String run(int N, int M) {
    StringBuilder sb=new StringBuilder();
    IntStream.range(N,M+1).forEach(number->{
      if(number%3==0 && number%5==0){
        sb.append(",FizzBuzz");
      }else if(number%3==0){
        sb.append(",Fizz");
      }else if(number%5==0){
        sb.append(",Buzz");
      }else{
        sb.append(","+number);
      }
    });
    return sb.toString().replaceFirst(",","");
  }

  public static void main(String[] args) {
    System.out.println( run(1,16));
  }
}
