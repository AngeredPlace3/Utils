package util;

import java.util.StringJoiner;

public interface Sequence<T> extends ReadonlySequence<T> {

    void set(int index, T item) throws IndexOutOfBoundsException;

    void insert(int index, T item) throws IndexOutOfBoundsException;

    default void insertAll(int index, Iterable<T> items) throws IndexOutOfBoundsException {
        for (T item : items) {
            insert(index++, item);
        }
    }

    default void prependAll(Iterable<T> items) {
        insertAll(0, items);
    }

    default void appendAll(Iterable<T> items) {
        insertAll(count(), items);
    }

    default void prepend(T item) {
        insert(0, item);
    }

    default void append(T item) {
        insert(count(), item);
    }

    T remove(int index) throws IndexOutOfBoundsException;

    default void clear() {
        while (!isEmpty()) {
            remove(0);
        }
    }

    default Sequence<T> sub(int start, int end) throws IndexOutOfBoundsException {

        if (start < 0 || end > count() || start > end) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d]", start, end));
        }
        class SubSequence implements Sequence<T> {

            private final int offset = start;
            private int count = end - offset;

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
                return Sequence.this.get(offset + index);
            }

            @Override
            public void set(int index, T item) throws IndexOutOfBoundsException {
                if (index < 0 || index >= count) {
                    throw new IndexOutOfBoundsException(
                            String.format("Index %d out of bounds of [0, %d]", index, count));
                }
                Sequence.this.set(offset + index, item);
            }

            @Override
            public void insert(int index, T item) throws IndexOutOfBoundsException {
                if (index < 0 || index > count) {
                    throw new IndexOutOfBoundsException(
                            String.format("Index %d out of bounds of [0, %d]", index, count));
                }
                count++;
                Sequence.this.insert(offset + index, item);
            }

            @Override
            public T remove(int index) throws IndexOutOfBoundsException {
                if (index < 0 || index >= count) {
                    throw new IndexOutOfBoundsException(
                            String.format("Index %d out of bounds of [0, %d]", index, count));
                }
                count--;
                return Sequence.this.remove(offset + index);
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

        return new SubSequence();
    }

    default void swap(int index1, int index2) throws IndexOutOfBoundsException {
        T temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
    }

}