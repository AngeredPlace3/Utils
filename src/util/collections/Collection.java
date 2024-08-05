package util.collections;

/**
 * Represents a collection of elements.
 * 
 * @param <E> the type of elements in this collection
 */
public interface Collection<E> extends ReadOnlyCollection<E> {
    /**
     * Adds an element to this collection.
     * 
     * @param element the element to add
     * @return {@code true} if this collection changed as a result of the call,
     *         {@code false} otherwise
     */
    boolean add(E element);

    /**
     * Removes an element from this collection.
     * 
     * @param element the element to remove
     * @return {@code true} if this collection changed as a result of the call,
     *         {@code false} otherwise
     */
    boolean remove(E element);

    /**
     * Removes all elements from this collection.
     */
    void clear();
}