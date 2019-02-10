package com.scarycoders.learn.logical.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Program to find duplicate characters in String.
 *
 */
public class FindDuplicateCharacters {

  public static Map<Character, Integer> duplicateChar(String s) {

    ArrayList<Character> chars = s.chars().mapToObj(x -> {
      System.out.println(x);
     return (char) x;
    })
        .collect(Collectors.toCollection(ArrayList::new));

    Map<Character, Integer> map = new LinkedHashMap<>();

    chars.forEach(x -> {
      map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
    });
    return map;
  }

  public static void main(String[] args) {
    String s = "aAhey test for duplicate caharacter";
    Map<Character, Integer> map = duplicateChar(s);
    map.entrySet().forEach(x->{
      System.out.println(x.getKey()+"="+x.getValue());
    });
  }

}
