package util.collections;

import java.util.NoSuchElementException;

/**
 * An interface that represents a stack of elements.
 * 
 * @param <T> the type of elements in this stack
 */
public interface Stack<T> extends FirstOut<T> {

    /**
     * Returns the element at the top of this stack.
     * 
     * @return the element at the top of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    T getFirst() throws NoSuchElementException;

    /**
     * A subinterface of {@code Stack} that represents a mutable stack of elements.
     * This interface provides methods for modifying the stack.
     * 
     * @param <T> the type of elements in this mutable stack
     */
    interface Mutable<T> extends Stack<T>, FirstOut.Mutable<T>, FirstIn<T> {

        /**
         * Adds the specified element to the top of this stack.
         * 
         * @param element the element to add
         */
        void addFirst(T element);

        /**
         * Removes and returns the element at the top of this stack.
         * 
         * @return the element at the top of this stack
         * @throws NoSuchElementException if this stack is empty
         */
        T removeFirst() throws NoSuchElementException;
    }

}
