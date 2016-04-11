package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class add_remove_first {
    public static void main(String[] args) {
        ArrayList<Integer> AL= new ArrayList<>();
        LinkedList<Integer> LL= new LinkedList<>();
        Random r = new Random();

        // fill
        for (int i=0;i<1_000_000;i++){
            AL.add(i, r.nextInt(1000));
            LL.add(i, r.nextInt(1000));
        }
         /*O(N) лучший и худший для AL*/
        System.out.println("remove First:");
        long t0 = System.nanoTime();
        AL.remove(0);
        long t1 = System.nanoTime();
        System.out.println("AL " +(t1-t0));

        /*O(1) лучший и худший случаи для LL*/
        long tt0 = System.nanoTime();
//        LL.remove(0);                  // LL по индексу работает медленнее, чем removeFirst()
        LL.removeFirst();
        long tt1 = System.nanoTime();
        System.out.println("LL " + (tt1-tt0));

        System.out.println();

        /*O(N) лучший и O(N) худший случаи для АL*/
        System.out.println("add First:");
        long addLast0 = System.nanoTime();
        AL.add(0, r.nextInt(1000));
        long addLast1 = System.nanoTime();
        System.out.println("AL " + (addLast1 - addLast0));

        /*O(1) лучший и худший случаи для LL*/
        long addLast00 = System.nanoTime();
        LL.addFirst(r.nextInt(1000));
//        LL.add(0,r.nextInt(1000));
        long addLast11 = System.nanoTime();
        System.out.println("LL " + (addLast11-addLast00));
    }
}
