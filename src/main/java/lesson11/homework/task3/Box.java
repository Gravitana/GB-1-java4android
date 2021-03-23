package lesson11.homework.task3;

import java.util.ArrayList;

public class Box <E extends Fruit> {
    private ArrayList<E> items = new ArrayList<>();

    public void add(E value) {
        items.add(value);
    }

    public double getWeight() {
        double weight = 0.0;
        for (E item : items) {
            weight += item.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> box) {
        return box.getWeight() - getWeight() < 0.001;
    }

    public void pourAllInto(Box<E> box) {
        for (E item : items) {
            box.add(item);
        }
        items = new ArrayList<>();
    }
}
