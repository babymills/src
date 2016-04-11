package Collections._2_iterator._1_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class IteratorToISAdapterTest {
    public static void main(String[] args) throws IOException {
        List<Byte> list = new ArrayList<>(256);
        for (int k = 0; k < 256; k++) {
            list.add((byte) (k - 128));
        }
        InputStream is
                = new IteratorToISAdapter(list.iterator());

        int counter = 0;
        int value;
        while ((value = is.read()) != -1) {
            if (!list.get(counter++).equals((byte) value)) {
                throw new AssertionError("is.read() return int:" + value + "/byte" + (byte) value + " but list.get(" + (counter - 1) + ") = " + list.get(counter - 1));
            }
        }
        System.out.println("OK!");
    }
}
