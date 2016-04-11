package Collections._2_iterator._2_merge;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class MergeIteratorDemo {

    public static void main(String[] args) {
        System.out.print("[] + [] = ");
        merge(empty(), empty());

        System.out.print("[] + [0] = ");
        merge(empty(), asList(0));

        System.out.print("[0] + [] = ");
        merge(asList(0), empty());

        System.out.print("[0] + [0] = ");
        merge(asList(0), asList(0));

        System.out.print("[10, 20, 30] + [15, 25, 35] = ");
        merge(asList(10, 20, 30), asList(15, 25, 35));

        System.out.print("[10, 20, 30] + [50, 60, 70] = ");
        merge(asList(10, 20, 30), asList(50, 60, 70));

        System.out.print("[50, 60, 70] + [10, 20, 30] = ");
        merge(asList(50, 60, 70), asList(10, 20, 30));

        System.out.print("[10, 20, 30] + [] = ");
        merge(asList(10, 20, 30), empty());

        System.out.print("[] + [10, 20, 30] = ");
        merge(empty(), asList(10, 20, 30));
    }

    private static List<Integer> empty() {
        return Arrays.<Integer>asList();
    }

    private static void merge(List<Integer> list0, List<Integer> list1) {
        Iterator<Integer> iterA = list0.iterator();
        Iterator<Integer> iterB = list1.iterator();
        Iterator<Integer> merge = new MergeIterator(iterA, iterB);
        while (merge.hasNext()) {
            System.out.print(" " + merge.next());
        }
        System.out.println();
    }
}
