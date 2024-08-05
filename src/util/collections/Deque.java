package util.collections;

import java.util.NoSuchElementException;

/**
 * Represents a deque of elements.
 * <p>
 * Deques are double-ended queues that support both insertion and removal from
 * either end.
 * </p>
 * 
 * @param <E> the type of elements in this deque
 */
public interface Deque<E> extends ReadOnlyDeque<E>, Stack<E>, Queue<E> {

    /**
     * Adds an element to the start of this deque.
     * 
     * @param element the element to add
     */
    void addFirst(E element);

    /**
     * Adds an element to the end of this deque.
     * 
     * @param element the element to add
     */
    void addLast(E element);

    /**
     * Removes and returns the first element of this deque.
     * 
     * @return the first element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeFirst() throws NoSuchElementException; 

    /**
     * Removes and returns the last element of this deque.
     * 
     * @return the last element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeLast() throws NoSuchElementException;
}