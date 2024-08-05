package util.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * An implementation of the {@link Stack} interface based on an array.
 * <p>
 * This implementation uses dynamic array resizing and performs O(1) push and
 * pop operations, given no allocation was required.
 * <p>
 * 
 * @param <T> the type of elements in this stack
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int size = 0;
    private int top = -1;

    /**
     * Create an empty stack with the default initial capacity of 10.
     */
    public ArrayStack() {
        this(10);
    }

    /**
     * Create an empty stack with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity
     * @throws IllegalArgumentException if the initial capacity is less than or
     *                                  equal to 0
     */
    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        ensureCapacity(initialCapacity);
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return array[top];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        class StackIterator implements Iterator<T> {
            private int currentIndex = top;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex--];
            }

        }
        return new StackIterator();
    }

    @Override
    public void push(T element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[++top] = element;
        size++;
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Stack underflow");
        }
        size--;
        return array[top--];
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (array == null) {
            array = (T[]) new Object[Math.max(1, minCapacity)];
        }
        if (minCapacity > array.length) {
            // * 1.5
            int newCapactiy = Math.max(minCapacity, array.length + (array.length >> 1));
            array = Arrays.copyOf(array, newCapactiy);
        }
    }

    /**
     * Clears this stack.
     */
    public void clear() {
        size = 0;
        top = -1;
        Arrays.fill(array, null);
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
        for (int i = top; i >= 0; i--) {
            joiner.add(Objects.toString(array[i]));
        }
        return joiner.toString();
    }

}
