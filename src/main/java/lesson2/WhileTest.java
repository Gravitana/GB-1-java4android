package lesson2;

public class WhileTest {

    public static void main(String[] args) {

        int i = 1000;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        do {
            System.out.println(i);
        } while (i < 10);

    }
}
