package Collections._2_iterator._2_merge;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Collections.emptyIterator;

public class Test_0_10 {

    public static void main(String[] args) {
        final int[] counter0 = {0};
        Iterator<Integer> iter0 = new Iterator<Integer>() {
            public boolean hasNext() {
                return counter0[0] < 10;
            }

            public Integer next() {
                if (counter0[0]++ < 10) {
                    return 1000;
                } else {
                    throw new NoSuchElementException();
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        MergeIterator merge = new MergeIterator(emptyIterator(), iter0);

        Utils.checkHasNextTrue(merge, 3);
        if (counter0[0] > 1) {
            throw new AssertionError();
        }
        merge.next();
        Utils.checkHasNextTrue(merge, 3);
        if (counter0[0] > 2) {
            throw new AssertionError();
        }
        merge.next();
        Utils.checkHasNextTrue(merge, 3);
        if (counter0[0] > 3) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
