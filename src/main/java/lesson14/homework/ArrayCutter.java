package lesson14.homework;

import java.util.ArrayList;
import java.util.Random;

/*
    1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
       Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
       идущих после последней четверки.
       Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
 */

public class ArrayCutter {
    public static void main(String[] args) {
        ArrayCutter arrayCutter = new ArrayCutter();
        int size = 10;
        int number = 4;
        Random random = new Random();

        ArrayList<Integer> integers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            integers.add(0, random.nextInt(10));
        }
        System.out.println(integers);
        System.out.println(arrayCutter.cutAfterNumber(integers, number));
    }

    public ArrayList<Integer> cutAfterNumber(ArrayList<Integer> input, int number) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean numberExists = false;
        for (int i = input.size() - 1; i >= 0; i--) {
            int current = input.get(i);

            if (current == number) {
                numberExists = true;
                break;
            }
            result.add(0, current);
        }

        if (!numberExists) {
            throw new RuntimeException("Число " + number + " в массиве отсутствует!");
        } else if (result.isEmpty()) {
            throw new RuntimeException("Число " + number + " – последнее в массиве!");
        }
        return result;
    }


}
