package lesson10.homework;

public class TestPhoneBook {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Яковлев", "+7 (351) 222-22-22");
        phoneBook.addContact("Сидоров", "+7 (351) 345-67-89");
        phoneBook.addContact("Иванов", "+7 (351) 999-99-99");
        phoneBook.addContact("Иванов", "+7 (351) 111-11-11");
        phoneBook.addContact("Петров", "+7 (351) 234-56-78");
        phoneBook.addContact("Иванов", "+7 (351) 111-11-11"); // добавляю дубль

        phoneBook.printAll();
    }

}
