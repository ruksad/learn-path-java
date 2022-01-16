package com.scarycoders.learn.logical.string;

/**
 * print distinct permutation
 */
public class PrintAllPermutation {

    public static void permutations(String s, String ans){

        if(s.isEmpty() || s.isBlank()){
            System.out.print(ans+" ");
            return;
        }
        // Make a boolean array of size '26' which
        // stores false by default and make true
        // at the position which alphabet is being
        // used
        boolean[] charsUsed = new boolean[26];
        for(int i=0;i<s.length();i++){
            char chatAt=s.charAt(i);
            String remainString= s.substring(0,i)+s.substring(i+1);
            if(!charsUsed[chatAt-'a']){
                permutations(remainString,ans+chatAt);
                charsUsed[chatAt-'a']=true;
            }

        }
    }

    public static void main(String[] args) {
        permutations("geek","");
    }
}
