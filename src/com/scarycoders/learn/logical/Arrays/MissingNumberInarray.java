package com.scarycoders.learn.logical.Arrays;

/*
 * Java Program to find missing numbers in an integer
 * array with duplicates. Array may contains more
 * than one duplicates.
 *
 * input: {1, 1, 2, 3, 5, 5, 7, 9, 9, 9};
 * output: 4, 6, 8
 */
public class MissingNumberInarray {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 3, 5, 5, 7, 9, 9, 9};
    int[] arr1 = new int[arr.length];
    for (int i : arr) {
      arr1[i] = 1;
    }
    System.out.print("Missing number are =");
    for(int i=0;i<arr1.length;i++){
      if (arr1[i] == 0) {
        System.out.println(i);
      }
    }
  }

}
