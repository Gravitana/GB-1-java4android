package lesson6.homework;

public class Dog extends Animal {

    private static int count;

    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
