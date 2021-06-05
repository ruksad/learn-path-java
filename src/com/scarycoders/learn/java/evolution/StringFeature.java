package com.scarycoders.learn.java.evolution;

import java.util.stream.Stream;

public class StringFeature {
    /**
     * will check for white spaces
     * @param string
     * @return
     */
    public static boolean isBlank(String string){
        return string.isBlank();
    }

    /**
     * removes unicode white space its unicode aware
     * @param string
     * @return
     */
    public static String string(String string){
        return string.strip();
    }

    public static String repeat(String string){
        return string.repeat(5);
    }

    public static Stream<String> stringsByLine(String string){
        return string.lines();
    }

    public static String indent(String value,int indent){
        return "value";
    }
}
