package lesson10.homework;

import java.text.MessageFormat;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;

public class PhoneBook {
    private static Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<>();
    }

    public void addContact(String surname, String number) {
        Set<String> phones = getNumbers(surname);
        phones.add(number);
        phoneBook.put(surname, phones);
    }

    private Set<String> getNumbers(String surname) {
        return phoneBook.getOrDefault(surname, new LinkedHashSet<>());
    }

    public void printAll() {
        phoneBook.forEach((surname, numbers) -> System.out.println(MessageFormat.format("{0}: {1}", surname, implodeNumbers(numbers) )));
    }

    private String implodeNumbers(Set<String> numbers) {
        StringBuilder phones = new StringBuilder();
        for (String number: numbers) {
            phones.append(number).append(", ");
        }
        return phones.toString();
    }
}
