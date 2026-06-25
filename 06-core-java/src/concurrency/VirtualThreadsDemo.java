package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

// Exercise 40 — Virtual Threads (Java 21)
public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[100_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = Thread.startVirtualThread(counter::incrementAndGet);
        }
        for (Thread t : threads) t.join();

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Completed " + counter.get() + " virtual threads in " + elapsed + " ms");
    }
}
