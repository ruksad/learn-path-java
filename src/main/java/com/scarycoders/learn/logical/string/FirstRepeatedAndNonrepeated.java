package com.scarycoders.learn.logical.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Print first repeated and non-repeated character
 */
public class FirstRepeatedAndNonrepeated {

    private static Map<Character,Integer> mapOfChars(String string){
        char chars[]=string.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character ch:chars){
            map.compute(ch,(k,v)->(v==null)?1:++v);
        }
        return map;
    }
    public static void main(String[] args) {
        Map<Character, Integer> map = mapOfChars("ruksaad");
        Optional<Map.Entry<Character, Integer>> first = map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst();
        Optional<Map.Entry<Character, Integer>> first1 = map.entrySet().stream().filter(x -> x.getValue() >= 2).findFirst();
        first.ifPresent(x->{
            System.out.println("first non repeated char= "+x.getKey());
        });
        first1.ifPresent(x->{
            System.out.println("first repeated char= "+x.getKey());
        });

        System.out.println();
    }
}
