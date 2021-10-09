package com.scarycoders.learn.dataStructure.arrays

import spock.lang.Specification

class DynamicArrayTest extends Specification {
    def "Add"() {
        given:
            def dynamicArray=new DynamicArray(5);
        when:
            dynamicArray.add("ruksad");
        then:
        dynamicArray.size()==1;

    }

    def "Add to overflow the capacity"() {
        given:
        def dynamicArray=new DynamicArray(3);
        dynamicArray.add("ruksad");
        dynamicArray.add("ruksad1")
        when :
        dynamicArray.add("Siddiqui");
        then:
        dynamicArray.getCapacity()==6;

    }

    def "AddAt  0"() {
        given:
        def dynamicArray=new DynamicArray(5);
        dynamicArray.add("mohammad");
        dynamicArray.add("ruksad");
        when:
        dynamicArray.addAt(0,"ruksad1")
        then:
        dynamicArray[0].equals("ruksad1")
    }

    def "AddAt  1"() {
        given:
        def dynamicArray=new DynamicArray(5);
        dynamicArray.add("mohammad");
        dynamicArray.add("ruksad");
        when:
        dynamicArray.addAt(1,"ruksad")
        then:

        dynamicArray[0].equals("mohammad");
        dynamicArray[1].equals("ruksad");
    }

    def "AddAt  10 negative scenario"() {
        given:
        def dynamicArray=new DynamicArray(5);
        dynamicArray.add("mohammad");
        dynamicArray.add("ruksad");
        when:
        dynamicArray.addAt(10,"siddiqui")
        then:
        dynamicArray[2].equals("siddiqui");
    }

    def "Remove"() {
        given:
        def dynamicTest=new DynamicArray(5);
        dynamicTest.add("Ruksad");
        dynamicTest.add("siddiqui");
        dynamicTest.add("Derric");
        dynamicTest.add("kennan");
        when:
        dynamicTest.remove("Derric");
        then:
        dynamicTest[2].equals("kennan");
    }

    def "RemoveAt"() {
        given:
        def dynamicTest=new DynamicArray(5);
        dynamicTest.add("Ruksad");
        dynamicTest.add("siddiqui");
        dynamicTest.add("Derric");
        dynamicTest.add("kennan");
        when:
        dynamicTest.removeAt(0);
        then:
        dynamicTest[2].equals("kennan");
    }
}
