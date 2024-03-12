import java.util.Iterator;
import java.util.function.Predicate;

/**
 * An interface representing an immutable sequence of elements.
 * 
 * @param <E> the type of elements in the sequence
 * @param <T> the type of the implementing class
 * 
 * @see Sequence
 */
public interface ImmutableSequence<E, T extends ImmutableSequence<E, T>> extends Sequence<E, T> {

    /**
     * Inserts the specified element at the specified position in this sequence.
     *
     * @param index   the index at which the element is to be inserted
     * @param element the element to be inserted
     * @return a new sequence with the element inserted at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T insert(int index, E element) throws IndexOutOfBoundsException;

    /**
     * Inserts the specified element at the beginning of this sequence.
     *
     * @param element the element to be inserted
     * @return a new sequence with the element inserted at the beginning
     */
    default T prepend(E element) {
        return insert(0, element);
    }

    /**
     * Inserts the specified element at the end of this sequence.
     *
     * @param element the element to be inserted
     * @return a new sequence with the element inserted at the end
     */
    default T append(E element) {
        return insert(getSize(), element);
    }

    /**
     * Inserts all elements from the specified iterator at the specified position in
     * this sequence.
     *
     * @param index    the index at which to insert the first element from the
     *                 iterator
     * @param elements the iterator containing elements to be inserted
     * @return a new sequence with elements inserted from the iterator at the
     *         specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T insertAll(int index, Iterator<? extends E> elements) throws IndexOutOfBoundsException;

    /**
     * Inserts all elements from the specified iterable at the specified position in
     * this sequence.
     *
     * @param index    the index at which to insert the first element from the
     *                 iterable
     * @param elements the iterable containing elements to be inserted
     * @return a new sequence with elements inserted from the iterable at the
     *         specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default T insertAll(int index, Iterable<? extends E> elements) throws IndexOutOfBoundsException {
        return insertAll(index, elements.iterator());
    }

    /**
     * Inserts all elements from the specified collection at the specified position
     * in
     * this sequence.
     *
     * @param index    the index at which to insert the first element from the
     *                 collection
     * @param elements the collection containing elements to be inserted
     * @return a new sequence with elements inserted from the collection at the
     *         specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    default T insertAll(int index, Collection<? extends E, ?> elements) throws IndexOutOfBoundsException {
        return insertAll(index, elements.iterator());
    }

    /**
     * Prepends all elements from the specified iterator to the beginning of this
     * sequence.
     *
     * @param elements the iterator containing elements to be prepended
     * @return a new sequence with elements prepended from the iterator
     */
    default T prependAll(Iterator<? extends E> elements) {
        return insertAll(0, elements);
    }

    /**
     * Prepends all elements from the specified iterable to the beginning of this
     * sequence.
     *
     * @param elements the iterable containing elements to be prepended
     * @return a new sequence with elements prepended from the iterable
     */
    default T prependAll(Iterable<? extends E> elements) {
        return prependAll(elements.iterator());
    }

    /**
     * Prepends all elements from the specified collection to the beginning of this
     * sequence.
     *
     * @param elements the collection containing elements to be prepended
     * @return a new sequence with elements prepended from the collection
     */
    default T prependAll(Collection<? extends E, ?> elements) {
        return prependAll(elements.iterator());
    }

    /**
     * Appends all elements from the specified iterator to the end of this sequence.
     *
     * @param elements the iterator containing elements to be appended
     * @return a new sequence with elements appended from the iterator
     */
    default T appendAll(Iterator<? extends E> elements) {
        return insertAll(getSize(), elements);
    }

    /**
     * Appends all elements from the specified iterable to the end of this sequence.
     *
     * @param elements the iterable containing elements to be appended
     * @return a new sequence with elements appended from the iterable
     */
    default T appendAll(Iterable<? extends E> elements) {
        return appendAll(elements.iterator());
    }

    /**
     * Appends all elements from the specified collection to the end of this
     * sequence.
     *
     * @param elements the collection containing elements to be appended
     * @return a new sequence with elements appended from the collection
     */
    default T appendAll(Collection<? extends E, ?> elements) {
        return appendAll(elements.iterator());
    }

    /**
     * Removes the first occurrence of the specified element from this sequence.
     *
     * @param element the element to be removed
     * @return a new sequence with the first occurrence of the element removed
     */
    @SuppressWarnings("unchecked")
    default T removeFirst(E element) {
        int index = indexOf(element);
        if (index < 0)
            return (T) this;
        return delete(index);
    }

    /**
     * Removes the last occurrence of the specified element from this sequence.
     *
     * @param element the element to be removed
     * @return a new sequence with the last occurrence of the element removed
     */
    @SuppressWarnings("unchecked")
    default T removeLast(E element) {
        int index = lastIndexOf(element);
        if (index < 0)
            return (T) this;
        return delete(index);
    }

    /**
     * Removes all elements from this sequence that match the given predicate.
     *
     * @param predicate the predicate used to test elements for removal
     * @return a new sequence with elements removed based on the predicate
     */
    T removeAll(Predicate<E> predicate);

    /**
     * Deletes the element at the specified index from this sequence.
     *
     * @param index the index of the element to be deleted
     * @return a new sequence with the element at the specified index deleted
     */
    T delete(int index);

    /**
     * Sets the element at the specified index in this sequence to the specified
     * element.
     *
     * @param index   the index of the element to be set
     * @param element the new element to be set
     * @return a new sequence with the element at the specified index set to the
     *         new element
     */
    T set(int index, E element);
}
