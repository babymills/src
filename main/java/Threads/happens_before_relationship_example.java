package Threads;

/*Следующая программа может как остановиться, так и не остановиться в рамках обеих моделей памяти
(так как в разных потоках происходит захват и освобождение мониторов различных объектов — lockA / lockB)*/

public class happens_before_relationship_example {
    static Object lockA = new Object();
    static Object lockB = new Object();
    static boolean run = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                synchronized (lockA) {
                    run = false;
                }
            }
        }).start();

        while (true) {
            synchronized (lockB) {
                if (!run) break;
            }
        }
    }
}
