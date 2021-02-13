package homework2;

public class Task8 {
    /*
        8. Заполнить массив числами по порядку по спирали против часовой стрелки.
     */
    public static void main(String[] args){
        final int SIZE = 7;

        int[][] data = new int[SIZE][SIZE];

        int len = SIZE;

        int num = 0;
        int row = -1;
        int col = 0;
        boolean exit = false;

        while (!exit) {
            for (int loop = 1; loop <= 4; loop++) {
                for (int i = 1; i <= len; i++) {
                    switch (loop) {
                        case 1 -> row++;
                        case 2 -> col++;
                        case 3 -> row--;
                        case 4 -> col--;
                    }
                    data[row][col] = ++num;

                    if (num == SIZE * SIZE) {
                        exit = true;
                        break;
                    }
                }
                if (loop % 2 != 0)
                    len--;
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
