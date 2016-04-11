package Collections._2_iterator._1_adapter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Utils {

    public static void checkHasNextFalse(Iterator<?> iter, int count) {
        for (int k = 0; k < count; k++) {
            if (iter.hasNext()) {
                throw new AssertionError();
            }
        }
    }

    public static void checkHasNextTrue(Iterator<?> iter, int count) {
        for (int k = 0; k < count; k++) {
            if (!iter.hasNext()) {
                throw new AssertionError();
            }
        }
    }

    public static void checkNextEquals(Iterator<Integer> iter, int value) {
        if (iter.next() != value) {
            throw new AssertionError();
        }
    }

    public static void checkEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError();
        }
    }

    public static void checkNextThrow(Iterator<?> iter) {
        try {
            iter.next();
            throw new AssertionError();
        } catch (NoSuchElementException e) {/*NOP*/}
    }

    public static void checkRemoveThrow(Iterator<?> iter) {
        try {
            iter.remove();
            throw new AssertionError();
        } catch (UnsupportedOperationException e) {/*NOP*/}
    }
}
