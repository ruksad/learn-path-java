package com.scarycoders.learn.java.evolution;

import java.io.IOException;

public class FeatureDriver {
    public static void main(String[] args) throws IOException {
        FileFeatures.writeToFileNewJava11("Hi ruksad \nhow are you \ni am learning new java features");
        FileFeatures.readFromFileJava11("ruksad.txt");
    }


}
