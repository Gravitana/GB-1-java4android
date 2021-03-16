package lesson9.homework;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws MyArraySizeException {
        int standardArraySize = 4;
        int maxStringLength = 6;

        int size = 4;
//        int size = 6;

        var chars = "0123456789".toCharArray();
//        var chars = "0123456789abc@#$".toCharArray();

        String[][] myArray = new String[size][size];

        fillArray(myArray, chars, maxStringLength);

        printArray(myArray);

        arrayProcessing(myArray, standardArraySize);

    }

    private static void fillArray(String[][] myArray, char[] chars, int maxStringLength) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = generateRandomString(chars, maxStringLength);
            }
        }
    }

    private static String generateRandomString(char[] chars, int maxLength) {
        Random rand = new Random();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i <= rand.nextInt(maxLength); i++) {
            string.append(chars[rand.nextInt(chars.length)]);
        }
        return string.toString();
    }

    private static void printArray(String[][] someArray) {
        for (String[] strings : someArray) {
            for (String string : strings) {
                System.out.print(string + " ");
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
