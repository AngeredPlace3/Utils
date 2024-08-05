package util.collections;

import java.util.NoSuchElementException;

/**
 * Represents a read-only deque of elements.
 * <p>
 * Deques are double-ended queues that support both insertion and removal from either end.
 * </p>
 * 
 * @param <E> the type of elements in this deque
 */
public interface ReadOnlyDeque<E> extends ReadOnlyStack<E>, ReadOnlyQueue<E> {

    /**
     * Returns the first element of this deque.
     * 
     * @return the first element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getFirst() throws NoSuchElementException;


    /**
     * Returns the last element of this deque.
     * 
     * @return the last element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getLast() throws NoSuchElementException;
}