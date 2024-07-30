package util;

public interface Sequence<T> extends ReadonlySequence<T> {

    void set(int index, T item) throws IndexOutOfBoundsException;

    void insert(int index, T item) throws IndexOutOfBoundsException;

    void insertAll(int index, Iterable<T> items) throws IndexOutOfBoundsException;

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
    
}