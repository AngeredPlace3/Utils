package util;

import java.util.Iterator;
import java.util.StringJoiner;

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

    default ReadonlySequence<T> sub(int start, int end) throws IndexOutOfBoundsException {
        if (start < 0 || end > count() || start > end) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d]", start, end));
        }
        class ReadonlySubSequence implements ReadonlySequence<T> {

            private final int offset = start;
            private final int count = end - offset;

            @Override
            public int count() {
                return count;
            }

            @Override
            public T get(int index) throws IndexOutOfBoundsException {
                if (index < 0 || index >= count) {
                    throw new IndexOutOfBoundsException(
                            String.format("Index %d out of bounds of [0, %d]", index, count));
                }
                return ReadonlySequence.this.get(offset + index);
            }

            @Override
            public String toString() {
                StringJoiner joiner = new StringJoiner(", ", "[", "]");
                for (int i = 0; i < count; i++) {
                    joiner.add(get(i).toString());
                }
                return joiner.toString();
            }

        }

        return new ReadonlySubSequence();
    }
}
