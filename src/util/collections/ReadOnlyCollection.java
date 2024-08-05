package util.collections;

import java.util.Objects;

/**
 * Represents a read-only collection of elements.
 * 
 * @param <E> the type of elements in this collection
 */
public interface ReadOnlyCollection<E> extends Iterable<E> {
    /**
     * Returns the number of elements in this collection.
     * 
     * @return the number of elements in this collection
     */
    int size();

    /**
     * Checks if this collection contains the specified element.
     * 
     * @param element the element to search for
     * @return {@code true} if this collection contains the specified element,
     *         {@code false} otherwise
     */
    default boolean contains(E element) {
        for (E e : this) {
            if (Objects.equals(element, e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this collection contains all of the elements in the specified
     * iterable.
     * 
     * @param iterable the iterable to search for
     * @return {@code true} if this collection contains all of the elements in
     *         the specified iterable, {@code false} otherwise
     */
    default boolean containsAll(Iterable<? extends E> iterable) {
        for (E element : iterable) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if this collection contains any of the elements in the specified
     * iterable.
     * 
     * @param iterable the iterable to search for
     * @return {@code true} if this collection contains any of the elements in
     *         the specified iterable, {@code false} otherwise
     */
    default boolean containsAny(Iterable<? extends E> iterable) {
        for (E element : iterable) {
            if (contains(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this collection is empty.
     * 
     * @return {@code true} if this collection is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the maximum capacity of this collection.
     * 
     * @return the maximum capacity of this collection, if this collection is
     *         unbounded, {@code Integer.MAX_VALUE}
     */
    default int maxCapacity() {
        return Integer.MAX_VALUE;
    }

}