package util.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a read-only list, also known as a sequence, of elements.
 * 
 * @param <E> the type of elements in this list
 */
public interface ReadOnlyList<E> extends ReadOnlyDeque<E> {
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the first element of this list.
     * 
     * @return the first element of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    default E peek() throws NoSuchElementException {
        return getFirst();
    }

    /**
     * Returns the first element of this list.
     * 
     * @return the first element of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    default E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    /**
     * Returns the last element of this list.
     * 
     * @return the last element of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    default E getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size() - 1);
    }

    @Override
    default Iterator<E> iterator() {
        class ListIterator implements Iterator<E> {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(currentIndex++);
            }

        }

        return new ListIterator();
    }
}