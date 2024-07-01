package lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Java 7 or earlier
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("over Anonymous inner class");
            }
        });

        executorService.submit(() -> System.out.println("simple Expression lambda"));

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Multi Statment, in a lambda");
        });

        Runnable runnable = () -> System.out.println("Lambda assigned to a variable");
        executorService.submit(runnable);

        executorService.shutdown();

    }
}
