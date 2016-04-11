package Collections._2_iterator._1_adapter;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

public class Test_m128_127 {
    public static void main(String[] args) {
        byte[] array = new byte[256];
        for (int k = 0; k < 256; k++) {
            array[k] = (byte) (k - 128);
        }
        test(array);
        System.out.print("OK");
    }

    private static void test(byte[] array) {
        testNextWithoutHasNext(array);
        testNextWithManyHasNext(array);
    }

    private static void testNextWithoutHasNext(byte[] expected) {
        Iterator<Byte> iter
                = new ISToIteratorAdapter(new ByteArrayInputStream(expected));

        for (int k = -128; k < 128; k++) {
            Utils.checkEquals(k, iter.next());
        }

        Utils.checkHasNextFalse(iter, 3);
        Utils.checkNextThrow(iter);
        Utils.checkRemoveThrow(iter);
    }

    private static void testNextWithManyHasNext(byte[] expected) {
        Iterator<Byte> iter
                = new ISToIteratorAdapter(new ByteArrayInputStream(expected));

        for (int k = -128; k < 128; k++) {
            Utils.checkHasNextTrue(iter, 3);
            Utils.checkEquals(k, iter.next());
        }

        Utils.checkHasNextFalse(iter, 3);
        Utils.checkNextThrow(iter);
        Utils.checkRemoveThrow(iter);
    }
}
