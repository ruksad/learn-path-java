package com.scarycoders.learn.java.evolution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileFeatures {

    public static void writeToFileOld(String fileContent){
        try {
            var fileName="ruksad.txt";
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(fileContent);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFileOld(String fileName) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        var line="";
        var stringBuilder=new StringBuilder();
        while((line= bufferedReader.readLine())!=null){
            stringBuilder.append(line).append(System.lineSeparator());
        }
        System.out.print(stringBuilder);
    }

    public static void writeToFileNewJava11(String fileContent) throws IOException {
        Files.writeString(Paths.get("ruksad.txt"),fileContent, StandardOpenOption.CREATE);
    }

    public static void readFromFileJava11(String fileName) throws IOException {
        final String s = Files.readString(Paths.get(fileName));
        System.out.println("Text: "+s);
    }
}
