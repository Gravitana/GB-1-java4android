package lesson11.homework.task1;

    /*
        ----- комментарий преподавателя к сданному ДЗ
        1 задание. this.data = (E[]) new Object[size]; не очень безопасно использовать массивы обобщенного типа.
        Рекомендую прочитать небольшую статью по этому поводу https://www.baeldung.com/java-generic-array
     */

public class Main {

    public static void main(String[] args) {
//        genericTest();
    }

/*
    private static void genericTest() {
        GenericStorage<String> stringStorage = new GenericStorage<>(7);

        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");
        stringStorage.add("D");
        stringStorage.add("E");

        stringStorage.display();

        stringStorage.exchange(1, 5);

        stringStorage.display();

        System.out.println("----------------------------------");

        GenericStorage<Integer> integerStorage = new GenericStorage<>(3);

        integerStorage.add(1);
        integerStorage.add(2);
        integerStorage.add(3);
        integerStorage.add(4);
        integerStorage.add(5);

        integerStorage.display();

        integerStorage.exchange(1, 5);

        integerStorage.display();
    }
*/

}
