package lesson9.homework;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        int standardArraySize = 4;
        int maxStringLength = 6;

        int arraySize = 4;
//        int arraySize = 6;

        String chars = "0123456789";
//        String chars = "_0123456789";

        String[][] myArray = new String[arraySize][arraySize];

        fillArray(myArray, chars, maxStringLength);

        printArray(myArray);

        checkArray(myArray, standardArraySize);

        System.out.println("Сумма элементов массива равна " + arraySum(myArray));

    }

    private static void fillArray(String[][] myArray, String chars, int maxStringLength) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = generateRandomString(chars, maxStringLength);
            }
        }
    }

    private static String generateRandomString(String chars, int maxLength) {
        Random rand = new Random();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i <= rand.nextInt(maxLength); i++) {
            string.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return string.toString();
    }

    private static void printArray(String[][] someArray) {
        System.out.println();
        for (String[] strings : someArray) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void checkArray(String[][] someArray, int size) throws MyArraySizeException {
        if (someArray.length != size)
            throw new MyArraySizeException();

        System.out.println("Размер массива соответствует эталону");
    }

    private static int arraySum(String[][] someArray) throws MyArrayDataException {
        int sum = 0;

        for (int i = 0; i < someArray.length; i++) {
            for (int j = 0; j < someArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(someArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
