package lesson9;

public class CatOffException extends Exception {
    public CatOffException() {
        super("Котам здесь не рады!");
    }

    public CatOffException(int i) {
        super(String.format("Кот прокрался под номером %d%n на вечеринку домашних животных", i));
    }
}
