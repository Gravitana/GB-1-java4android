package lesson2;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        final int SIZE = 7;

//        int[] data = new int[SIZE];
        var data = new int[SIZE];

        data[0] = 3;
        data[3] = 5;
        data[4] = 6;

/*        System.out.println(data);

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }*/

        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5,6,7}));

        int[][] deepData = new int[SIZE][SIZE];
        int n = 0;
        for (int i = 0; i < deepData.length; i++) {
            for (int j = 0; j < deepData[i].length; j++) {
                deepData[i][j] = ++n;
            }
        }

        for (int i = 0; i < deepData.length; i++) {
            for (int j = 0; j < deepData[i].length; j++) {
                System.out.printf("%3d", deepData[i][j]);
            }
            System.out.println();
        }


    }
}
