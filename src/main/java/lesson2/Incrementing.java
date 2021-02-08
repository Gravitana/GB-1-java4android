package lesson2;

public class Incrementing {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        int c = 0;
        System.out.println(c++); //0 print(0) ++
        System.out.println(++c); //1 ++ print(2)
        System.out.println(c--); //2 print(2) --
        System.out.println(--c); //1 -- print(0)
        System.out.println(c + 1); //1
        System.out.println(c); //0
    }

    private static void test2() {
        int a = 5;
        int b = 5;

        int resultOne = 2 * ++a;
        int resultTwo = 2 * b++;

        System.out.println(resultOne);
        System.out.println(resultTwo);
    }

    public static void test3 () {
        int c = 1;
//        System.out.println(c++ + c);
//        System.out.println(++c + c);
//        System.out.println(c + c++);
        c += ++c + c;
        System.out.println(c);
    }
}
