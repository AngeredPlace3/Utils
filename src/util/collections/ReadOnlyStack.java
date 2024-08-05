package util.collections;

import java.util.NoSuchElementException;

/**
 * Represents a first-in-first-out stack of elements.
 * 
 * @param <E> the type of elements in this stack
 */
public interface ReadOnlyStack<E> extends ReadOnlyCollection<E> {
    /**
     * Returns the top element of this stack.
     * 
     * @return the top element of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    E peek() throws NoSuchElementException;
}