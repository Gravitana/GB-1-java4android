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
        return Math.abs(box.getWeight() - getWeight()) < 0.001;
    }
/*
    ----- комментарий преподавателя к сданному ДЗ
    3 задание. В методе compare, Box<?> значит что бокс может быть любого типа.
    Будет работать т.к. другой бокс в принципе создать не получится из-за ограничения Box <E extends Fruit>,
    но лучше явно указать что коробка может быть только с фруктами: compare(Box<? extends Fruit> box)
 */

    public void pourAllInto(Box<E> box) {
        for (E item : items) {
            box.add(item);
        }
        items = new ArrayList<>();
    }

    public void display() {
        for (E item : items) {
            System.out.print(item.getClass().getSimpleName() + " ");
        }
        System.out.println();
    }

    public ArrayList<E> getItems() {
        return items;
    }
}
