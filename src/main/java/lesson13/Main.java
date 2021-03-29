package lesson13;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//        testFixedExecutor(); // Ограниченное количество потоков
//        testScheduledExecutor(); // Запуск потока через определённый промежуток времени
        testCollections();
    }

    private static void testFixedExecutor() {
        ExecutorService pool = Executors.newFixedThreadPool(3, r -> {
            System.out.println("New Thread!");
            return new Thread(r);
        });

        for (int i = 0; i < 40; i++) {
            int k = i;
            pool.execute(() -> System.out.println(Thread.currentThread().getName() + " - " + k));
        }

        pool.shutdown();
//        pool.awaitTermination(1000, TimeUnit.MILLISECONDS); // завершить через определённый промежуток времени
    }

    private static void testScheduledExecutor() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            System.out.println(new Date() + " start");
            try {
//                Thread.sleep(new Random().nextInt(3000));
                Thread.sleep(new Random().nextInt(3000) + 4000); // если увеличить время выполения (+ 4000), то время запуска может сдвинуться (> 5 сек)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " end");
        }, 0, 5000, TimeUnit.MILLISECONDS); //  0 - начинаем без задержки и каждые 5 секунд снова запускаем действие
    }

    private static void testCollections() {
        Map<String, String> hm = Collections.synchronizedMap(new HashMap<>()); // при обычном способе (Collections), при обращении к элементу блокируется вся коллекция

        Map<String, String> chm = new ConcurrentHashMap<>(); // при использовании ConcurrentHashMap, блокируется только тот элемент, к которому идёт обращение
    }
}
