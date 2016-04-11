package Threads;

public class Threads_Not_Ordered_Example {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    SillyWork();
                    System.out.println("Hello");
                }
            }
        }).start();

        for (int i=0;i<5;i++){
            SillyWork();
            System.out.println("Bye");
        }

    }

    private static void SillyWork() {
        double result=0;
        for (int j=1;j<1_000_000;j++){
           result=Math.sin(j)+Math.cos(j);
        }
    }
}
