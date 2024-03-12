import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A generic interface representing a sequence of elements.
 *
 * <p>
 * A sequence represents an ordered collection of elements, where the order of
 * elements matters.
 * </p>
 * 
 * @param <E> the type of elements in the sequence
 * @param <T> the type of the implementing class
 *
 * @see Collection
 * @see Container
 * @see Copyable
 */
public interface Sequence<E, T extends Sequence<E, T>> extends Collection<E, T> {

    /**
     * Retrieves the element at the specified index in this sequence.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
     *                                   || index &gt;= getSize())
     */
    E get(int index) throws IndexOutOfBoundsException;

    /**
     * Retrieves the first element of this sequence.
     *
     * @return the first element of the sequence
     * @throws NoSuchElementException if this sequence is empty
     */
    default E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Sequence is empty");
        }
        return get(0);
    }

    /**
     * Retrieves the last element of this sequence.
     *
     * @return the last element of the sequence
     * @throws NoSuchElementException if this sequence is empty
     */
    default E getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Sequence is empty");
        }
        return get(getSize() - 1);
    }

    /**
     * Returns a sub-sequence of elements from the specified {@code fromIndex}
     * (inclusive) to the specified {@code toIndex} (exclusive) in this sequence.
     *
     * @param fromIndex the starting index of the sub-sequence (inclusive)
     * @param toIndex   the ending index of the sub-sequence (exclusive)
     * @return a sub-sequence of elements from the specified index range
     * @throws IndexOutOfBoundsException if the specified range is invalid
     */
    T slice(int fromIndex, int toIndex) throws IndexOutOfBoundsException;

    /**
     * Returns the index of the first occurrence of the specified element within the
     * specified range of this sequence, searching from {@code fromIndex}
     * (inclusive) to {@code toIndex} (exclusive).
     *
     * @param element   the element to search for
     * @param fromIndex the starting index of the search range (inclusive)
     * @param toIndex   the ending index of the search range (exclusive)
     * @return the index of the first occurrence of the element, or -1 if the
     *         element is not found
     * @throws IndexOutOfBoundsException if the specified range is invalid
     */
    default int indexOf(E element, int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        Objects.checkFromToIndex(fromIndex, toIndex, getSize());
        for (int i = fromIndex; i < toIndex; i++) {
            if (Objects.equals(get(i), element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element within
     * this sequence, starting the search from the specified {@code fromIndex}.
     *
     * @param element   the element to search for
     * @param fromIndex the starting index of the search
     * @return the index of the first occurrence of the element, or -1 if the
     *         element is not found
     * @throws IndexOutOfBoundsException if the specified {@code fromIndex} is out
     *                                   of range
     */
    default int indexOf(E element, int fromIndex) throws IndexOutOfBoundsException {
        return indexOf(element, fromIndex, getSize());
    }

    /**
     * Returns the index of the first occurrence of the specified element within
     * this sequence, starting the search from the beginning.
     *
     * @param element the element to search for
     * @return the index of the first occurrence of the element, or -1 if the
     *         element is not found
     */
    default int indexOf(E element) {
        return indexOf(element, 0);
    }

    /**
     * Returns the index of the last occurrence of the specified element within the
     * specified range of this sequence, searching from {@code fromIndex}
     * (inclusive) to {@code toIndex} (exclusive).
     *
     * @param element   the element to search for
     * @param fromIndex the starting index of the search range (inclusive)
     * @param toIndex   the ending index of the search range (exclusive)
     * @return the index of the last occurrence of the element, or -1 if the element
     *         is not found
     * @throws IndexOutOfBoundsException if the specified range is invalid
     */
    default int lastIndexOf(E element, int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        Objects.checkFromToIndex(fromIndex, toIndex, getSize());
        for (int i = toIndex - 1; i >= fromIndex; i--) {
            if (Objects.equals(get(i), element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element within this
     * sequence, starting the search from the specified {@code fromIndex}.
     *
     * @param element   the element to search for
     * @param fromIndex the starting index of the search
     * @return the index of the last occurrence of the element, or -1 if the element
     *         is not found
     * @throws IndexOutOfBoundsException if the specified {@code fromIndex} is out
     *                                   of range
     */
    default int lastIndexOf(E element, int fromIndex) throws IndexOutOfBoundsException {
        return lastIndexOf(element, fromIndex, getSize());
    }

    /**
     * Returns the index of the last occurrence of the specified element within this
     * sequence, searching from the beginning.
     *
     * @param element the element to search for
     * @return the index of the last occurrence of the element, or -1 if the element
     *         is not found
     */
    default int lastIndexOf(E element) {
        return lastIndexOf(element, 0);
    }

    /**
     * Returns a new sequence containing the elements of this sequence in reverse
     * order.
     *
     * @return a new sequence with elements in reverse order
     */
    default T reversed() {
        return reversed(0);
    }

    /**
     * Returns a new sequence containing the elements of this sequence in reverse
     * order, starting from the specified {@code fromIndex}.
     *
     * @param fromIndex the starting index of the range to reverse (inclusive)
     * @return a new sequence with elements in reverse order starting from the
     *         specified index
     * @throws IndexOutOfBoundsException if the specified index is out of range
     */
    default T reversed(int fromIndex) {
        return reversed(fromIndex, getSize());
    }

    /**
     * Returns a new sequence containing the elements of this sequence in reverse
     * order within the specified range from {@code fromIndex}to
     * {@code toIndex}.
     *
     * @param fromIndex the starting index of the range to reverse (inclusive)
     * @param toIndex   the ending index of the range to reverse (exclusive)
     * @return a new sequence with elements in reverse order within the specified
     *         range
     * @throws IndexOutOfBoundsException if the specified range is invalid
     */
    T reversed(int fromIndex, int toIndex) throws IndexOutOfBoundsException;

    /**
     * Returns a new sequence containing the elements of this sequence sorted
     * according to the provided {@code comparator}, within the specified range
     * from {@code fromIndex} (inclusive) to {@code toIndex} (exclusive).
     *
     * @param comparator the comparator to determine the order of the elements
     * @param fromIndex  the starting index of the range to be sorted (inclusive)
     * @param toIndex    the ending index of the range to be sorted (exclusive)
     * @return a new sequence with elements sorted within the specified range
     * @throws IndexOutOfBoundsException if the specified range is invalid
     */
    T sorted(Comparator<? super E> comparator, int fromIndex, int toIndex) throws IndexOutOfBoundsException;

    /**
     * Returns a new sequence containing the elements of this sequence sorted
     * according to the provided {@code comparator}, starting from the specified
     * {@code fromIndex}.
     *
     * @param comparator the comparator to determine the order of the elements
     * @param fromIndex  the starting index of the range to be sorted (inclusive)
     * @return a new sequence with elements sorted starting from the specified index
     * @throws IndexOutOfBoundsException if the specified index is out of range
     */
    default T sorted(Comparator<? super E> comparator, int fromIndex) throws IndexOutOfBoundsException {
        return sorted(comparator, fromIndex, getSize());
    }

    /**
     * Returns a new sequence containing the elements of this sequence sorted
     * according to the provided {@code comparator}, starting from index 0.
     *
     * @param comparator the comparator to determine the order of the elements
     * @return a new sequence with elements sorted starting from index 0
     */
    default T sorted(Comparator<? super E> comparator) {
        return sorted(comparator, 0);
    }

    /**
     * Returns an iterator over the elements in this sequence in the forward
     * direction.
     *
     * @return an iterator over the elements in this sequence
     */
    @Override
    default Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < getSize();
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException("No more elements");
                return get(index++);
            }

        };
    }

    /**
     * Returns an iterator over the elements in this sequence in the reverse
     * direction.
     *
     * @return an iterator over the elements in this sequence in reverse
     */
    default Iterator<E> reverseIterator() {
        return new Iterator<E>() {
            int index = getSize() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException("No more elements");
                return get(index--);
            }
        };
    }

    /**
     * Returns a new sequence that is cleared, containing no elements.
     *
     * @return a new sequence cleared of all elements
     */
    T cleared();
}
