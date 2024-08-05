package util.collections;

public final class ArrayList<E> extends AbstractList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float SCALE_FACTOR = 1.5f;
    private E[] array;
    private int size;

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        ensureCapacity(capacity);
        size = 0;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void insert(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public E set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return oldValue;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (array == null) {
            array = (E[]) new Object[minCapacity];
            return;
        }
        if (minCapacity > array.length) {
            int newCapacity = (int) (array.length * SCALE_FACTOR);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }

}
