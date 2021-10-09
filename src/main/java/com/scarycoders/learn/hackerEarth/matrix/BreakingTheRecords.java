package com.scarycoders.learn.hackerEarth.matrix;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int a[]=new int[2];
        int highest = scores[0];
        int lowest = scores[0];
        int highestScroreBroken = 0, lowestScoreBroken = 0;
        // for (int i = 0; i < scores.length - 1; i++) {

        for(int j=0;j<scores.length-2;j++) {
            if (highest < scores[j+1]) {
                highest = scores[j+1];
                highestScroreBroken += 1;
                a[0] = highestScroreBroken;
            }
            if (lowest > scores[j+1]) {
                lowest = scores[j+1];
                lowestScoreBroken += 1;
                a[1] = lowestScoreBroken;
            }
        }

        // }
        a[0]+=1;
        a[1]+=1;
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
