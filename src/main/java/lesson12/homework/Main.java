package lesson12.homework;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        
        testOneThread();
        testTwoThreads();

    }

    private static void testOneThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long s = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long e = System.currentTimeMillis();

        System.out.println("Время выполнения в один поток: " + (e - s) + " мс");
    }

    private static void testTwoThreads() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long s = System.currentTimeMillis();

        float[] a1 = new float[HALF];
        float[] a2 = new float[SIZE - HALF]; // учитываю нечётную длину массива

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, SIZE - HALF);

        new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            synchronized (lock) {
                System.arraycopy(a1, 0, arr, 0, HALF);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
            synchronized (lock) {
                System.arraycopy(a2, 0, arr, HALF, SIZE - HALF);
            }
        }).start();

        long e = System.currentTimeMillis();

        System.out.println("Время выполнения в два потока: " + (e - s) + " мс");

/*
        display(a1);
        display(a2);
        display(arr);
*/

    }

/*
    private static void display(float[] arr) {
        for (float item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
*/

}
