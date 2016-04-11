package Collections._2_iterator._1_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ISToIteratorAdapter implements Iterator<Byte> {
    private final InputStream is;
    private int last = -1;

    public ISToIteratorAdapter(InputStream is) {
        this.is = is;
        try {
            this.last = is.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasNext() {
        return last != -1;
    }

    @Override
    public Byte next() {
        try {
            if (last != -1) {
                int tmp = last;
                last = is.read();
                return (byte) tmp;
            } else {
                throw new NoSuchElementException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
