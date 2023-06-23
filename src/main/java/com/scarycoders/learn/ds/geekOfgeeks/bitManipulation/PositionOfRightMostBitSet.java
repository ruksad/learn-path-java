package com.scarycoders.learn.ds.geekOfgeeks.bitManipulation;

/**
 * Position of rightmost set bit
 * Input: n = 18
 * Output: 2
 * Explanation: Binary Representation of 18 is 010010, hence position of first set bit from right is 2.
 *
 * Input:  n = 19
 * Output: 1
 * Explanation: Binary Representation of 19 is 010011, hence position of first set bit from right is 1.
 */
public class PositionOfRightMostBitSet {
    public static int getFirstSetBitPos(int n){
        return (int)((Math.log10(n & -n)) / Math.log10(2))
                + 1;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(getFirstSetBitPos(n));
    }
}
