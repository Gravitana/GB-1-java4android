package lesson8.part1;

public class Main {

    public static void main(String[] args) {
        Airbus airbus = new Airbus();
        Duck duck = new Duck();
        Cat cat = new Cat();
//        doFly(cat);
//        doFly(airbus);
//        doFly(duck);

        Flying[] flyings = {duck, airbus};
        HomeAnimal[] homeAnimals = {cat, duck};

        cat.action();
        cat.action2();
    }

    private static void doFly(Flying obj) {
        obj.fly();
    }

}
