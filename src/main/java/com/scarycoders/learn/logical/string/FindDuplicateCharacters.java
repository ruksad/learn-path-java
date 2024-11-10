package com.scarycoders.learn.logical.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Program to find duplicate characters in String.
 *
 */
public class FindDuplicateCharacters {

  public static Map<Character, Integer> duplicateChar(String s) {

    ArrayList<Character> chars = s.chars().mapToObj(x -> {
     // System.out.println(x);
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
   // Map<Character, Integer> map = duplicateChar(s);
    /*Map<Character, Integer> map = countDuplicateChars(s);
    map.entrySet().forEach(x->{
      System.out.println(x.getKey()+"="+x.getValue());
    });*/

    ArrayList<String> strings = new ArrayList<>();
    strings.add("88 99 200");
    strings.add("88 99 300");
    strings.add("12 12 15");
    System.out.println(processLogs(strings,2));
  }

  public static Map<Character,Integer> countDuplicateChars(String string){
    HashMap<Character, Integer> stringIntegerHashMap = new LinkedHashMap<>();
    for(Character ch:string.toCharArray()){
      stringIntegerHashMap.compute(ch,(k,v)->(v==null)?1:++v);
    }
    return stringIntegerHashMap;
  }

  public static List<String> processLogs(List<String> logs, int threshHold){

    Map<String,Integer> sender=new TreeMap<>(String::compareTo);
    Map<String,Integer> receiver=new TreeMap<>(String::compareTo);
    logs.forEach(x->{
      String arr[]=x.split(" ");

        sender.compute(arr[0],(key,value)-> {
          if(null==value)
            return  1;
          else
            return ++value;
        });
        receiver.compute(arr[1],(key,value)-> null==value ? 1:++value);

    });
    List<String> objects = new ArrayList<>();
    receiver.forEach((key,val)->{
      if(val>=threshHold){
        objects.add(key);
      }
    });

    sender.forEach((k,v)->{
      if(v>=threshHold){
        objects.add(k);
      }
    });
    return objects;
  }


}
