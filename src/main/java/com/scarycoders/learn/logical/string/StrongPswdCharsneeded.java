package com.scarycoders.learn.logical.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sample Input 0
 *
 * 3
 * Ab1
 * Sample Output 0
 *
 * 3
 * Explanation 0
 *
 * She can make the password strong by adding  characters, for example, $hk, turning the password into Ab1$hk which is strong.
 *
 *  characters aren't enough since the length must be at least .
 *
 * Sample Input 1
 *
 * 11
 * #HackerRank
 * Sample Output 1
 *
 * 1
 * Explanation 1
 *
 * The password isn't strong, but she can make it strong by adding a single digit.
 */
public class StrongPswdCharsneeded {

  static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
    int count=0;
    Pattern patternDigit=Pattern.compile("(\\d)");
    Pattern patternUpperCase=Pattern.compile("[A-Z]");
    Pattern patternLowerCase=Pattern.compile("[a-z]");
    Pattern patternWhiteSpaces=Pattern.compile("(\\W)");

    Matcher mDigit=patternDigit.matcher(password);
    Matcher mUpper=patternUpperCase.matcher(password);
    Matcher mLower=patternLowerCase.matcher(password);
    Matcher mspe=patternWhiteSpaces.matcher(password);

    if(!mDigit.find())
    { count++;}
    if(!mUpper.find()){ count ++;}
    if(!mLower.find()){count ++;}
    if(!mspe.find()){count ++;}
    if(n+count < 6){
      count=6-n;
    }
    return count;
  }
}
