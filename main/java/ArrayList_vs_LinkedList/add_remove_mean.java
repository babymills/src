package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class add_remove_mean {
    public static void main(String[] args) {
        ArrayList<Integer> AL= new ArrayList<>(1_000);
        LinkedList<Integer> LL= new LinkedList<>();
        Random r = new Random();

        // fill
        for (int i=0;i<1_000_000;i++){
            AL.add(i, r.nextInt(1000));
            LL.add(i, r.nextInt(1000));
        }

         /**/
        System.out.println("remove Mean:");
        long t0 = System.nanoTime();
        AL.remove(AL.size() / 2);
        long t1 = System.nanoTime();
        System.out.println("AL " +(t1-t0));

//        LL.add(500_000,1_000_000);
        long tt0 = System.nanoTime();
        LL.remove(LL.size()/2);
//        LL.remove(1_000_000);
        long tt1 = System.nanoTime();
        System.out.println("LL " + (tt1-tt0));

        System.out.println();

        /**/

        System.out.println("add Mean:");
        long addMean0 = System.nanoTime();
        AL.add(AL.size()/2,r.nextInt(1000));
        long addMean1 = System.nanoTime();
        System.out.println("AL " +(addMean1-addMean0));

        long addMean00 = System.nanoTime();
        LL.add(LL.size()/2,r.nextInt(1000));
        long addMean11 = System.nanoTime();
        System.out.println("LL " + (addMean11-addMean00));

    }
}
