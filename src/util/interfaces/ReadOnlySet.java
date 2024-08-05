package util.interfaces;

/**
 * Represents a read-only set of elements.
 * 
 * @param <E> the type of elements in this set
 */
public interface ReadOnlySet<E> extends ReadOnlyCollection<E> {

    /**
     * Returns whether this set overlaps with the given iterable.
     * 
     * @param iterable the iterable to check for overlaps
     * @return {@code true} if this set overlaps with the given iterable,
     *         {@code false} otherwise
     */
    default boolean overlaps(Iterable<? extends E> iterable) {
        return containsAny(iterable);
    }

    /**
     * Returns whether this set is a superset of the given iterable.
     * 
     * @param iterable the iterable to check for a superset
     * @return {@code true} if this set is a superset of the given iterable,
     *         {@code false} otherwise
     */
    boolean isSupersetOf(Iterable<? extends E> iterable);

    /**
     * Returns whether this set is a subset of the given iterable.
     * 
     * @param iterable the iterable to check for a subset
     * @return {@code true} if this set is a subset of the given iterable,
     *         {@code false} otherwise
     */
    boolean isSubsetOf(Iterable<E> iterable);
}
