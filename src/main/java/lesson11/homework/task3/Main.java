package lesson11.homework.task3;

public class Main {
    public static void main(String[] args) {

        testCompare();
        System.out.println("=============================================");
        testPour();
    }

    private static void testCompare() {
        Box<Apple> boxWithApples = new Box<>();
        Box<Orange> boxWithOranges = new Box<>();

        boxWithApples.add(new Apple());
        boxWithApples.add(new Apple());
        boxWithApples.add(new Apple());

        boxWithOranges.add(new Orange());
        boxWithOranges.add(new Orange());
//        boxWithOranges.add(new Orange());

        System.out.println("Коробка с яблоками весит " + boxWithApples.getWeight() + "f");
        System.out.println("Коробка с апельсинами весит " + boxWithOranges.getWeight() + "f");
        System.out.println("По весу коробки " + (boxWithApples.compare(boxWithOranges) ? "одинаковые" : "разные"));
    }

    private static void testPour() {
        Box<Apple> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();

        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());

        box2.add(new Apple());

        System.out.println("Первая коробка весит " + box1.getWeight() + "f");
        System.out.println("Вторая коробка весит " + box2.getWeight() + "f");
        System.out.println("Пересыпаем яблоки из первой во вторую");
        box1.pourAllInto(box2);
        System.out.println("Первая коробка весит " + box1.getWeight() + "f");
        System.out.println("Вторая коробка весит " + box2.getWeight() + "f");
    }
}
