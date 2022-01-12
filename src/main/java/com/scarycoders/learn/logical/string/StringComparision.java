package com.scarycoders.learn.logical.string;

public class StringComparision {
    public static void main(String[] args) {
        String str1 = "Java";

        String str2 = "Java";

        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode() == str2.hashCode());

        System.out.println("----------------------------------------1");
        str1 = "Java";

        str2 = new String("Java");

        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode() == str2.hashCode());

        System.out.println("----------------------------------------2");

        str1= new String("Java");
        str2= new String ("Java");

        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode() == str2.hashCode());

        System.out.println("----------------------------------------3");

         str1 = "Java";

         str2 = str1.intern();

        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode() == str2.hashCode());

        System.out.println("----------------------------------------4");
         str1 = "Java";

         str2 = str1.intern();

        String str3 = new String("Java");

        System.out.println(str1 == str2);

        System.out.println(str2 == str3);

        System.out.println(str3 == str1);

        System.out.println("----------------------------------------4");
        System.out.println("Java"+1000+2000+3000);
        System.out.println("----------------------------------------5");
        System.out.println(1000+2000+3000+"Java");
        System.out.println("----------------------------------------6");
        System.out.println(7.7+3.3+"Java"+3.3+7.7);
        System.out.println("----------------------------------------7");
        String s1 = new String("JAVA");

        String s2 = new String("JAVA");

        String test1= s1.intern();
        String test2=s2.intern();

        System.out.println(s1 == s2);

        System.out.println(s1.equals(s2));

        System.out.println(s1 == s2.intern());

        System.out.println(s1.intern() == s2.intern());

        System.out.println(s1.intern() == s2);
        System.out.println(test1==test2);
        System.out.println("----------------------------------------8");

        String string = "JAVA";
        string.chars();

        StringBuffer sbuffer = new StringBuffer(string);

        StringBuilder sBuilder = new StringBuilder(string);

        System.out.println(string.equals(sbuffer));

        System.out.println(string.equals(sBuilder));

        System.out.println(sbuffer.equals(sBuilder));

        System.out.println("----------------------------------------9");

        String str = "    ";

        System.out.println(str.isBlank());

        System.out.println(str.isEmpty());

        System.out.println("----------------------------------------------10");
        String[] strings = "Java_Concept_Of_The_Day".split("_", 4);

        for (String s : strings)
        {
            System.out.println(s);
        }

    }
}
