package lesson8.part1;

public interface Run {
    void run();
    default void action2() {
        System.out.println("экшн два из ран");
    }

    default void action() {
        System.out.println("экшн из ран");
    }
}
