package examples;

public class App20_NewObjectWaitWithMonitor {
    public static void main(String[] args) throws InterruptedException {
        Object ref = new Object();
        synchronized (ref){
            ref.wait(2000);
          //  ref.notify();
        }
    }
}
