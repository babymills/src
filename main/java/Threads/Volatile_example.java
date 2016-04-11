package Threads;

public class Volatile_example {
    // depends on volatile - program may stop or not stop
    // and read the old or a new data
    static /*volatile*/ int data = 0;
    static /*volatile */boolean run = true;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                data = 1;
                run = false;
            }
        }).start();

        while (run) {/*NOP*/};
        System.out.println(data);
    }
}