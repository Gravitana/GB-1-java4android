package lesson14.annotation.main;

public class Cat {
    @MyAnnotation(priority = 3)
    public static int age = 5;

    @MyAnnotation
    public static void doWork() {

    }
}
