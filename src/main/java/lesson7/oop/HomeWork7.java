package lesson7.oop;

public class HomeWork7 {
    public static void main(String[] args) {
        Cat[] cats = {
            new Cat("Мартин"),
            new Cat("Барсик"),
            new Cat("Мурзик"),
            new Cat("Васька"),
            new Cat("Леопольд"),
            new Cat("Матроскин"),
            new Cat("Бегемот"),
        };

        Plate plate = new Plate(20);

        plate.printInfo();

        feedCats(cats, plate);

        plate.addFood(8);

        plate.printInfo();

        feedCats(cats, plate);
    }

    private static void feedCats(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.printInfo();
            plate.printInfo();
        }
    }
}
