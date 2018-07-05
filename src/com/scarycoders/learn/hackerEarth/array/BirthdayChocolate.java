package com.scarycoders.learn.hackerEarth.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BirthdayChocolate {

    static int solve(int[] s, int d, int m) {

        int total_ways = 0;

            for (int i = 0; i <= (s.length - m); i++) {
                int sum = 0;
                for (int j = i; j < (m + i); j++) {
                    if((s[j] == d && m==s.length) ||(s[j]!=d))
                        sum += s[j];
                    if (sum == d ) {
                        total_ways += 1;
                    }
                }
            }
        return total_ways;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] s = new int[n];

        String[] sItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sItems[i]);
            s[i] = sItem;
        }

        String[] dm = scanner.nextLine().split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);*/

        int[] p = {1 ,2 ,1, 3 ,2};
        int result = solve(p, 3, 2);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
