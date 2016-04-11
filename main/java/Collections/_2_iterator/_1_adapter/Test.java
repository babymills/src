package Collections._2_iterator._1_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        byte[] array = new byte[256];
        for (int k = 0; k < 256; k++) {
            array[k] = (byte) (k - 128);
        }
        testDoesntReadTooMuch(array);
    }

    private static void testDoesntReadTooMuch(final byte[] array) {
        final int[] counter = {0};
        Iterator<Byte> iter = new ISToIteratorAdapter(new InputStream() {
            public int read() throws IOException {
                return (counter[0] < array.length) ? 0xFF & array[counter[0]++] : -1;
            }
        });

        if (counter[0] > 1) {
            throw new AssertionError();
        }

        for (int k = 0; k < array.length; k++) {
            iter.next();
            if (counter[0] > k + 2) {
                throw new AssertionError();
            }
        }
    }
}
