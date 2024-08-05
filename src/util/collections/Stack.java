
package util.collections;

import java.util.NoSuchElementException;

/**
 * Represents a first-in-first-out stack of elements.
 */
public interface Stack<E> extends ReadOnlyStack<E> {
    /**
     * Adds an element to the top of this stack.
     * 
     * @param element the element to add
     */
    void push(E element);

    /**
     * Removes and returns the top element of this stack.
     * 
     * @return the top element of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    E pop() throws NoSuchElementException;
}