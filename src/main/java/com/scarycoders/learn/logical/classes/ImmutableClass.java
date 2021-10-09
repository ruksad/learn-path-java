package com.scarycoders.learn.logical.classes;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
    private final int a;
    private final String name;

    private final HashMap<String,Integer> map;

    public ImmutableClass(int a,String name,Map<String,Integer> map){
        this.a=a;
        this.name=name;
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        map.forEach((k,v)->{
            stringIntegerHashMap.put(k,v);
        });
        this.map=stringIntegerHashMap;
    }

   /* public ImmutableClass(int a,String name,HashMap<String,Integer> map){
        this.a=a;
        this.name=name;
        this.map=map;
    }*/

    public int getA() {
        return a;
    }

    public String getName() {

        return name;
    }

    public Map<String, Integer> getMap() {
        Object clone = (Object) map.clone();
        return (Map<String, Integer>) clone;
    }

    public static void main(String[] args) {
        int a=1;
        String s="Ruksad";
        HashMap<String, Integer> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put("one",1);
        integerStringHashMap.put("two",2);
        integerStringHashMap.put("three",3);
        ImmutableClass immutableClass = new ImmutableClass(a, s, integerStringHashMap);
        System.out.println(a == immutableClass.getA());
        System.out.println(s==immutableClass.getName());
        integerStringHashMap.put("four",4);
        System.out.println(integerStringHashMap==immutableClass.getMap());
        System.out.println(immutableClass.getMap());
    }
}
