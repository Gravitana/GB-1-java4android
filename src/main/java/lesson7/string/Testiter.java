package lesson7.string;

public class Testiter {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6};

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            System.out.print(number + " ");
        }
        System.out.println();

        for (int number : arr) {
            System.out.print(number + " ");
        }
    }
}
