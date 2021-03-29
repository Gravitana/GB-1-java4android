package lesson13;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {8, 9, 10 ,11, 12, 13};

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i : arr1) {
                    result += i;
                }
                return result;
            }
        };

        Future<Integer> f1 = executorService.submit(callable);
        Future<?> f2 = executorService.submit(() -> {
            int result = 0;
            for (int i : arr2) {
                result += i;
            }
            return result;
        });

        System.out.println(f1.get() + " - " + f2.get());
        executorService.shutdown();
    }
}
