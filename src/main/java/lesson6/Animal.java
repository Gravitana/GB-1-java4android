package lesson6;

public abstract class Animal {

    protected String name;
    protected String color;
    private int age;

    public Animal(String name, String color, int age) {
        this.name = name.toUpperCase();
        this.color = color;
        this.age = age;

        System.out.printf("Я родился! Меня зовут %s%n", name);
    }

    public Animal(String name) {
        this(name, "Серобуромалиновое", 0);
    }

    @Override
    public String toString() {
        return "Имя животного: " + name + ", цвет: " + color + ", возраст: " + age;
    }

    void run() {
        System.out.println("Животное бежит");
    }

    public abstract void voice();

    void printInfo() {
        System.out.println(this.toString());
    }
}
















