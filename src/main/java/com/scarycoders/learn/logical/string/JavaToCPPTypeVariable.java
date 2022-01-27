package com.scarycoders.learn.logical.string;

/**
 * If input is
 * input mohammad_ruksadSiddiqui
 * output mohammadRuksadSiddiqui
 *
 * input mohammadRuksadSiddiqui
 * output mohammad_ruksad_siddiqui
 */
public class JavaToCPPTypeVariable {

    public static String convert(String str){
        StringBuilder sbr=new StringBuilder();
            if(str.contains("_")){
                for(int i=0;i<str.length();i++) {
                   if(str.charAt(i)=='_' && i!=str.length()-1){
                       sbr.append(Character.toUpperCase(str.charAt(i+1)));
                        continue;
                   }
                   sbr.append(str.charAt(i));
                }
            }else {
                for(int i=0;i<str.length();i++) {
                    if(Character.isUpperCase(str.charAt(i))){
                        sbr.append("_"+Character.toLowerCase(str.charAt(i)));
                        continue;
                    }
                    sbr.append(str.charAt(i));
                }
            }

        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("mohammad_ruksadSiddiqui"));
        System.out.println(convert("mohammadRuksadSiddiqui"));
    }
}
