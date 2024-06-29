package lambda;

import java.util.concurrent.*;

import static java.lang.System.out;

public class Ex1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Java 7 or earlier
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("over Anonymous inner class");
            }
        });

        executorService.submit(() -> System.out.println("simple Expression lambda"));

        Future<String> future = executorService.submit(() -> {
            out.println(Thread.currentThread().getName());
            out.println("Multi Statment, in a lambda");
            return "Result from the Lambda";
        });

        Runnable runnable = () -> out.println("Lambda assigned to a variable");
        executorService.submit(runnable);

        String result = "";
        try {
            result = future.get(5, TimeUnit.SECONDS);
        }catch (TimeoutException|InterruptedException | ExecutionException e) {
            out.println(e.getMessage());
        }
        out.println("Result: " + future.isDone() + " " +  future.isCancelled() + " " +  result);
        executorService.shutdown();


    }
}
