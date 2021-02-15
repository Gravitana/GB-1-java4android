package lesson2.homework;

public class Task4 {
    /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    public static void main(String[] args){
        final int SIZE = 9;

        int[][] data = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ( (i == j) || (i + j == SIZE - 1) )
                    data[i][j] = 1;
            }
        }
        printSquareArray(data);
    }

    private static void printSquareArray(int[][] arr) {
        for (int[] data : arr) {
            for (int n : data) {
                System.out.printf("%3d", n);
            }
            System.out.println();
        }
    }
}
