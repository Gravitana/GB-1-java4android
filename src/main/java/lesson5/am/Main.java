package lesson5.am;

public class Main {
    public static void main(String[] args) {

/*
        Cat cat1 = new Cat("Мартин Лютер Кот", "Афрокот", 2);
        Cat cat2 = new Cat("Борис Николаевич", "Бурый");
        Cat cat3 = new Cat("Шава");
        Cat cat4 = new Cat("Вася");

        cat4 = null;
        System.gc(); // позвать сборщик мусора

//        cat1.incAge();
//        cat2.setAge(10);
//        cat3.setAge(-5);

//        cat1.printInfo();
//        cat2.printInfo();
//        cat3.printInfo();

//        cat1.run();
//        cat2.run();

//        Cat[] cats = new Cat[3];
        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.printInfo();
        }

        System.out.println(Cat.getCatsCount());
*/

        /* Домашнее задание */
        Person[] persArray = {
                new Person("Иванов Иван Иванович", "Инженер", "iii@example.com", "+7 (123) 456-78-90", 50000, 50),
                new Person("Петров Пётр Петрович", "Специалист", "ppp@example.com", "+7 (123) 456-78-91", 30000, 30),
                new Person("Горбунков Семён Семёнович", "Старший экономист", "gss@example.com", "+7 (123) 456-78-92", 35000, 47),
                new Person("Бунша Иван Васильевич", "Управдом", "biv@example.com", "+7 (123) 456-78-93", 20000, 45),
                new Person("Бендер Остап Ибрагимович", "Великий комбинатор", "boi@example.com", "+7 (123) 456-78-94", 40000, 27),
        };

        for (Person person : persArray) {
            if (person.age > 40)
                person.printInfo();
        }
    }
}
