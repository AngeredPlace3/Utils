package util.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public final class ArrayDeque<E> implements Deque<E> {

    private E[] array;
    private int front;
    private int back;
    private int size;

    public ArrayDeque() {
        this(10);
    }

    public ArrayDeque(int capacity) {
        ensureCapacity(capacity);
        front = 0;
        back = -1;
        size = 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        front = 0;
        back = -1;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        class QueueIterator implements Iterator<E> {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[(front + i++) % array.length];
            }

        }
        return new QueueIterator();
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (array == null) {
            array = (E[]) new Object[Math.max(1, minCapacity)];
        }
        if (minCapacity > array.length) {
            // * 1.5
            E[] newArray = (E[]) new Object[Math.max(minCapacity, array.length + (array.length >> 1))];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(front + i) % array.length];
            }
            array = newArray;
            front = 0;
            back = size - 1;
        }
    }

    public int getCapacity() {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (E element : this) {
            joiner.add(Objects.toString(element));
        }
        return joiner.toString();
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[front];
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[back];
    }

    @Override
    public void addFirst(E element) {
        ensureCapacity(size + 1);

        front = (front - 1 + array.length) % array.length;
        array[front] = element;
        size++;

    }

    @Override
    public void addLast(E element) {
        ensureCapacity(size + 1);
        back = (back + 1) % array.length;
        array[back] = element;
        size++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E element = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E element = array[back];
        array[back] = null;
        back = (back - 1 + array.length) % array.length;
        size--;
        return element;
    }

}
