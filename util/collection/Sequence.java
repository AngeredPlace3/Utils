package util.collection;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Sequence<T> implements Iterable<T> {
    public abstract int getSize();

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public abstract T get(int index) throws IndexOutOfBoundsException;

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (T value : this) {
            joiner.add(Objects.toString(value));
        }
        return joiner.toString();
    }

    @Override
    public int hashCode() {
        if (this.isEmpty()) {
            return 0;
        }
        final int prime = 31;
        int result = 1;
        for (T value : this) {
            result = prime * result + Objects.hashCode(value);
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Sequence<?> list) {
            if (this.getSize() != list.getSize()) {
                return false;
            }
            for (int i = 0; i < this.getSize(); i++) {
                if (!Objects.equals(this.get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        class SequenceIterator implements Iterator<T> {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < getSize();
            }

            @Override
            public T next() {
                return get(index++);
            }

        }
        return new SequenceIterator();
    }
}
