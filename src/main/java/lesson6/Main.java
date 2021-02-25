package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Мартин");
        Dog dog = new Dog("Гендальф", "Серый", 10, true);
        Duck duck = new Duck("Дональд");

//        cat.voice();
//        dog.voice();

//        cat.printInfo();
//        dog.printInfo();

//        duck.fly();

        Animal[] animals = {duck, cat, dog};

        for (Animal animal : animals) {
            animal.printInfo();

            if (animal instanceof Duck) {
                ((Duck) animal).fly();
            }
        }

//        doVoice(duck);


        Object[] objects = {
          new String("String"),
          cat,
          new int[]{1,1,1,1,0},
          new Random()
        };

//        for (int i = 0; i < objects.length; i++) {
//            System.out.println(objects[i].toString());
//        }



    }

    public static void doVoice(Animal animal) {
        animal.voice();
    }






}
















