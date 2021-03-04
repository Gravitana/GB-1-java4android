package lesson7.oop;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat("Martin");
        Plate plate = new Plate(100);


        while (plate.getFood() > 0) {
            cat.eat(plate);
            Thread.sleep(3000);
            plate.printInfo();
            System.out.println();
        }
    }
}