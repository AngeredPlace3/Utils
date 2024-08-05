package util.interfaces;

import java.util.NoSuchElementException;

/**
 * Represents a last-in-first-out queue of elements.
 */
public interface Queue<E> extends ReadOnlyQueue<E> {
    /**
     * Adds an element to the end of this queue.
     * 
     * @param element the element to add
     */
    void enqueue(E element);

    /**
     * Removes and returns the first element of this queue.
     * 
     * @return the first element of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E dequeue() throws NoSuchElementException;
}