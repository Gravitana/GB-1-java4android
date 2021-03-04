package lesson7.oop;

import java.util.Random;

public class Cat {
    private String name;
    private Random random = new Random();
    private int appetite;
    private boolean satiety = false;

    public Cat(String name) {
        this.name = name;
        this.appetite = random.nextInt(9) + 3;
    }

    public void eat(Plate plate) {
        if (satiety) {
            System.out.println("Кот " + name + " уже сыт");
        } else if (plate.decreaseFood(appetite)) {
            System.out.println("Кот " + name + " съел " + appetite);
            satiety = true;
        } else {
            System.out.println("Еды не хватило! Нужно " + appetite);
        }
    }

    public void printInfo() {
        System.out.printf("Кот %s — %s%n", name, (satiety ? "сытый" : "голодный"));
    }

}
