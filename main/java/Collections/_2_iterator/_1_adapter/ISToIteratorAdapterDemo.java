package Collections._2_iterator._1_adapter;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Iterator;

public class ISToIteratorAdapterDemo {
    public static void main(String[] args) {
        test(new byte[0]);
        test(new byte[]{10});
        test(new byte[]{10, 20});
        test(new byte[]{10, 20, 30});
    }

    private static void test(byte[] array) {
        System.out.print(Arrays.toString(array) + " =");
        Iterator<Byte> iter
                = new ISToIteratorAdapter(new ByteArrayInputStream(array));
        while (iter.hasNext()) {
            System.out.print(" " + iter.next());
        }
        System.out.println();
    }
}
