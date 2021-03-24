package lesson12;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t;
        t = Thread.currentThread();
        t.setName("New name");
        t.setPriority(10);
        System.out.println("пауза");
        Thread.sleep(5000);
        System.out.println(t);
    }
}
