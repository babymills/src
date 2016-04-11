package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class contains {
    public static void main(String[] args) {
        ArrayList<Integer> AL= new ArrayList<>();
        LinkedList<Integer> LL= new LinkedList<>();
        Random r = new Random();

        // fill
        for (int i=0;i<1_000_000;i++){
            AL.add(i, r.nextInt(1000));
            LL.add(i, r.nextInt(1000));
        }
         /**/

        Integer elem=Integer.valueOf(1_000_000);      // такого элемента нет

        /*O(1) лучший случаи для АL*/
        System.out.println("contains: " + ((AL.contains(elem)) && LL.contains(elem)));
        long t0 = System.nanoTime();
        AL.contains(elem);
        long t1 = System.nanoTime();
        System.out.println("AL " + (t1 - t0));

        /*O(N) худший случаи для LL*/
        long tt0 = System.nanoTime();
        LL.contains(elem);
        long tt1 = System.nanoTime();
        System.out.println("LL " + (tt1 - tt0));

        System.out.println();
        // добавляем такой элемент

        AL.add(250_000, elem);
        LL.add(250_000,elem);

        System.out.println("contains: " + ((AL.contains(elem)) && LL.contains(elem)));
        long cont0 = System.nanoTime();
        AL.contains(elem);
        long cont1 = System.nanoTime();
        System.out.println("AL " +(cont1-cont0));

        long cont00 = System.nanoTime();
        LL.contains(elem);
        long cont11 = System.nanoTime();
        System.out.println("LL " + (cont11-cont00));

        System.out.println();
        System.out.println("size:");
        System.out.println(AL.size());
        System.out.println(LL.size());
    }
}
