package lesson11.homework;

import java.util.ArrayList;
import java.util.Collections;

public class MyArrayList<E> extends ArrayList<E> {

    ArrayList<E> arrayList = new ArrayList<>();

    public MyArrayList(E[] array) {
        Collections.addAll(arrayList, array);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : arrayList) {
            s.append(item).append(", ");
        }
        return s.toString();
    }
}
