package util.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private E[] array;
    private int front;
    private int back;
    private int size;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        ensureCapacity(capacity);
        front = 0;
        back = -1;
        size = 0;
    }

    @Override
    public E peek() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public void enqueue(E element) {
        ensureCapacity(size + 1);
        back ++;
        if (back >= array.length && size != array.length) {
            back = 0;
        }
        array[back] = element;
        size ++;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E element = array[front];
        array[front] = null;
        front ++;
        if (front >= array.length && size != array.length) {
            front = 0;
        }
        size --;
        return element;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (array == null) {
            array = (E[]) new Object[Math.max(1, minCapacity)];
        }
        if (minCapacity > array.length) {
            // * 1.5
            int newCapactiy = Math.max(minCapacity, array.length + (array.length >> 1));
            array = Arrays.copyOf(array, newCapactiy);
        }
    }

    public int getCapacity() {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

}
