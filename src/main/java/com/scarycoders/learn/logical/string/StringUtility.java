package com.scarycoders.learn.logical.string;

import java.util.*;
import java.util.stream.Collectors;

public class StringUtility {

    /**
     * return string of length k which contains most vowels
     * @param s
     * @param k
     * @return
     */
    public static String findSubstring(String s, int k) {
        if(k>s.length()){
            return "";
        }
        List<Character> vowels = "aeiou".chars().mapToObj(x -> (char) x).collect(Collectors.toList());
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for(int i=0;i<=s.length()-k;i++){
            String substring = s.substring(i, i+k);
            int vowelCount=0;
            for(int j=0;j<substring.length();j++){
                if(vowels.contains(substring.charAt(j))){
                    vowelCount++;
                }
            }
            stringIntegerHashMap.put(substring,vowelCount);
        }
        return stringIntegerHashMap
                .entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    public static int findSameCharsIncludingDuplicates(String s,String t){
        int result=0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            sMap.compute(s.charAt(i),(key,value)->value==null?1:++value);
        }
        for(int i=0;i<t.length();i++){
            Character c = t.charAt(i);
            Integer integer = sMap.get(c);
            if(integer!=null && integer>0){
                sMap.put(c,--integer);
                result++;
            }
        }

        return result;
    }

    public static List<Character> findDuplicateCharsInString(String s){
        HashSet<Character> strings = new HashSet<>();
        return s.chars().mapToObj(x->(char)x).filter(str->!strings.add(str)).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        //System.out.println(findSubstring("riuksadaeo",3));
        System.out.println(findSameCharsIncludingDuplicates("abcd","cebaa"));
        System.out.println(findDuplicateCharsInString("JAVAA"));
    }
}
