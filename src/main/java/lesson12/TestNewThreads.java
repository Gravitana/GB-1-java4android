package lesson12;

public class TestNewThreads {

    public static void main(String[] args) throws InterruptedException {

/*
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start(); // вызов потока только через start, если через run, то будет однопоточность
        t2.start();
*/
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        t1.start();
        t2.start();

        t1.join(); // Главный поток будет ждать завершения потока, прежде чем вывести надпись "КОНЕЦ!!!"
        t2.join();

        System.out.println("КОНЕЦ!!!");
    }
}
