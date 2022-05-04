import ru.baROM.pr3.SafeCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test_3_2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        SafeCounter counter = new SafeCounter(10);

        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    counter.inc();
                    System.out.println("Thread 1 data: " + counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    counter.dec();
                    System.out.println("Thread 2 data: " + counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();

    }
}
