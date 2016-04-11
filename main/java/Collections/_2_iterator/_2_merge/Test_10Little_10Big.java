package Collections._2_iterator._2_merge;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test_10Little_10Big {

    public static void main(String[] args) {
        final int[] counter0 = {0};
        Iterator<Integer> iter0 = new Iterator<Integer>() {
            public boolean hasNext() {
                return counter0[0] < 10;
            }

            public Integer next() {
                if (counter0[0]++ < 10) {
                    return 500;
                } else {
                    throw new NoSuchElementException();
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        final int[] counter1 = {0};
        Iterator<Integer> iter1 = new Iterator<Integer>() {
            public boolean hasNext() {
                return counter1[0] < 10;
            }

            public Integer next() {
                if (counter1[0]++ < 10) {
                    return 1000;
                } else {
                    throw new NoSuchElementException();
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        MergeIterator merge = new MergeIterator(iter0, iter1);

        Utils.checkHasNextTrue(merge, 3);
        if (counter0[0] > 1 || counter1[0] > 1) {
            throw new AssertionError();
        }
        merge.next();
        Utils.checkHasNextTrue(merge, 3);
        if (counter0[0] > 2 || counter1[0] > 1) {
            throw new AssertionError();
        }
        merge.next();
        Utils.checkHasNextTrue(merge, 3);
        if (counter0[0] > 3 || counter1[0] > 1) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
