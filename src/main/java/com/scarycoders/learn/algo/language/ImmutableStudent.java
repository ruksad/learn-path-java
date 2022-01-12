package com.scarycoders.learn.algo.language;

import com.scarycoders.learn.language.functionalInterface.Student;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *1. The class must be declared as final so that child classes can’t be created.
 *2. Data members in the class must be declared private so that direct access is not allowed.
 *3. Data members in the class must be declared as final so that we can’t change the value of it after object creation.
 *4. A parameterized constructor should initialize all
 *  the fields performing a deep copy so that data members can’t be modified with an object reference.
 *5. Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference
 *6. No setters
 */
public final class ImmutableStudent {
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    private ImmutableStudent(String name, int regNo, Map<String, String> metadata) {
        this.name = name;
        this.regNo = regNo;
        HashMap<String, String> stringMap = new HashMap<>();
        Set<Map.Entry<String,String>> entrySet=metadata.entrySet();
        for(Map.Entry<String,String> me:entrySet){
            stringMap.put(me.getKey(),me.getKey());
        }
        this.metadata=stringMap;
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public Map<String, String> getMetadata() {
        HashMap<String, String> stringMap = new HashMap<>();
        Set<Map.Entry<String,String>> entrySet=this.metadata.entrySet();
        for(Map.Entry<String,String> me:entrySet){
            stringMap.put(me.getKey(),me.getKey());
        }
        return stringMap;
    }

    public static void main(String[] args) {
        ImmutableStudent ruksad = new ImmutableStudent("Ruksad", 101, Collections.emptyMap());
    }
}
