package com.scarycoders.learn.logical.Arrays;

public class SecondLargestOfArr {

    static int secondLargest(int[] input){

        int firstLargest,secondLargest;
        if(input[0]>input[1]){
            firstLargest=input[0];
            secondLargest=input[1];
        }else{
            firstLargest=input[1];
            secondLargest=input[0];
        }
        for(int i=2;i<input.length;i++){
            if(firstLargest<input[i]){
                secondLargest=firstLargest;
                firstLargest=input[i];
            }else if(firstLargest>input[i]&& secondLargest<input[i]){
                secondLargest=input[i];
            }
        }
        return secondLargest;
    }
    public static void main(String... s){
        int []a={9,1,4,1,3,4,5,7,8,-1,0,0,8,-0,7};
        System.out.println(secondLargest(a));
    }
}
