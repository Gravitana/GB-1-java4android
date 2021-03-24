package lesson12;

public class TestSyncBlock {
    private static final int STEPS = 10;
    private static final int DELAY = 500;
    final Object lock;

    public static void main(String[] args) {
        Object o = new Object(); // Этот объект будет являться маркером для синхронизации

        TestSyncBlock testSyncBlock1 = new TestSyncBlock(o);
        TestSyncBlock testSyncBlock2 = new TestSyncBlock(o);

        new Thread(testSyncBlock1::methodA).start();
        new Thread(testSyncBlock2::methodB).start();
    }

    public TestSyncBlock(Object lock) {
        this.lock = lock;
    }

    private void methodA() {
        synchronized (lock) {
            System.out.println("Start A");

            for (int i = 0; i < STEPS; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End A");
        }
    }

    private void methodB() {
        synchronized (lock) {
            System.out.println("Start B");

            for (int i = 0; i < STEPS; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End B");
        }
    }

}
