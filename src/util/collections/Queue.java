package util.collections;

import java.util.NoSuchElementException;

/**
 * An interface that represents a queue of elements.
 * 
 * @param <E> the type of elements in this queue
 */
public interface Queue<E> extends Collection<E>, FirstOut<E> {

    /**
     * Returns the element at the start of this queue.
     * 
     * @return the element at the start of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E getFirst() throws NoSuchElementException;

    /**
     * A subinterface of {@code Queue} that represents a mutable queue of elements.
     * This interface provides methods for modifying the queue.
     * 
     * @param <E> the type of elements in this mutable queue
     */
    interface Mutable<E> extends Queue<E>, FirstOut.Mutable<E>, LastIn<E> {

        /**
         * Adds the specified element to the end of this queue.
         * 
         * @param element the element to add
         */
        void addLast(E element);

        /**
         * Removes and returns the element at the start of this queue.
         * 
         * @return the element at the start of this queue
         * @throws NoSuchElementException if this queue is empty
         */
        E removeFirst() throws NoSuchElementException;
    }
}
