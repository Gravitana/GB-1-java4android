package lesson10;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
//        testArrayList();
//        testArrayLinkedList();
//        testSet();
        testMap();
    }

    private static void testArrayList() {

        Random[] randoms = new Random[35];
        ArrayList<Random> arrayList1 = new ArrayList<>(35);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add(1, "D");

        arrayList.remove("B");
        arrayList.remove(1);

        arrayList.trimToSize();

        String[] objects = (String[]) (arrayList.toArray());

        var al1 = new ArrayList<String>(Arrays.asList(objects));
        var al2 = Arrays.asList(objects);
        var al3 = Collections.addAll(new ArrayList<Object>(), objects);

        System.out.println(al3);
    }

    private static void testArrayLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("A");

        linkedList.set(0, "C");

        Collections.sort(linkedList);

        System.out.println(linkedList);
        System.out.println(linkedList.get(1));

    }

    private static void testSet() {
        Set<Integer> set = new TreeSet<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            set.add(random.nextInt(20));
        }

/*        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer n = (Integer) iterator.next();
            System.out.println("Число: " + n);
        }*/

        for (Integer n : set) {
            System.out.println("Число: " + n);
        }

//        System.out.println(set);
    }

    private static void testMap() {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("Russia", "Moscow");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        map.put("Norway", "Oslo");

/*        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", entry.getKey(), entry.getValue()));
        }*/

/*        for (String key : map.keySet()) {
            System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", key, map.get(key)));
        }*/

/*        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", key, map.get(key)));
            }
        });*/

        map.forEach((key, value) -> System.out.println(MessageFormat.format("Страна: {0}, столица: {1}", key, map.get(key))));

//        System.out.println(map);
    }
}
