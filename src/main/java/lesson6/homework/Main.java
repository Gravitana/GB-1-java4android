package lesson6.homework;

public class Main {
    public static void main(String[] args) {

        final int catMaxRunDistance  = 200;
        final int dogMaxRunDistance  = 500;
        final int catMaxSwimDistance = 0;
        final int dogMaxSwimDistance = 10;

        Cat catVaska = new Cat("Васька", catMaxRunDistance, catMaxSwimDistance);
        Dog dogBobik = new Dog("Бобик", dogMaxRunDistance, dogMaxSwimDistance);

        Cat catMurzik = new Cat("Мурзик", catMaxRunDistance, catMaxSwimDistance);
        Dog dogSharik = new Dog("Шарик", dogMaxRunDistance, dogMaxSwimDistance);

        Dog dogTuzik = new Dog("Тузик", dogMaxRunDistance, dogMaxSwimDistance);

        catVaska.run(300);
        dogBobik.run(300);

        catVaska.swim(10);
        dogBobik.swim(10);

        System.out.println();

        catMurzik.run(150);
        dogSharik.run(150);

        catMurzik.swim(20);
        dogSharik.swim(20);

        System.out.println();

        dogTuzik.run(800);
        dogTuzik.swim(800);

        System.out.println();

        System.out.printf("Количество котов: \t%d.\n", Cat.getCount());
        System.out.printf("Количество собак: \t%d.\n", Dog.getCount());
        System.out.printf("Всего животных: \t%d.\n", Animal.getCount());

    }
}
