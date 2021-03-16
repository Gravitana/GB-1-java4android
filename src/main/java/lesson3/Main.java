package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

//        testString();

/*        int[] arr = {1,0,1,0,1};
        int[] arr2 = testArrayChangeReturn(arr.clone());
        testArrayChangeReturn(arr.clone());
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));*/

        testOverload(3, 4);
        testOverload(4, 5);
        testOverload(2.4, 6.8);
        testOverload(7);
        testOverload(7.4);
        testOverload(new int[]{1,2,3,4,5,6,7});
        testOverload(1,2,3,4,5,6,7,8,9,10,55,5,5,5,5);
        testOverload();

//        testConsoleInput();

        testRandom();
    }

    private static void testString() {
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        System.out.println("str1 == str2 " + str2.equals(str1));
        System.out.println("str1 == str3 " + str3.equals(str1));
    }

    private static void testArrayChange(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] += i;
        }
        System.out.println("method: " + Arrays.toString(arr));
    }

    private static int[] testArrayChangeReturn(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] += i;
        }
        System.out.println("method: " + Arrays.toString(arr));
        return arr;
    }


    private static void testOverload(int a, int b) {
        int multiple = a * b;
        System.out.printf("Произведение чисел: %d * %d = %d(int)%n", a, b, multiple);
    }

    private static void testOverload(double a, double b) {
        double multiple = a * b;
        System.out.printf("Произведение чисел: %.1f * %.1f = %.1f(double)%n", a, b, multiple);
    }

    private static void testOverload(double a) {
        double multiple = a * a;
        System.out.printf("Квадрат числа: %.1f = %.2f(квадрат)%n", a, multiple);
    }

    private static void testOverload(int a) {
        testOverload((double) a);
    }

    private static void testOverload(int... a) {
        int multiple = 1;

        for (int i = 0; i < a.length; i++) {
            multiple *= a[i];
        }
        System.out.printf("Произведение всех чисел: %d%n", multiple);
    }

    private static void testOverload() {
        testOverload(0);
    }


    private static void testConsoleInput() {
/*        Scanner scanner = new Scanner(System.in);
        int a = scanner.hasNextInt() ? scanner.nextInt() : 0;
        if (a == 0) {
            scanner.next();
        }
        int b = scanner.nextInt();

        testOverload(a, b);*/

        var reader = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, " + name);

    }


    private static void testRandom() {

        Random random = new Random();

        int[] data = new int[30];

        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(10);
            data[i] = random.nextInt(8) + 3; //3 - 10
            data[i] = random.nextInt(12) - 5; //-5 - +6

            data[i] = (int) (Math.random() * 10); //0 - 9
            data[i] = (int) (Math.random() * 8) + 3; //3 - 10
            data[i] = (int) (Math.random() * 12) - 5; //-5 - 6
        }

        System.out.println(Arrays.toString(data));
    }
}
