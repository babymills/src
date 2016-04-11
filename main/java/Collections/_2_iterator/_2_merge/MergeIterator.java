package Collections._2_iterator._2_merge;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MergeIterator<T extends Comparable<? super T>> implements Iterator<T> {
    private final Iterator<T> iter0;
    private final Iterator<T> iter1;
    private T elem0 = null;
    private T elem1 = null;

    public MergeIterator(Iterator<T> iter0, Iterator<T> iter1) {
        this.iter0 = iter0;
        this.iter1 = iter1;
        if (iter0.hasNext()) {
            elem0 = iter0.next();
        }
        if (iter1.hasNext()) {
            elem1 = iter1.next();
        }
    }

    @Override
    public boolean hasNext() {
        return elem0 != null || elem1 != null;
    }

    @Override
    public T next() {
        if (elem0 != null && elem1 != null) {
            if (elem0.compareTo(elem1) < 0) {
                T result = elem0;
                elem0 = iter0.hasNext() ? iter0.next() : null;
                return result;
            } else {
                T result = elem1;
                elem1 = iter1.hasNext() ? iter1.next() : null;
                return result;
            }
        } else if (elem0 != null) {
            T result = elem0;
            elem0 = iter0.hasNext() ? iter0.next() : null;
            return result;
        } else if (elem1 != null) {
            T result = elem1;
            elem1 = iter1.hasNext() ? iter1.next() : null;
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
