package com.scarycoders.learn.logical.string;

import java.util.*;
import java.util.stream.Collectors;
/*
find non repeated words from string
 */
public class FindStringNotRepeated {
    static List<String> findNonRepeatedWords(String str){
        String[] chunkedArr = str.split("\\s");
        List<String> strings = Arrays.asList(chunkedArr);
        Map<String,Integer> lm=new LinkedHashMap();
        strings.forEach(x->{
            lm.put(x,lm.get(x)==null?1:lm.get(x)+1);
        });
        List<String> collect = lm.entrySet().stream().filter((k) -> k.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        String str="I hate ruksad , ruksad I love plastic bags but are banned in maharastra i will sue you";
        List<String> nonRepeatedWords = findNonRepeatedWords(str);
        System.out.println(nonRepeatedWords);
    }
}
