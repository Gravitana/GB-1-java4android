package lesson11.homework.task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testInteger();
        testString();
    }

    private static void testInteger() {
        Integer[] integers = new Integer[]{1,2,3,4};

        ArrayList<Integer> myArrayList = new MyArrayList<>(integers);

        System.out.println(myArrayList.toString());
    }

    private static void testString() {
        String[] strings = new String[]{"A","B","C","D","E","F"};

        ArrayList<String> myArrayList = new MyArrayList<>(strings);

        System.out.println(myArrayList.toString());
    }

}
