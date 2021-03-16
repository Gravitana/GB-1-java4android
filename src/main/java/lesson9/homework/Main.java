package lesson9.homework;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws MyArraySizeException {
        final int etaloneSize = 4;

//        int size = 4;
        int size = 6;

        var chars = "0123456789".toCharArray();
//        var chars = "0123456789abc@#$".toCharArray();

        String[][] myArray = new String[size][size];

        fillArray(chars, myArray);

        printArray(myArray);

        arrayProcessing(myArray, etaloneSize);

    }

    private static void fillArray(char[] chars, String[][] myArray) {
        Random rand = new Random();
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = String.valueOf(chars[rand.nextInt(chars.length)]);
            }
        }
    }

    private static void printArray(String[][] someArray) {
        for (int i = 0; i < someArray.length; i++) {
            for (int j = 0; j < someArray[i].length; j++) {
                System.out.printf("%s", someArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void arrayProcessing(String[][] someArray, int size) throws MyArraySizeException {
        if (someArray.length != size)
            throw new MyArraySizeException();
        else
            System.out.println("Размер массива соответствует");
    }
}
