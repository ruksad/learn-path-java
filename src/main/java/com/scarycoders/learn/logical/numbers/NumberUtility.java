package com.scarycoders.learn.logical.numbers;

import java.util.*;

public class NumberUtility {
    /**
     * Sum of all digits until number becomes single digit
     * @param number
     * @return
     */
    public static int sumOfAllDigits(int number){
        int sum=0;
        while(number%10!=0){
           sum+=number%10;
           number/=10;
        }
        Map<Integer, Integer> integerIntegerHashtable = new Hashtable<>();
        Map<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        if(sum>9)
            return sumOfAllDigits(sum);
        return sum;
    }

    /**
     * if {4, 5, 7, 11, 9, 13, 8, 12} is an array and 20 is the given number,
     * then you have to find all pairs of elements in this array whose sum must be 20.
     * In this example, (9, 11), (7, 13) and (8, 12) are such pairs whose sum is 20.
     * @param a
     * @param sum
     * @return
     */
    public static List<List<Integer>> findPairsOfSumOfNumber(int a[], int sum){
      int i=0,j= a.length-1;
        List<List<Integer>> intsList = new ArrayList<>();
        while(i<j){
            if(a[i]+a[j]==sum){
                List<Integer> ints = new ArrayList<>();
                ints.add(a[i]);
                ints.add(a[j]);
                intsList.add(ints);
                i++;
                j--;
            }else if(a[i]+a[j]>sum){
                i++;
            }else if(a[i]+a[j]<sum){
                j--;
            }
        }
        return intsList;
    }

    public static int findLargestWithoutDigit(int number,int digit){

        String s1 = Integer.toString(digit);
        for(int i=number;i>=0;i--){
            if(!Integer.toString(i).contains(s1))
                return i;
        }
        return 0;
    }
    private static  int countChocFromWrapper(int choc, int wrapper){
        if(choc<wrapper)
            return 0;
        int chocFromWrapper = choc / wrapper;
        return chocFromWrapper+countChocFromWrapper(chocFromWrapper+choc%wrapper,wrapper);
    }
   public static int countMaximumChoc(int amount,int price, int wrapper){
        int choc=amount/price;
        return choc+countChocFromWrapper(choc,wrapper);
   }
    public static void main(String[] args) {
        //System.out.println(sumOfAllDigits(12356765));
       // System.out.println(sumOfAllDigits(3333));
        //System.out.println(-12+1);
        //System.out.println(findPairsOfSumOfNumber(new int[]{1,6,3,24,-12,9,6,11},12));
        //System.out.println(findLargestWithoutDigit(145,5));
        System.out.println(countMaximumChoc(15,2,3));
    }
}
