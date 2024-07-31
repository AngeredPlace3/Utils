package util;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> extends List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private T[] items;
    private int size;
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        ensureCapacity(capacity);
    }

    @Override
    public void insertAll(Iterable<T> items, int index) throws IndexOutOfBoundsException {
        if (items instanceof ReadonlyCollection col) {
            ensureCapacity(col.count() + count());
        } else if (items instanceof java.util.Collection col) {
            ensureCapacity(col.size() + count());
        }
        super.insertAll(items, index);
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return items[index];
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public void insert(T item, int index) throws IndexOutOfBoundsException {
        ensureCapacity(size + 1);
        Objects.checkIndex(index, size + 1);
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size);
        T item = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        size--;
        return item;
    }

    @Override
    public T set(int index, T item) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size);
        T old = items[index];
        items[index] = item;
        return old;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity) {
        if (items == null) {
            items = (T[]) new Object[capacity];
        }
        if (capacity > items.length) {
            int newCapacity = (int) (items.length * (1 + DEFAULT_LOAD_FACTOR));
            if (newCapacity < capacity) {
                newCapacity = capacity;
            }
            items = Arrays.copyOf(items, newCapacity);
        }
    }

    public static int getDefaultCapacity() {
        return DEFAULT_CAPACITY;
    }

    public static float getDefaultLoadFactor() {
        return DEFAULT_LOAD_FACTOR;
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(float loadFactor) {
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Load factor must be positive");
        }
        this.loadFactor = loadFactor;
    }
}
