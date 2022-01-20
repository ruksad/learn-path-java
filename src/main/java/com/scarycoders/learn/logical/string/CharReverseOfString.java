package com.scarycoders.learn.logical.string;

/**
 * Given a string S, consisting only of english alphabets,
 * replace all the alphabets with the alphabets occurring at the same position when counted in reverse order of alphabets.
 * For example, 'a' would be replaced by 'z', 'b' by 'y', 'c' by 'x' and so on.
 * Any capital letters would be replaced by capital letters only.
 */
public class CharReverseOfString {
    public static String reverseCharInString(String s){
        if(s.isEmpty() || s.isBlank()){
            return "";
        }
        StringBuilder sbr=new StringBuilder(s.length());
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>=65 && c<=90){
                c= (char) (90-((int)c-65));
            }else if(c>=97&&c<=122){
                c= (char) (122-((int)c-97));
            }
            sbr.append(c);
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseCharInString("Hello"));
    }
}
