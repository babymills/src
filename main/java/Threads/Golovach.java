package Threads;
import java.io.StreamTokenizer;
import java.io.StringReader;

import static java.lang.Thread.currentThread;

class ConcurrentCounter {
    public static final int N = 1000_000_000;
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            public void run() {
                for (int k = 0; k < N; k++) counter++;
            }
        });
        t0.start();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int k = 0; k < N; k++) counter++;
            }
        });
        t1.start();

        t0.join();
        t1.join();

        System.out.println(counter);
    }
}

class DeadLock_Demo {
    public static void main(String[] args) throws InterruptedException {
        final Thread[] threads = new Thread[2];
        threads[0] = new Thread(new Runnable() { // thread #0
            public void run() {
                try {
                    System.out.println("#0 join to #1");
                    threads[1].join();
                } catch (InterruptedException ignore) {/*NOP*/}
            }
        });
        threads[1] = new Thread(new Runnable() { // thread #1
            public void run() {
                try {
                    System.out.println("#1 join to #0");
                    threads[0].join();
                } catch (InterruptedException ignore) {/*NOP*/}
            }
        });
        threads[0].start();
        threads[1].start();
    }
}