package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Sequence<T> extends ReadonlyCollection<T> {
    T get(int index);

    @Override
    default Iterator<T> iterator() {
        class ListIterator implements Iterator<T> {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }

        }

        return new ListIterator();
    }
}
