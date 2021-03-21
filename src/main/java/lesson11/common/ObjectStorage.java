package lesson11.common;

public class ObjectStorage {
    private Object[] data;
    private int currentSize ;

    public ObjectStorage(int size) {
        this.data = new Object[size];
    }

    public Object get(int index) {
        return data[index];
    }

    public void add(Object value) {
        add(value, currentSize);
    }

    public void add(Object value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(Object value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (Object datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public void sort() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                Comparable a = (Comparable) data[i];
                Comparable b = (Comparable) data[j];
                if (a.compareTo(b) > 0) {
                    exchange(i, j);
                }
            }
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }

    private void exchange(int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
