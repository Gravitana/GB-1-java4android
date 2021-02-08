package lesson2;

public class ForTest {
    public static void main(String[] args) {
/*        int i = 0;
        for(; i < 10; i++ ) {
            System.out.println(i);
        }

        System.out.println("Final i: " + i);*/

        for (int i = 20; i > 0 ; i--) {

            if (i == 9) {
                break;
            }

            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }

/*        for (;;) {

        }*/
    }
}
