package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator;

import java.util.Arrays;

public enum IteratorType {
    FRIENDS("friends"),COWORKERS("coworkers");
    private final String string;
    IteratorType(String value){
        this.string=value;
    }
    public String getString(){
        return this.string;
    }

    public static IteratorType valueOfStr(String str){
        return Arrays.stream(IteratorType.values()).filter(x->x.getString().equals(str)).findFirst().orElseThrow();
    }
}
