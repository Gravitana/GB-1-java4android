package lesson9;

import lesson8.part1.Cat;
import lesson8.part1.Dog;
import lesson8.part1.Duck;
import lesson8.part1.HomeAnimal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Exception e =  new ArithmeticException("Мы что-то сломали");
        System.out.println(e.getMessage());
        System.out.println(e.getCause());
        throw e;*/

//        foo();
//        bar();
//        scannerException();
/*        System.out.println(baz(6, 2));
        System.out.println(baz(6, 0));*/

/*        try {
            readFile("src/main/resources/1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет!!!");
        }*/

        runAnimals();
    }

    private static void foo() {
        try {
            System.out.println(5 / 0);
            System.out.println(5 / 1);
            System.out.println(5 / 2);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("Код завершен");
    }

    private static void bar() {
        int[] arr = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] arrDividers = {2, 4, 0, 4, 0, 1};

        try {
            doCycleFor(arr, arrDividers);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Выход за пределы массива!");
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void doCycleFor(int[] arr, int[] arrDividers) {
        for (int i = 0; i < arr.length; i++) {
            try {
                divideNumber(arr, arrDividers, i);
            } catch (ArithmeticException e) {
                arr[i] = -1;
                System.err.println("Делить на ноль нельзя! Индекс: " + i);
            }
        }
    }

    private static void divideNumber(int[] arr, int[] arrDividers, int i) {
        arr[i] /= arrDividers[i];
    }


    private static void scannerException() {
        int c;
        int n;

        try (Scanner scanner = new Scanner(System.in)) {
            c = Integer.parseInt(scanner.next());
            n = scanner.nextInt();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            c = 0;
        }

        System.out.println("Продолжение...");
    }


    private static int baz(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return 1;
        } finally {
            return -1;
        }
    }

    private static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
    }

    private static void runAnimals() {
/*
        HomeAnimal[] animals = {new Dog(), new Cat(), new Duck()};
        int i = 0;
        for (HomeAnimal animal : animals) {
            try {
                if (animal instanceof Cat) {
                    throw new CatOffException(i);
                }
            } catch (CatOffException e) {
                e.printStackTrace();
            }
            animal.action();
            i++;
        }
*/

    }
}
