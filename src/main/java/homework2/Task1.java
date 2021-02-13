package homework2;

import java.util.Arrays;

public class Task1 {
    /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void main(String[] args){
        int[] data = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println(Arrays.toString(data));

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] == 1 ? 0 : 1;
        }

        System.out.println(Arrays.toString(data));
    }
}
