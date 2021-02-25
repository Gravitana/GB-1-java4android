package lesson6;

public class Duck extends Animal {
    public Duck(String name, String color, int age) {
        super(name, color, age);
    }

    public Duck(String name) {
        super(name);
    }

    @Override
    public void voice() {
        System.out.println("Кря");
    }

    public void fly() {
        System.out.println("Лечу");
    }
}
















