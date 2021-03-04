package lesson7.string;

import java.io.*;

public class StringConcat {

    public static void main(String[] args) throws IOException {
        String a1 = "Hello My ";
        String a2 = "Dear World";
        String a3 = a1 + a2;
        a3 = a1.concat(a2);

        String b1 = "Число";
        int b2 = 10;
        String b3 = b1 + b2;
        b3 = b1.concat(String.valueOf(b2));

        String c = "(" + 2 + 3 + ")" + b3 + "!";

        for (char ch : b1.toCharArray()) {
            System.out.print(ch + " ");
        }

        for (String s : a3.split("\s+")) {
            System.out.println(s);
        }

        System.out.println(a1.equals(a2));
        System.out.println(a1.compareTo(a2));


        String space = "                           ";
        System.out.println(space == null);
        System.out.println(space.isEmpty());
        System.out.println(space.isBlank());

        System.out.println(space.trim().isEmpty());

        System.out.println(a3.substring(8));
        System.out.println(a3.substring(7, 16));

        System.out.println(a3.replaceAll("My", "Our"));

        System.out.println(a3.indexOf(' '));
        System.out.println(a3.charAt(16));

        System.out.println(a3.startsWith("Hello"));



    }
}
