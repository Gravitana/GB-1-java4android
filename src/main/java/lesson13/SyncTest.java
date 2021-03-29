package lesson13;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {
    public static void main(String[] args) throws InterruptedException {

//        semaphoreTest();    // ограничивает количество одновременно выполняющихся потоков
//        cdlTest();          // ждёт, пока не выполнится заданное кол-во потоков, чтобы завершить (исполняется один раз)
//        cbTest();           //  ждёт, пока не выполнится заданное кол-во потоков, чтобы продолжить (исполняется циклично) в разное премя пришли на старт, а потом толпой понеслись
        lockTest();         // альтернатива обычной синхронизации, эффективен только для большого количества потоков
    }

    private static void semaphoreTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 15; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); // понижение значения счётчика каналов (было 3, осталось 2 свободных канала для потоков)
                    System.out.println("Start - " + Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("End - " + Thread.currentThread().getName());
                }
                semaphore.release(); // повышение значения счётчика, т.к. один канал освободился
            });
        }
        executorService.shutdown();
    }

    private static void cdlTest() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3); // задаём величину счётчика потоков, завершения которых будем ждать

        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println("Start - " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("End - " + Thread.currentThread().getName());
                    cdl.countDown();
                }
            }).start();
        }

        cdl.await(); // главный поток будет ждать, пока счётчик не достигнет нуля
        System.out.println("END");
    }

    private static void cbTest() throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            new Thread(() -> {
                System.out.println("Start - " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                    cb.await(); // ждать потоки
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("End - " + Thread.currentThread().getName());
                }
            }).start();
        }
    }

    private static void lockTest() {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            reentrantLock.lock(); // блокируем объект от выполнения другими потоками
            System.out.println("Start - " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End - " + Thread.currentThread().getName());
                reentrantLock.unlock(); // освобождаем объект для доступа
            }
        }).start();

        new Thread(() -> {
            reentrantLock.lock(); // блокируем объект от выполнения другими потоками
            System.out.println("Start - " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End - " + Thread.currentThread().getName());
                reentrantLock.unlock(); // освобождаем объект для доступа
            }
        }).start();
    }
}
