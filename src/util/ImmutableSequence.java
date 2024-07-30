package util;

public interface ImmutableSequence<T> extends ImmutableCollection<T>, ReadonlySequence<T> {

    ImmutableSequence<T> set(int index, T item) throws IndexOutOfBoundsException;

    ImmutableSequence<T> insert(int index, T item) throws IndexOutOfBoundsException;

    ImmutableSequence<T> insertAll(int index, Iterable<T> items) throws IndexOutOfBoundsException;

    default ImmutableSequence<T> prependAll(Iterable<T> items) {
        return insertAll(0, items);
    }

    default ImmutableSequence<T> appendAll(Iterable<T> items) {
        return insertAll(count(), items);
    }

    default ImmutableSequence<T> prepend(T item) {
        return insert(0, item);
    }

    default ImmutableSequence<T> append(T item) {
        return insert(count(), item);
    }

    ImmutableSequence<T> remove(int index) throws IndexOutOfBoundsException;

    default ImmutableSequence<T> clear() {
        ImmutableSequence<T> sequence = this;
        while (!sequence.isEmpty()) {
            sequence = sequence.remove(0);
        }
        return sequence;
    }
}
