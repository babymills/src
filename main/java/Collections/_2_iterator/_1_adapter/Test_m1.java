package Collections._2_iterator._1_adapter;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

public class Test_m1 {
    public static void main(String[] args) {
        test(new byte[] {-1});
        System.out.print("OK");
    }

    private static void test(byte[] array) {
        testNextWithoutHasNext(array);
        testNextWithManyHasNext(array);
    }

    private static void testNextWithoutHasNext(byte[] expected) {
        Iterator<Byte> iter
                = new ISToIteratorAdapter(new ByteArrayInputStream(expected));

        Utils.checkEquals(-1, iter.next());
        Utils.checkHasNextFalse(iter, 3);
        Utils.checkNextThrow(iter);
        Utils.checkRemoveThrow(iter);
    }

    private static void testNextWithManyHasNext(byte[] expected) {
        Iterator<Byte> iter
                = new ISToIteratorAdapter(new ByteArrayInputStream(expected));

        Utils.checkHasNextTrue(iter, 3);
        Utils.checkEquals(-1, iter.next());
        Utils.checkHasNextFalse(iter, 3);
        Utils.checkNextThrow(iter);
        Utils.checkRemoveThrow(iter);
    }
}
