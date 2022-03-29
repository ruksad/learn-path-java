package com.scarycoders.learn.logical.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysUtility {

    /**
     * find continuous sub arrays making sum of sumNumber
     *
     * @param arr
     * @param sumNumber
     * @return
     */
    public static int[][] continuousSubArrayForSum(int[] arr, int sumNumber) {

        int[][] arrays = new int[10][10];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            int sum = arr[i];
            int[] ints1 = null;
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum > sumNumber)
                    break;
                if (sum == sumNumber) {
                    ints1 = Arrays.copyOfRange(arr, i, j + 1);
                    arrays[index++] = ints1;
                    break;
                }
            }

        }
        return arrays;
    }

    public static int[][] findSubArray(int[] array, int sumNumber) {
        int sum = 0, start = 0, row = 0;
        int[][] ints = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            while (sum > sumNumber) {
                sum -= array[start++];
            }
            if (sum == sumNumber) {
                int col = 0;
                for (int j = start; j <= i; j++) {
                    ints[row][col++] = array[j];
                }
                row++;
            }
        }
        return ints;
    }

    private static int maxNumberOfArr(int[] arr, int maxOfArray) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < maxOfArray && arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    /**
     * Maximum sum of increasing order elements from n arrays,
     * Given n arrays of size m each.
     * Find maximum sum obtained by selecting a number from each array such that the element selected from the
     * i-th array is more than the element selected from (i-1)-th array.
     * If maximum sum cannot be obtained then return 0.
     * <p>
     * Input : arr[ ] = {{1,7,4,3}, {4,2,5,1}, {9,5,1,8}}
     * Output : 18
     * Explanation:
     * We can select 9 from the last array,
     * 5 from last but second array and 4 from the first array.
     *
     * @param n   rows
     * @param m   col
     * @param arr
     * @return
     */
    public static int maximumSum(int n, int m, int arr[][]) {
        int maxOfArray = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxOfArray = maxNumberOfArr(arr[i], maxOfArray);
            if (maxOfArray == -1)
                return 0;
            sum += maxOfArray;
        }
        return sum;
    }


    /**
     * find and last occurrence of number in the given number in sorted array
     *
     * @param arr
     * @param length
     * @param numberToFind
     * @return
     */
    public static ArrayList<Integer> findFirstAndLast(int[] arr, int length, int numberToFind) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {

            if (numberToFind == arr[i]) {
                int j = i + 1;
                while (j < length && arr[j] == arr[i]) {
                    j++;
                }
                integers.add(i);
                integers.add(j - 1);

                break;
            }

        }

        if (integers.size() == 0)
            integers.add(-1);
        return integers;
    }

    /**
     * Given an integer array with the elements as 2,1,0,0,1,2,1,1,0,1,2,1.
     * Arrange the elements in this order 2,2,2,0,0,0,1,1,1,1,1,1
     *
     * @param arr
     * @return
     */
    public static void arrange() {
        int[] arr = {2, 1, 0, 0, 1, 2, 1, 1, 0, 1, 2, 1};
        int[] tempArr = new int[arr.length];
        int startIndex = 0;
        int endIndex = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                tempArr[startIndex++] = arr[i];
            }
            if (arr[i] == 1) {
                tempArr[endIndex--] = arr[i];
            }
        }
        for (int i : tempArr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        //int[][] ints = continuousSubArrayForSum(new int[]{1,2,7,3,6,1,9,8,2,3,5}, 18);
        /*int[][] ints = findSubArray(new int[]{18,1,2,7,3,6,1,9,8,2,3,5}, 18);
        for (int[] anInt : ints) {
            System.out.println();
            for (int i : anInt) {
                System.out.print(" "+i);
            }
        }*/
        // System.out.println(findFirstAndLast(new int []{0 ,0, 1, 1, 2},5,1));
        arrange();
        /*System.out.println(maximumSum(4,6,new int[][]{{1 ,10 ,3 ,5 ,6 ,4},
                {10, 9 ,4 ,3, 4 ,3},
                {6 ,1 ,4, 7 ,2 ,1},
                {6 ,7 ,7 ,5 ,5 ,2}}));*/
    }
}
