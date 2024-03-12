import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * A generic interface representing a mutable sequence of elements.
 *
 * @param <E> the type of elements in the sequence
 * @param <T> the type of the sequence itself, allowing for fluent method
 *            chaining
 */
public interface MutableSequence<E, T extends MutableSequence<E, T>> extends Sequence<E, T> {

    /**
     * Inserts an element at the specified index in the sequence.
     *
     * @param index   the index at which to insert the element
     * @param element the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void insert(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Inserts an element at the beginning of the sequence.
     *
     * @param element the element to be prepended
     */
    default void prepend(E element) {
        insert(0, element);
    }

    /**
     * Inserts an element at the end of the sequence.
     *
     * @param element the element to be appended
     */
    default void append(E element) {
        insert(getSize(), element);
    }

    /**
     * Inserts all elements from an iterator at the specified index in the sequence.
     *
     * @param index    the index at which to insert the elements
     * @param elements the iterator providing elements to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void insertAll(int index, Iterator<? extends E> elements) throws IndexOutOfBoundsException {
        while (elements.hasNext()) {
            insert(index++, elements.next());
        }
    }

    /**
     * Inserts all elements from an iterable at the specified index in the sequence.
     *
     * @param index    the index at which to insert the elements
     * @param elements the iterable providing elements to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void insertAll(int index, Iterable<? extends E> elements) throws IndexOutOfBoundsException {
        insertAll(index, elements.iterator());
    }

    /**
     * Inserts all elements from a collection at the specified index in the
     * sequence.
     *
     * @param index    the index at which to insert the elements
     * @param elements the collection providing elements to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void insertAll(int index, Collection<? extends E, ?> elements) throws IndexOutOfBoundsException {
        insertAll(index, elements.iterator());
    }

    /**
     * Inserts all elements from an iterator at the beginning of the sequence.
     *
     * @param elements the iterator providing elements to be prepended
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void prependAll(Iterator<? extends E> elements) throws IndexOutOfBoundsException {
        insertAll(0, elements);
    }

    /**
     * Inserts all elements from an iterable at the beginning of the sequence.
     *
     * @param elements the iterable providing elements to be prepended
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void prependAll(Iterable<? extends E> elements) throws IndexOutOfBoundsException {
        prependAll(elements.iterator());
    }

    /**
     * Inserts all elements from a collection at the beginning of the sequence.
     *
     * @param elements the collection providing elements to be prepended
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void prependAll(Collection<? extends E, ?> elements) throws IndexOutOfBoundsException {
        prependAll(elements.iterator());
    }

    /**
     * Inserts all elements from an iterator at the end of the sequence.
     *
     * @param elements the iterator providing elements to be appended
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void appendAll(Iterator<? extends E> elements) throws IndexOutOfBoundsException {
        insertAll(getSize(), elements);
    }

    /**
     * Inserts all elements from an iterable at the end of the sequence.
     *
     * @param elements the iterable providing elements to be appended
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void appendAll(Iterable<? extends E> elements) throws IndexOutOfBoundsException {
        appendAll(elements.iterator());
    }

    /**
     * Inserts all elements from a collection at the end of the sequence.
     *
     * @param elements the collection providing elements to be appended
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default void appendAll(Collection<? extends E, ?> elements) throws IndexOutOfBoundsException {
        appendAll(elements.iterator());
    }

    /**
     * Removes the first occurrence of the specified element from the sequence.
     *
     * @param element the element to be removed
     * @return true if the element was found and removed, false otherwise
     */
    default boolean removeFirst(E element) {
        int index = indexOf(element);
        if (index < 0)
            return false;
        delete(index);
        return true;
    }

    /**
     * Removes the last occurrence of the specified element from the sequence.
     *
     * @param element the element to be removed
     * @return true if the element was found and removed, false otherwise
     */
    default boolean removeLast(E element) {
        int index = lastIndexOf(element);
        if (index < 0)
            return false;
        delete(index);
        return true;
    }

    /**
     * Removes all elements satisfying the given predicate from the sequence.
     *
     * @param predicate the predicate to apply for removal
     * @return true if any elements were removed, false otherwise
     */
    boolean removeAll(Predicate<E> predicate);

    /**
     * Deletes the element at the specified index in the sequence.
     *
     * @param index the index of the element to be deleted
     * @return the element that was deleted
     */
    E delete(int index);

    /**
     * Sets the element at the specified index in the sequence.
     *
     * @param index   the index of the element to be set
     * @param element the new element
     */
    void set(int index, E element);

    /**
     * Clears the sequence by removing all elements.
     */
    default void clear() {
        removeAll((e) -> true);
    }

    /**
     * Sorts the elements of the sequence using the specified comparator.
     *
     * @param comparator the comparator to be used for sorting
     */
    void sort(Comparator<? super E> comparator);

    /**
     * Reverses the order of the elements in the sequence.
     */
    void reverse();
}
