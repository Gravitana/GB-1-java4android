package lesson14.test;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.div(-4435, 3454352));
        System.out.println(calculator.add(Integer.MAX_VALUE, 1));
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int add(int a, int b) {
        System.out.println(a + b + ": Ответ");
        return a + b;
    }
}
