package util.collection;

;

public abstract class List<T> extends Sequence<T> {

    public abstract void set(int index, T value) throws IndexOutOfBoundsException;

    public abstract void insert(int index, T value) throws IndexOutOfBoundsException;

    public void insertAll(int index, Iterable<T> values) {
        for (T value : values) {
            insert(index++, value);
        }
    }

    public void prepend(T value) {
        insert(0, value);
    }

    public void prependAll(Iterable<T> values) {
        insertAll(0, values);
    }

    public void append(T value) {
        insert(getSize(), value);
    }

    public void appendAll(Iterable<T> values) {
        insertAll(getSize(), values);
    }

    public abstract T remove(int index) throws IndexOutOfBoundsException;

    public void clear() {
        for (int i = 0; i < getSize(); i++) {
            remove(0);
        }
    }

}
