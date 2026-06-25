package concurrency;

// Exercise 26 — Thread Creation
class PrinterThread extends Thread {
    private final String label;
    PrinterThread(String label) { this.label = label; }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(label + " - line " + i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        PrinterThread t1 = new PrinterThread("Thread-A");
        PrinterThread t2 = new PrinterThread("Thread-B");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Both threads finished.");
    }
}
