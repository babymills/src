package Collections._2_iterator._1_adapter;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

public class Test_0 {
    public static void main(String[] args) {
        test(new byte[0]);
        System.out.print("OK");
    }

    private static void test(byte[] array) {
        testNextWithoutHasNext(array);
        testNextWithManyHasNext(array);
    }

    private static void testNextWithoutHasNext(byte[] expected) {
        Iterator<Byte> iter
                = new ISToIteratorAdapter(new ByteArrayInputStream(expected));

        Utils.checkNextThrow(iter);
        Utils.checkRemoveThrow(iter);
    }

    private static void testNextWithManyHasNext(byte[] expected) {
        Iterator<Byte> iter
                = new ISToIteratorAdapter(new ByteArrayInputStream(expected));

        Utils.checkHasNextFalse(iter, 3);
        Utils.checkNextThrow(iter);
        Utils.checkRemoveThrow(iter);
    }
}
