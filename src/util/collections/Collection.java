package util.collections;

import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A generic interface that represents a collection of elements. 
 *
 * @param <E> the type of elements in this collection
 */
public interface Collection<E> extends Iterable<E> {

    /**
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    int size();

    /**
     * Returns {@code true} if this collection contains no elements.
     *
     * @return {@code true} if this collection contains no elements, {@code false}
     *         otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns {@code true} if this collection contains the specified element.
     * 
     * @param value the element whose presence in this collection is to be tested
     * @return {@code true} if this collection contains the specified element
     */
    default boolean contains(Object value) {
        return stream().anyMatch(Predicate.isEqual(value));
    }

    /**
     * Returns a sequential {@code Stream} with this collection as its source.
     *
     * @return a sequential {@code Stream} over the elements in this collection
     */
    default Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * A subinterface of {@code Collection} that represents a mutable collection of
     * elements. This interface provides methods for modifying the collection.
     *
     * @param <E> the type of elements in this mutable collection
     * 
     * @see Collection
     */
    interface Mutable<E> extends Collection<E> {

        /**
         * Adds the specified element to this collection.
         *
         * @param value the element to be added to this collection
         * @return {@code true} if this collection was modified as a result of this
         *         operation, {@code false} otherwise
         */
        boolean add(E value);

        /**
         * Removes a single instance of the specified element from this collection, if
         * it is present.
         *
         * @param value the element to be removed from this collection, if present
         * @return {@code true} if an element was removed as a result of this operation,
         *         {@code false} otherwise
         */
        boolean remove(E value);

        /**
         * Removes all elements from this collection. The collection will be empty after
         * this method returns.
         */
        default void clear() {
            removeIf(e -> true);
        }

        /**
         * Retains only the elements in this collection that are accepted by the
         * specified predicate.
         *
         * @param predicate a predicate which returns {@code true} for elements to be
         *                  retained
         * @return {@code true} if this collection was modified as a result of this
         *         operation, {@code false} otherwise
         */
        default boolean retainIf(Predicate<? super E> predicate) {
            boolean changed = false;
            for (E e : this) {
                if (!predicate.test(e)) {
                    remove(e);
                    changed = true;
                }
            }
            return changed;
        }

        /**
         * Removes all elements from this collection that satisfy the given predicate.
         *
         * @param predicate a predicate which returns {@code true} for elements to be
         *                  removed
         * @return {@code true} if this collection was modified as a result of this
         *         operation, {@code false} otherwise
         */
        default boolean removeIf(Predicate<? super E> predicate) {
            return retainIf(predicate.negate());
        }

    }
}
