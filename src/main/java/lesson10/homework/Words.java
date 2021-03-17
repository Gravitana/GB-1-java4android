package lesson10.homework;

import java.text.MessageFormat;
import java.util.*;

public class Words {
    public static void main(String[] args) {
        final int size = 20;
        String[] basicWords = {"найти", "и", "вывести", "список", "уникальных", "слов", "из", "которых", "состоит", "массив", "дубликаты", "не", "считаем"};
        String[] basicArray = new String[size];

        fillArray(basicArray, basicWords);

        System.out.println("Исходный массив:");
        printArray(basicArray);
        System.out.println();

        System.out.println("Уникальные слова:");
        printCollection(getUniqueWords(basicArray));
        System.out.println();


        System.out.println("Количество повторений:");
        printRepeatable(getRepeatable(basicArray));
        System.out.println();

    }

    private static void fillArray(String[] someArray, String[] basicWords) {
        Random rand = new Random();
        for (int i = 0; i < someArray.length; i++) {
            someArray[i] = basicWords[rand.nextInt(basicWords.length)];
        }
    }

    private static void printArray(String[] someArray) {
        for (String string: someArray) {
            System.out.print(string + ", ");
        }
        System.out.println();
    }

    private static Collection<String> getUniqueWords(String[] basicArray) {
        Set<String> uniqueWords = new HashSet<>();
        Collections.addAll(uniqueWords, basicArray);
        return uniqueWords;
    }

    private static void printCollection(Collection<String> collection) {
        for (String string: collection) {
            System.out.print(string + ", ");
        }
        System.out.println();
    }

    private static void printRepeatable(Map<String, Integer> repeatableWords) {
        repeatableWords.forEach((key, value) -> System.out.println(MessageFormat.format("{0}: {1}", key, repeatableWords.get(key))));
    }

    private static Map<String, Integer> getRepeatable(String[] someArray) {
        Map<String, Integer> repeatableWords = new TreeMap<>();
        for (String string: someArray) {
            int count = repeatableWords.getOrDefault(string, 0);
            repeatableWords.put(string, ++count);
        }
        return repeatableWords;
    }
}

