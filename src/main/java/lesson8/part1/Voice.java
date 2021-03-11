package lesson8.part1;

public interface Voice {
    void voice();
    default void action() {
        System.out.println("экшн из войс");
    }
}
