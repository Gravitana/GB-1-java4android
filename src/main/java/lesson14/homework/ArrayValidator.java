package lesson14.homework;

import java.util.ArrayList;
import java.util.Random;

public class ArrayValidator {
    /*
        3. Написать метод, который проверяет состав массива из чисел 1 и 4.
           Если в нем нет хоть одной четверки или единицы, то метод вернет false;
           Написать набор тестов для этого метода (по 3-4 варианта входных данных).
            [ 1 1 1 4 4 1 4 4 ] -> true
            [ 1 1 1 1 1 1 ] -> false
            [ 4 4 4 4 ] -> false
            [ 1 4 4 1 1 4 3 ] -> false
     */

    public static void main(String[] args) {
        ArrayValidator arrayValidator = new ArrayValidator();
        Random random = new Random();

        ArrayList<Integer> integers = new ArrayList<>();
        int size = random.nextInt(5) + 3;

        for (int i = 0; i < size; i++) {
            boolean isOne = random.nextBoolean();
            integers.add(0, isOne ? 1 : 4);
        }

        System.out.println(integers);

        if (arrayValidator.has1and4(integers))
            System.out.println("Массив содержит 1 и 4");
        else
            System.out.println("В массиве нет числа 1 или 4");
    }

    public boolean has1and4(ArrayList<Integer> numbers) {
        boolean has1 = false;
        boolean has4 = false;

        for (Integer number : numbers) {
            if (number == 1) {
                has1 = true;
            } else if (number == 4) {
                has4 = true;
            } else {
                return false;
            }
        }

        return has1 && has4;
    }

}
