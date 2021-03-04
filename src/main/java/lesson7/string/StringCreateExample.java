package lesson7.string;

import java.nio.charset.StandardCharsets;

public class StringCreateExample {

    public static void main(String[] args){
        String s1 = "Java".toString();
        String s11 = null;
        String s2 = new String("Java");

        String s3 = new String(new char[] {'A', 'B', 'C'});
        String s4 = new String(String.valueOf(s11));


        String s5 = new String(new byte[] {65, 66, 67});
        String s6 = new String(new byte[] {0, 65, 0, 66}, StandardCharsets.UTF_16);
        System.out.printf(" s1 = %s%n s2 = %s%n s3 = %s%n s4 = %s%n s5 = %s%n s6 = %s", s1, s2, s3, s4, s5, s6);


    }
}