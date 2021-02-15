package lesson2.homework;

public class Task6 {
    /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят.
     */
    public static void main(String[] args){
        /* Заполнение массива случайными значениями */

//        final int SIZE = 8;
//        final int MIN = -1;
//        final int MAX = 3;
//
//        int[] data = new int[SIZE];
//
//        Random rand = new Random();
//
//        for (int i = 0; i < SIZE; i++) {
//            data[i] = rand.nextInt(MAX - MIN + 1) + MIN;
//        }

        int[] data = new int[]{1,1,1,1,2,6};

        int pos = checkBalance(data);
        printArrayBalance(data, pos);

        if (pos == 0)
            System.out.println("Граница не найдена");
    }

    /* ------ Доработка ------ */
    private static int checkBalance(int[] data) {
        final int MAX_INDEX = data.length - 1;
        int position = 0;

        /* ------ Доработка ------ */
//        for (int i = 1; i < MAX_INDEX; i++) {
        for (int i = 1; i <= MAX_INDEX; i++) {

            int leftSum = data[0];
            int rightSum = data[MAX_INDEX];

            for (int j = 1; j < MAX_INDEX; j++) {
                if (j < i)
                    leftSum += data[j];
                else
                    rightSum += data[j];
            }

            if (leftSum == rightSum) {
                position = i;
                break;
            }
        }
        return position;
    }

    private static void printArrayBalance(int[] data, int position) {
        for (int i = 0; i < data.length; i++) {
            if (position == i && position > 0)
                System.out.print(" || ");

            System.out.printf(" %d, ", data[i]);
        }
        System.out.println();
    }
}
