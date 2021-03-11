package lesson8.part2;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog(Color.WHITE);
        Dog dog2 = new Dog(Color.RED);
        Dog dog3 = new Dog(Color.BLACK);
//        Dog dog5 = new Dog("Зеленая");

        if(dog3.getColor() == Color.BLACK) {
            System.out.println("Наша собака либо с рождения черная, либо она только что вернулась с прогулки");
        }

        switch (dog3.getColor()) {
            case RED -> System.out.println("1");
            case BLACK -> System.out.println("2");
            default -> System.out.println("4");
        }

    }
}
