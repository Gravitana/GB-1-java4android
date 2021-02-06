package lesson1;

public class HomeWork {
    public static void main(String[] args) {
        int a = 10;
        double b = 9.94;
        int c = 12;
        int d = 5;

        String name = "Андроид";
//        int year = 2020; // високосный
        int year = 1900; // нет

        System.out.println("----- 2 -----");
        testVars();
        System.out.println("----- 3 -----");
        calc(a, b, c, d);
        System.out.println("----- 4 -----");
        testSum(a, b);
        System.out.println("----- 5 и 6 -----");
        positiveOrNegative(a);
        System.out.println("----- 7 -----");
        hello(name);
        System.out.println("----- 8* -----");
        testLeapYear(year);
    }

    /*
        2. Создать переменные всех пройденных типов данных, и инициализировать их значения
     */
    private static void testVars() {
        int varInt;
        double varDouble;
        char varChar;
        boolean varBoolean;

        varInt = 10;
        varDouble = 15.89;
        varChar = 9749; // код в таблице символов == цифровая часть HTML-кода
        varBoolean = true;

        System.out.println("varInt: " + varInt);
        System.out.println("varDouble: " + varDouble);
        System.out.println("varChar: " + varChar);
        System.out.println("varBoolean: " + varBoolean);

        /* ------ Доработка ------ */
        byte varByte = 127;
        short varShort = 32767;
        long varLong = 9223372036854775807L;
        float varFloat = 3.4e+38F;
        String varString = "Строковый набор символов";
    }

    /*
        3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода
     */
    private static void calc(int a, double b, int c, int d) {
        double result = a * (b + ((double)c / d));
        System.out.println("Результат " + a + "*(" + b + "+(" + c + "/" + d + ")): " + result);
    }

    /*
        Вывод результата для 4-го задания
     */
    private static void testSum(int a, double b) {
        boolean result = testDiapasone(a, b);
        System.out.println("Cумма (" + a + " + " + b + ") лежит в пределах от 10 до 20 (включительно)?");

        if (result) {
            System.out.println("- Да");
        }
        else {
            System.out.println("- Нет");
        }
    }

    /*
        4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
        если да – вернуть true, в противном случае – false
     */
    private static boolean testDiapasone(int a, double b) {
        double sum = a + b;
        return sum >= 10.0 & sum <= 20.0;
    }

    /*
        5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
        положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом.
     */
    private static void positiveOrNegative(int a) {
        if (testNegative(a)) {
            System.out.println("Число " + a + " – отрицательное");
        }
        else {
            System.out.println("Число " + a + " – положительное");
        }
    }

    /*
        6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное.
     */
    private static boolean testNegative(int a) {
        return a < 0;
    }

    /*
        7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        метод должен вывести в консоль сообщение «Привет, указанное_имя!»
     */
    private static void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /*
        8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
        Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    private static void testLeapYear(int year) {
//        year = 1700; // нет
//        year = 2000; // високосный
//        year = 2020; // високосный
//        year = 2021; // нет

//        if (year % 400 == 0) {
//            System.out.println(year + " год – високосный!");
//        }
//        else if (year % 100 == 0) {
//            System.out.println(year + " год не является високосным");
//        }
//        else if (year % 4 == 0) {
//            System.out.println(year + " год – високосный!");
//        }
        /* ------ Доработка ------ */
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Год високосный.");
        }
        /* ----------------------- */
        else {
            System.out.println(year + " год не является високосным");
        }

    }
}
