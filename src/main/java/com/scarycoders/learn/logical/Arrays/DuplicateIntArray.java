package com.scarycoders.learn.logical.Arrays;

import java.util.*;
import java.util.stream.Collectors;


public class DuplicateIntArray {
    /**
     * input [1,2,2,3,4]
     * output [2]
     * <p>
     * input [1,3,3,4,4,5,5]
     * output [3,4,5]
     * <p>
     * input [1,2,3,4]
     * output[-1]
     */
    public static int[] findDuplicate(int[] arr) {

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        list.forEach(x -> {
            map.compute(x, (key, value) -> (value == null) ? 1 : ++value);
        });

        int[] ints = map.entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .map(Map.Entry::getKey).mapToInt(i -> i).toArray();

        return (ints.length == 0) ? new int[]{-1} : ints;

    }

    /**
     * input [12, 0, 7, 0, 8, 0, 3]
     * output [12, 7, 8, 3, 0, 0, 0]
     *
     * @param arr
     * @return
     */
    public static int[] moveZerosToEnd(int[] arr) {
        int nonZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZero] = arr[i];
                nonZero++;
            }
        }
        for (int i = nonZero; i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public static int[] moveZerosToFront(int[] arr) {
        int nonZeros=arr.length-1;

        for(int i= arr.length-1;i>=0;i--){
            if(arr[i]!=0){
              arr[nonZeros]=arr[i];
              nonZeros--;
            }
        }

        while (nonZeros>=0){
            arr[nonZeros]=0;
            nonZeros--;
        }
        return arr;
    }

    public static void main(String[] args) {
        printArray(findDuplicate(new int[]{1, 2, 2, 3, 3}));
        System.out.println("-----------------------------------");
        printArray(moveZerosToEnd(new int[]{0, 1, 0, 1, 0}));
        System.out.println("-----------------------------------");
        printArray(moveZerosToFront(new int[]{0, 1, 0, 1, 0,2,4,0}));
        System.out.println("-----------------------------------");
        System.out.println(migratoryBirds(new int[]{1,2,2,3,3,3,4,4,4,4,5,5,5,5}));
        System.out.println(migratoryBirds(new int[]{1,2,3,4}));
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * Given an array of bird sightings where every element represents a bird type id,
     * determine the id of the most frequently sighted type.
     * If more than 1 type has been spotted that maximum time,
     * return the smallest of their ids.
     * input [1,1,2,2,3]
     * output 1
     * @param birds
     * @return
     */
    public static int migratoryBirds(int [] birds){
        List<Integer> birdsList = Arrays.stream(birds).boxed().collect(Collectors.toList());
        Map<Integer,Integer> map = new TreeMap<>();
        birdsList.forEach(bird->{
            map.compute(bird,(key,value)-> value==null ? 1: ++value);
        });
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }
}
