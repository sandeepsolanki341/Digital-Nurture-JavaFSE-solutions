package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Exercise 41 — ExecutorService and Callable
public class ExecutorCallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int n = i;
            Callable<Integer> task = () -> n * n;   // returns square
            futures.add(pool.submit(task));
        }

        for (int i = 0; i < futures.size(); i++) {
            System.out.println("Square of " + (i + 1) + " = " + futures.get(i).get());
        }
        pool.shutdown();
    }
}
