package com.scarycoders.learn.logical.string;

import java.io.IOException;
import java.util.Scanner;

public class CamelCaseStringToWords {

  static int camelcase(String s) {

    /*Stream<Character> characterStream = IntStream.range(0, s.toCharArray().length)
        .mapToObj(x -> s.toCharArray()[x]);

    long count = characterStream.filter(x -> Character.isUpperCase(x)).count();
    return new Long(count).intValue()+1;*/

    return s.split("[A-Z]").length;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    int result = camelcase(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();*/
    System.out.println(camelcase("hiHowAreYou"));
  }
}
