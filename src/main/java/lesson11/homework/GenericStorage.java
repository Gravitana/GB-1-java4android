package lesson11.homework;

public class GenericStorage<E> {
    private E[] data;
    private int currentSize ;

    public GenericStorage(int size) {
        this.data = (E[]) new Object[size];
    }

    public void add(E value) {
        add(value, currentSize);
    }

    public void add(E value, int index) {
        if (checkBorders(currentSize)) {
            data[index] = value;
            currentSize++;
        } else {
            System.out.println("Массив переполнен");
        }
    }

    private boolean checkBorders(int n) {
        return n >= 0 && n < data.length;
    }

    public void display() {
        for (E item : data) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public void exchange(int i, int j) {
        if (checkBorders(i) && checkBorders(j)) {
            E temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        } else {
            System.out.println("Выход за пределы массива");
        }
    }
}
