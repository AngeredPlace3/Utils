import java.io.Serializable;

/**
 * A generic interface representing a collection of elements.
 *
 * <p>
 * A collection is a group of elements, possibly of different types, that can be
 * iterated over, checked for containment, copied, and serialized.
 * </p>
 *
 * <p>
 * The type parameter {@code E} represents the type of elements stored in the
 * collection, while the type parameter {@code T} represents the implementing
 * class itself, allowing methods like {@link #copy()} to return the
 * implementing type.
 * </p>
 *
 * @param <E> the type of elements in the collection
 * @param <T> the type of the implementing class
 *
 * @see Container
 * @see Iterable
 * @see Copyable
 * @see Serializable
 */
public interface Collection<E, T extends Collection<E, T>>
        extends Container<E>, Iterable<E>, Copyable<T>, Serializable {

    /**
     * Returns the size of the collection.
     *
     * @return the number of elements in the collection
     */
    int getSize();

    /**
     * Checks if the collection is empty.
     *
     * @return {@code true} if the collection contains no elements, {@code false}
     *         otherwise
     */
    default boolean isEmpty() {
        return getSize() <= 0;
    }
}
