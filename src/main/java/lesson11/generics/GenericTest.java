package lesson11.generics;

import lesson11.common.ObjectStorage;
import lesson5.Cat;
import lesson6.Dog;

public class GenericTest {

    public static void main(String[] args) {
        genericTest();
    }

    private static void genericTest() {

        GenericStorage<Integer> intStorage = new GenericStorage<>(5);

        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
//        intStorage.add(3.0);

        intStorage.display();
        System.out.println("Find 2: " + intStorage.find(2));
        int valueLast = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast);

        //=============================

        GenericStorage<String> stringStorage = new GenericStorage<>(5);

        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");
//        stringStorage.add(1);

        stringStorage.display();
        System.out.println("Find 2: " + stringStorage.find("B"));
        String valueLast2 = stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + valueLast2);

//        GenericStorage<Cat> catGenericStorage = new GenericStorage<>(3);

    }


}
