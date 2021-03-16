package lesson9.homework;

public class MyArraySizeException extends Exception{
    public MyArraySizeException() {
        super("Некорректный размер массива");
    }
}
