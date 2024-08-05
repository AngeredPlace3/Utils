package util.collections;

import java.util.NoSuchElementException;

/**
 * Represents a read-only first-in-first-out queue of elements.
 * 
 * @param <E> the type of elements in this queue
 */
public interface ReadOnlyQueue<E> extends ReadOnlyCollection<E> {
    /**
     * Returns the first element of this queue.
     * 
     * @return the first element of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E peek() throws NoSuchElementException;
}