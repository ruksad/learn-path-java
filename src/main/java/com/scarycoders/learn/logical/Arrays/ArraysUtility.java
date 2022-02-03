package com.scarycoders.learn.logical.Arrays;

import java.util.Arrays;

public class ArraysUtility {

    /**
     * find continuous sub arrays making sum of sumNumber
     * @param arr
     * @param sumNumber
     * @return
     */
    public static int[][] continuousSubArrayForSum(int [] arr, int sumNumber){

        int[][] arrays =new int[10][10];
        int index=0;
        for(int i=0;i<arr.length;i++){

            int sum=arr[i];
            int[] ints1=null;
            boolean flag=false;
            for(int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                if(sum>sumNumber)
                    break;
                if(sum==sumNumber){
                    ints1 = Arrays.copyOfRange(arr, i, j+1);
                    arrays[index++]=ints1;
                    break;
                }
            }

        }
        return arrays;
    }

    public static int[][] findSubArray(int[] array, int sumNumber){
        int sum=0,start=0,row=0;
        int[][] ints = new int[10][10];
        for(int i=0;i<array.length;i++){
            sum+=array[i];
            while(sum>sumNumber){
                sum-=array[start++];
            }
            if(sum==sumNumber){
                int col=0;
                for(int j=start;j<=i;j++){
                    ints[row][col++]=array[j];
                }
                row ++;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        //int[][] ints = continuousSubArrayForSum(new int[]{1,2,7,3,6,1,9,8,2,3,5}, 18);
        int[][] ints = findSubArray(new int[]{18,1,2,7,3,6,1,9,8,2,3,5}, 18);
        for (int[] anInt : ints) {
            System.out.println();
            for (int i : anInt) {
                System.out.print(" "+i);
            }
        }
    }
}
