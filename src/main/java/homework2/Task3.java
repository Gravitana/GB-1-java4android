package homework2;

import java.util.Arrays;

public class Task3 {
    /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void main(String[] args){
        int[] data = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        printArray(data);

        for (int i = 0; i < data.length; i++) {
            if (data[i] < 6)
                data[i] *= 2;
        }

        printArray(data);
    }

    private static void printArray(int[] data) {
        for (int n : data) {
            System.out.printf("%3d | ", n);
        }
        System.out.println();
    }
}
