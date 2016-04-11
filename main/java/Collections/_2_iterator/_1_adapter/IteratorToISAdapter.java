package Collections._2_iterator._1_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class IteratorToISAdapter extends InputStream {
    private final Iterator<Byte> iterator;

    public IteratorToISAdapter(Iterator<Byte> iterator) {
        this.iterator = iterator;
    }

    @Override
    public int read() throws IOException {
        return (iterator.hasNext()) ? (iterator.next() & 0xFF) : -1;
    }
}
