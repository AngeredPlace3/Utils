import java.util.Iterator;

/**
 * An interface for containers that hold elements and provide methods to check
 * for containment.
 *
 * @param <E> the type of elements in the container
 */
public interface Container<E> {

    /**
     * Checks if the container contains the specified element.
     *
     * @param element the element to be checked for containment in this container
     * @return {@code true} if this container contains the specified element,
     *         {@code false} otherwise
     */
    boolean contains(E element);

    /**
     * Checks if the container contains all elements provided by the iterator.
     *
     * @param elements the iterator of elements to be checked for containment in
     *                 this container
     * @return {@code true} if this container contains all elements provided by the
     *         iterator, {@code false} otherwise
     */
    default boolean containsAll(Iterator<? extends E> elements) {
        while (elements.hasNext()) {
            if (!contains(elements.next())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the container contains all elements provided by the iterable.
     *
     * @param elements the iterable of elements to be checked for containment in
     *                 this container
     * @return {@code true} if this container contains all elements provided by the
     *         iterable, {@code false} otherwise
     */
    default boolean containsAll(Iterable<? extends E> elements) {
        return containsAll(elements.iterator());
    }

    /**
     * Checks if the container contains any of the elements provided by the
     * iterator.
     *
     * @param elements the iterator of elements to be checked for containment in
     *                 this container
     * @return {@code true} if this container contains any of the elements provided
     *         by the iterator, {@code false} otherwise
     */
    default boolean containsAny(Iterator<? extends E> elements) {
        while (elements.hasNext()) {
            if (contains(elements.next())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the container contains any of the elements provided by the
     * iterable.
     *
     * @param elements the iterable of elements to be checked for containment in
     *                 this container
     * @return {@code true} if this container contains any of the elements provided
     *         by the iterable, {@code false} otherwise
     */
    default boolean containsAny(Iterable<? extends E> elements) {
        return containsAny(elements.iterator());
    }
}
