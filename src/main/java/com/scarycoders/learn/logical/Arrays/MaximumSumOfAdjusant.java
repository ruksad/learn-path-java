package com.scarycoders.learn.logical.Arrays;

public class MaximumSumOfAdjusant {


    static int maxAdjacentSum(int[] numbers){
        int maxSum=numbers[0];
        int currentSum=numbers[0];
        for(int i=1;i<numbers.length;i++){
            currentSum=Math.max(numbers[i],currentSum+numbers[i]);
            maxSum=Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int a[]={3,4,5,6,-7,8,-1};
        System.out.println(maxAdjacentSum(a));

    }
}
