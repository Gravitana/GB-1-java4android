package homework2;

import java.util.Random;

public class Task5 {
    /*
        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public static void main(String[] args){
        final int SIZE = 10;
        final int MIN = -15;
        final int MAX = 99;

        int[] data = new int[SIZE];

        /* Заполнение массива случайными значениями */

        Random rand = new Random();

        for (int i = 0; i < SIZE; i++) {
            data[i] = rand.nextInt(MAX - MIN + 1) + MIN;
        }
        printArray(data);

        /* Поиск экстремумов */

        int max = data[0];
        int min = data[0];

        for (int i = 1; i < SIZE; i++) {
            if (data[i] < min)
                min = data[i];

            if (data[i] > max)
                max = data[i];
        }

        System.out.printf(" minimum = %d%n maximum = %d%n", min, max);
    }

    private static void printArray(int[] data) {
        for (int n : data) {
            System.out.printf(" %d,", n);
        }
        System.out.println();
    }
}
