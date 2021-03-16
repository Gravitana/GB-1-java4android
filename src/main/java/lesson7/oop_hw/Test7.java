package lesson7.oop_hw;

import java.util.Random;

public class Test7 {

    public static final int PLATE_SIZE = 3;
    public static final Random random = new Random();
    private static final FoodObserved foodObserver = FoodObserved.getInstance();
    //Singleton

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < PLATE_SIZE; i++) {
            foodObserver.addPlate(new Plate());
        }

        Cat cat1 = new Cat("Мартин");
        Cat cat2 = new Cat("Шава");
        Cat cat3 = new Cat("Котик");
        Cat cat4 = new Cat("Борис Николаевич");
        Cat cat5 = new Cat("Мурзик");

        foodObserver.addCat(cat1);
        foodObserver.addCat(cat2);
        foodObserver.addCat(cat3);
        foodObserver.addCat(cat4);
//        foodObserver.addCat(cat5);
        cat5.eat();
        int foodCount;

        while (true) {
            System.out.println("Настал новый день! Пора кормить котов");
            foodCount = random.nextInt(16);
            System.out.printf("Добавлено %s еды%n", foodCount);
            foodObserver.addFood(foodCount);

            foodObserver.catsInfo();
            foodObserver.platesInfo();

            System.out.println();
            System.out.println("Наступила ночь");
            randomCatHungry();
            System.out.println("------\n");
            Thread.sleep(7000);
        }
    }

    private static void randomCatHungry() throws InterruptedException {
        for (Cat cat : foodObserver.cats) {
            cat.randomAppetite();
        }

    }
}
