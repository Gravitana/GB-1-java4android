package homework2;

import java.util.Arrays;

public class Task2 {
    /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    public static void main(String[] args){
        final int SIZE = 8;

        int[] data = new int[SIZE];

//        for (int i = 0, n = 0; i < data.length; i++, n += 3) {
//            data[i] = n;
//        }

        /* ------ Доработка ------ */
        for (int i = 0; i < data.length; i++) {
            data[i] = i * 3;
        }

        System.out.println(Arrays.toString(data));
    }
}
