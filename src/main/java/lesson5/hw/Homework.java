package lesson5.hw;

import java.util.Random;

public class Homework {

    /*
        ----- комментарий преподавателя к сданному ДЗ
        Соблюдайте принцип инкапсуляции и делайте поля класса приватными, а доступ к ним получайте через сет и гет методы.
        Публичные поля это как правило статик константы, во всех остальных случаях старайтесь не оставлять публичные поля
        без особой необходимости.
     */

    private static final int EMPLOYEE_COUNT = 5;
    private static final int MIN_AGE = 40;
    private static final Random ageRandomize = new Random();

    public static void main(String[] args) {

        Employee[] employees = new Employee[EMPLOYEE_COUNT];
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            employees[i] = createEmployee(i);
        }

        for (Employee employee : employees) {
            if (employee.getAge() > MIN_AGE) {
                employee.printInfo();
            }
        }
    }

    private static Employee createEmployee(int i) {
        return new Employee(
                "name" + i,
                "surname" + i,
                ageRandomize.nextInt(30) + 30,
                "test" + i + "@test.com",
                "+7920555778" + i,
                "Software Engineer",
                2000 + i * 100);
    }
}
