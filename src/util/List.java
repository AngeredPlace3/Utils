package util;

import java.util.Objects;
import java.util.StringJoiner;

public abstract class List<T> implements Sequence<T> {

    public abstract void insert(T item, int index) throws IndexOutOfBoundsException;

    public void insertAll(Iterable<T> items, int index) throws IndexOutOfBoundsException {
        for (T item : items) {
            insert(item, index++);
        }
    }

    public void prepend(T item) {
        insert(item, 0);
    }

    public void prependAll(Iterable<T> items) {
        insertAll(items, 0);
    }

    public void append(T item) {
        insert(item, count());
    }

    public void appendAll(Iterable<T> items) {
        insertAll(items, count());
    }

    public abstract T remove(int index) throws IndexOutOfBoundsException;

    public abstract T set(int index, T item) throws IndexOutOfBoundsException;

    public List<T> sub(int from, int to) throws IndexOutOfBoundsException {
        class SubList extends List<T> {
            private int index;
            private int size;

            public SubList() {
                index = from;
                size = to - from;
            }

            @Override
            public int count() {
                return size;
            }

            @Override
            public T get(int index) throws IndexOutOfBoundsException {
                Objects.checkIndex(index, size);
                return List.this.get(this.index + index);
            }

            @Override
            public void insert(T item, int index) throws IndexOutOfBoundsException {
                Objects.checkIndex(index, size + 1);
                size++;
                List.this.insert(item, this.index + index);
            }

            @Override
            public T remove(int index) throws IndexOutOfBoundsException {
                Objects.checkIndex(index, size);
                size--;
                return List.this.remove(this.index + index);
            }

            @Override
            public T set(int index, T item) throws IndexOutOfBoundsException {
                Objects.checkIndex(index, size);
                return List.this.set(this.index + index, item);
            }
        }
        return new SubList();
    }

    public void clear() {
        while (!isEmpty()) {
            remove(0);
        }
    }

    public void swap(int index1, int index2) throws IndexOutOfBoundsException {
        T temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < count(); i++) {
            joiner.add(Objects.toString(get(i)));
        }
        return joiner.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List<?> other) {
            if (count() != other.count()) {
                return false;
            }
            for (int i = 0; i < count(); i++) {
                if (!get(i).equals(other.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
