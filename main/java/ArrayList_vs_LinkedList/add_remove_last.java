package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class add_remove_last {
    public static void main(String[] args) {
        ArrayList<Integer> AL= new ArrayList<>(1_000);
        LinkedList<Integer> LL= new LinkedList<>();
        Random r = new Random();

        // fill
        for (int i=0;i<1_000_000;i++){
            AL.add(i, r.nextInt(1000));
            LL.add(i, r.nextInt(1000));
        }
         /*при выполнения операции удаления последнего элемента - всегда сравнимы*/
        System.out.println("remove Last:");
        long t0 = System.nanoTime();
        AL.remove(1_000_000 - 1);
        long t1 = System.nanoTime();
        System.out.println("AL " +(t1-t0));

        /*O(1) лучший и O(1) худший случаи для LL*/
        long tt0 = System.nanoTime();
//        LL.remove(1_000_000-1);                  // LL по индексу работает медленнее, чем removeLast()
        LL.removeLast();
        long tt1 = System.nanoTime();
        System.out.println("LL " + (tt1-tt0));

        System.out.println();

        /*при выполнения операции вставки(add) последнего элемента - сравнимы, но иногда LL в разы быстрее*/
        /*O(1) лучший и O(N) худший случаи для AL*/
        System.out.println("add Last:");
        long addLast0 = System.nanoTime();
        AL.add(r.nextInt(1000));
//        AL.add(999_999,r.nextInt(1000));
        long addLast1 = System.nanoTime();
        System.out.println("AL " +(addLast1-addLast0));

        /*O(1) лучший и O(N) худший случаи для LL*/
        long addLast00 = System.nanoTime();
//        LL.add(r.nextInt(1000));
        LL.addLast(r.nextInt(1000));
        long addLast11 = System.nanoTime();
        System.out.println("LL " + (addLast11-addLast00));
    }
}
