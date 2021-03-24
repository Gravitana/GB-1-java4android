package lesson11.homework.task4;

import lesson11.homework.task3.Apple;
import lesson11.homework.task3.Box;
import lesson11.homework.task3.Fruit;
import lesson11.homework.task3.Orange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testUnique();
    }

    private static void testUnique() {
        Box<Fruit> fruitBox = new Box<>();

        fruitBox.add(new Apple());
        fruitBox.add(new Apple());
        fruitBox.add(new Orange());
        fruitBox.add(new Apple());
        fruitBox.add(new Orange());

        fruitBox.display();

        Box<Fruit> fruits = getUnique(fruitBox);
        fruits.display();

    }

    private static Box<Fruit> getUnique(Box<Fruit> box) {
        Box<Fruit> fruitsUnique = new Box<>();

        for (Fruit fruit : box.getItems()) {
            boolean unique = true;
            for (Fruit fruitUnique : fruitsUnique.getItems()) {
                if (fruit.getClass().getSimpleName().equals(fruitUnique.getClass().getSimpleName())) {
                    unique = false;
                    break;
                }
            }
            if (unique)
                fruitsUnique.add(fruit);
        }
        return fruitsUnique;
    }
}
