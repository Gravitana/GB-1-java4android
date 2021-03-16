package lesson9.homework;

public class MyArrayDataException extends Exception{
    public MyArrayDataException() {
        super("Некорректное значение элемента массива");
    }

    public MyArrayDataException(int i, int j) {
        super("Некорректное значение элемента массива в ячейке [" + i + "][" + j +"]");
    }
}
