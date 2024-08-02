package util.collections;

import java.util.NoSuchElementException;

/**
 * An interface that represents a deque (also known as a double-ended queue) of
 * elements.
 * 
 * @param <E> the type of elements in this deque
 */
public interface Deque<E> extends Collection<E>, FirstOut<E>, LastOut<E> {

    /**
     * Returns the first element in this deque.
     * 
     * @return the first element in this deque
     */
    E getFirst() throws NoSuchElementException;

    /**
     * Returns the last element in this deque.
     * 
     * @return the last element in this deque
     */
    E getLast() throws NoSuchElementException;

    /**
     * A subinterface of {@code Deque} that represents a mutable deque of elements.
     * This interface provides methods for modifying the deque.
     * 
     * @param <E> the type of elements in this mutable deque
     */
    interface Mutable<E> extends Deque<E>, FirstOut.Mutable<E>, LastOut.Mutable<E>, LastIn<E>, FirstIn<E> {

        /**
         * Adds the specified element to the start of this deque.
         * 
         * @param element the element to add
         */
        void addFirst(E element);

        /**
         * Adds the specified element to the end of this deque.
         * 
         * @param element the element to add
         */
        void addLast(E element);

        /**
         * Removes and returns the first element in this deque.
         * 
         * @return the first element in this deque
         * @throws NoSuchElementException if this deque is empty
         */
        E removeFirst() throws NoSuchElementException;

        /**
         * Removes and returns the last element in this deque.
         * 
         * @return the last element in this deque
         * @throws NoSuchElementException if this deque is empty
         */
        E removeLast() throws NoSuchElementException;

    }

}