package util;

import java.util.Iterator;

public interface ReadonlySequence<T> extends ReadonlyCollection<T> {
    T get(int index) throws IndexOutOfBoundsException;

    @Override
    default Iterator<T> iterator() {

        class SequenceIterator implements Iterator<T> {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count();
            }

            @Override
            public T next() {
                return get(index++);
            }
        }

        return new SequenceIterator();
    }
}
