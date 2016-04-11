package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class get_first_mean_last {
    public static void main(String[] args) {
        ArrayList<Integer> AL= new ArrayList<>();
        LinkedList<Integer> LL= new LinkedList<>();
        Random r = new Random();

        // fill
        for (int i=0;i < 1_000_000;i++){
            AL.add(i, r.nextInt(1000));
            LL.add(i, r.nextInt(1000));
        }

         /**/
        System.out.println("get First:");
        long t0 = System.nanoTime();
        AL.get(0);
        long t1 = System.nanoTime();
        System.out.println("AL " +(t1-t0));

        long tt0 = System.nanoTime();
//        LL.getFirst();
        LL.get(0);
        long tt1 = System.nanoTime();
        System.out.println("LL " + (tt1-tt0));

        System.out.println();

        /**/

        System.out.println("get Mean:");
        long getMean0 = System.nanoTime();
        AL.get(AL.size() / 2);
        long getMean1 = System.nanoTime();
        System.out.println("AL " + (getMean1 - getMean0));

        long getMean00 = System.nanoTime();
        LL.get(LL.size() / 2);
        long getMean11 = System.nanoTime();
        System.out.println("LL " + (getMean11-getMean00));

        System.out.println();

                 /**/
        System.out.println("get Last:");
        long getLast0 = System.nanoTime();
        AL.get(AL.size()-1);
        long getLast1 = System.nanoTime();
        System.out.println("AL " +(getLast1-getLast0));

        long getLast00 = System.nanoTime();
//        LL.getLast();
        LL.get(LL.size()-1);
        long getLast11 = System.nanoTime();
        System.out.println("LL " + (getLast11-getLast00));
    }
}
