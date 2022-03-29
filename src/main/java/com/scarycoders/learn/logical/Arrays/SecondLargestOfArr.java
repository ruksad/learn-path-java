package com.scarycoders.learn.logical.Arrays;

public class SecondLargestOfArr {

    static int secondLargest(int[] input) {

        int firstLargest, secondLargest;
        if (input[0] > input[1]) {
            firstLargest = input[0];
            secondLargest = input[1];
        } else {
            firstLargest = input[1];
            secondLargest = input[0];
        }
        for (int i = 2; i < input.length; i++) {
            if (firstLargest < input[i]) {
                secondLargest = firstLargest;
                firstLargest = input[i];
            } else if (firstLargest > input[i] && secondLargest < input[i]) {
                secondLargest = input[i];
            }
        }
        return secondLargest;
    }

    public static void secondLargestAndSecondSmallest(int[] input) {
        int largest = 0, secondLargest = 0, smallest = 0, secondSmallest = 0;
        if (input[0] > input[1]) {
            largest = input[0];
            secondLargest = input[1];
            smallest = input[1];
            secondSmallest = input[0];
        } else {
            largest = input[1];
            secondLargest = input[0];
            secondSmallest = input[1];
            smallest = input[0];
        }

        for (int i = 2; i < input.length; i++) {

            if (input[i] > largest) {
                secondLargest = largest;
                largest = input[i];
            } else if (secondLargest < largest && input[i] > secondLargest) {
                secondLargest = input[i];
            } else if (input[i] < smallest) {
                secondSmallest = smallest;
                smallest = input[i];
            } else if (secondSmallest < smallest && input[i] > secondSmallest) {
                secondSmallest = input[i];
            }
        }
        System.out.println("Largest= " + largest + " second largest= " + secondLargest +
                "Smallest= " + smallest + " Second smallest= " + secondSmallest);
    }

    public static void main(String... s) {
        int[] a = {1, 19, 1, 4, 1, 3, 4, 15, 7, 8, -1, 0, 0, 8, -0, 7, -10, -11};
        secondLargestAndSecondSmallest(a);
        //System.out.println(secondLargest(a));
    }
}
