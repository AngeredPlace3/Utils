package util.collection;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> extends List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float SCALE_FACTOR = 1.5f;

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> of(T... values) {
        ArrayList<T> list = new ArrayList<>();
        for (T value : values) {
            list.append(value);
        }
        return list;
    }

    public static <T> ArrayList<T> of(Iterable<T> values) {
        ArrayList<T> list = new ArrayList<>();
        list.appendAll(values);
        return list;
    }

    private int size;

    private T[] array;

    public ArrayList(int capacity) {
        size = 0;
        ensureCapacity(capacity);
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void set(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        array[index] = value;
    }

    @Override
    public void insert(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) { // shift right
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        T value = array[index];
        for (int i = index; i < size - 1; i++) { // shift left
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        return value;
    }

    @Override
    public void clear() {
        Arrays.fill(array, 0, size, null); // set all elements to null for garbage collection
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        return array[index];
    }

    public int getCapacity() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity) {
        if (array == null) {
            array = (T[]) new Object[capacity];
        } else if (array.length < capacity) {
            int desiredLength = (int) (array.length * SCALE_FACTOR);
            if (desiredLength < capacity) {
                desiredLength = capacity;
            }
            array = Arrays.copyOf(array, desiredLength);
        }
    }

    @Override
    public Iterator<T> iterator() {
        class ArrayListIterator implements Iterator<T> {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        }

        return new ArrayListIterator();
    }

}
