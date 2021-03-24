package lesson12;

public class DeadLock {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadThreadOne one = new DeadThreadOne();
        one.start();
        DeadThreadTwo two = new DeadThreadTwo();
        two.start();
    }

    static class DeadThreadOne extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("One держит lock1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("One ждёт lock2...");
                synchronized (lock2) {
                    System.out.println("One держит lock1 и lock2...");
                }
            }
        }
    }

    static class DeadThreadTwo extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Two держит lock2...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Two ждёт lock1...");
                synchronized (lock1) {
                    System.out.println("Two держит lock2 и lock1...");
                }
            }
        }
    }
}
