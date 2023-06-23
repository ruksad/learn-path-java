package com.scarycoders.learn.ideserve;

public class AllPalindromicPartitions {

    static boolean isPalindrome(String input,int begin,int end){
        while(begin<end){
            if(input.charAt(begin)!=input.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    static boolean isPalindrome2(String input){
        for(int i = 0, j = input.length()-1; i<j; i++,j--){
            if(input.charAt(i)!=input.charAt(j))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String input="abcb";
        int begin=0;
        int end=input.length();
        String output="";
        printPalindromicPartitions(input,output,begin,end);
    }

    private static void printPalindromicPartitions(String input, String output, int begin, int end) {

        input.substring(1,3);
    }
}
