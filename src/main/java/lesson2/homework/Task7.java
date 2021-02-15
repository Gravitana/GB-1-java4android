package lesson2.homework;

public class Task7 {
    /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций.
        Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static void main(String[] args){
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = -2;

        printArray(data);

        System.out.println("Step = " + n);

        shiftArray(data, n);

        printArray(data);
    }

    private static void shiftArray(int[] data, int n) {

        for (int loop = 1; loop <= Math.abs(n); loop++) {
            if (n > 0)
            {
                int last = data[data.length - 1];

                for (int i = data.length - 1; i > 0; i--) {
                    data[i] = data[i - 1];
                }
                data[0] = last;
            } else if (n < 0) {
                int first = data[0];

                for (int i = 0; i < data.length - 1; i++) {
                    data[i] = data[i + 1];
                }
                data[data.length - 1] = first;
            }
        }
    }

    private static void printArray(int[] data) {
        for (int n : data) {
            System.out.printf(" %2d,", n);
        }
        System.out.println();
    }
}
