package com.scarycoders.learn.logical.Arrays;

import java.util.Arrays;

public class FindSumOfTwoNumberIsTarget {

  public static int[] sumOfTwoNumberIsTarget(int[] nums, int target) {
    int a[] = new int[nums.length];
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          a[k++] = i;
          a[k++] = j;
        }
      }
    }
    return a;
  }


  public static void main(String[] args) {
    int[] ints = sumOfTwoNumberIsTarget(new int[]{2, 7, 11, 15}, 9);
    System.out.println(Arrays.toString(ints));
  }
}
