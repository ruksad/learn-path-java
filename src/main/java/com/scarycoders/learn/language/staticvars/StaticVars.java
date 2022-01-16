package com.scarycoders.learn.language.staticvars;

public abstract class StaticVars {
    static  int i;

    {
        i=1;
    }
    StaticVars(){
       // i=1;
        //this(2);
        super();
    }
    StaticVars(int j){
      //  i=1;
        this();


    }

    public static void main(String[] args) {

    }
}

//abstract class testing{
//
//}