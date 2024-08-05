package util.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * An immutable tuple.
 * 
 * @param <E> the type of elements in the tuple
 */
public class Tuple<E> extends AbstractList<E> {

    private final static Tuple<?> EMPTY = new Tuple<>(new Object[0], false);

    private final E[] array;

    private Tuple(E[] array, boolean makeCopy) {
        Objects.requireNonNull(array);
        if (makeCopy) {
            this.array = Arrays.copyOf(array, array.length);
        } else {
            this.array = array;
        }
    }

    /**
     * Create a new {@link Tuple} with the given iterable.
     * 
     * @param iterable the iterable
     */
    @SuppressWarnings("unchecked")
    public Tuple(Iterable<E> iterable) {
        ReadOnlyCollection<E> collection;
        if (iterable instanceof ReadOnlyCollection<E> c) {
            collection = c;
        } else {
            collection = new LinkedList<>(iterable);
        }
        this.array = (E[]) new Object[collection.size()];
        int i = 0;
        for (E element : collection) {
            this.array[i++] = element;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int size() {
        return array.length;
    }

    /**
     * Create a new {@link Tuple} with the given elements.
     * 
     * @param <E>   the type of elements
     * @param value the elements
     * @return a new {@link Tuple} with the given elements
     */
    @SuppressWarnings("unchecked")
    public static <E> Tuple<E> of(E... value) {
        return new Tuple<>(value, true);
    }

    /**
     * Create an empty {@link Tuple}.
     * 
     * @param <E> the type of elements
     * @return an empty {@link Tuple}
     */
    @SuppressWarnings("unchecked")
    public static <E> Tuple<E> of() {
        return (Tuple<E>) EMPTY;
    }

    /**
     * Returns a new tuple with the given element inserted at the given index.
     * 
     * @param index   the index at which the element should be inserted
     * @param element the element to insert
     * @return the new tuple with the element inserted at the given index
     */
    public Tuple<E> add(int index, E element) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException();
        }
        E[] newArray = Arrays.copyOf(array, array.length + 1);
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        newArray[index] = element;
        return new Tuple<>(newArray, false);
    }

    /**
     * Returns a new tuple with the given element added to the start.
     * 
     * @param element the element to add
     * @return the new tuple with the element added to the start
     */
    public Tuple<E> addFirst(E element) {
        return add(0, element);
    }

    /**
     * Returns a new tuple with the given element added to the end.
     * 
     * @param element the element to add
     * @return the new tuple with the element added to the end
     */
    public Tuple<E> addLast(E element) {
        return add(array.length, element);
    }

    /**
     * Returns a new tuple with the element at the given index removed.
     * 
     * @param index the index of the element to remove
     * @return the new tuple with the element removed at the given index
     */
    public Tuple<E> remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        E[] newArray = Arrays.copyOf(array, array.length - 1);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return new Tuple<>(newArray, false);
    }

    /**
     * Returns a new tuple with the first element removed.
     * 
     * @return the new tuple with the first element removed
     */
    public Tuple<E> removeFirst() {
        if (array.length == 0) {
            throw new NoSuchElementException();
        }
        return remove(0);
    }

    /**
     * Returns a new tuple with the last element removed.
     * 
     * @return the new tuple with the last element removed
     */
    public Tuple<E> removeLast() {
        if (array.length == 0) {
            throw new NoSuchElementException();
        }
        return remove(array.length - 1);
    }

    /**
     * Returns a new tuple with the given element set at the given index.
     * 
     * @param index   the index of the element to set
     * @param element the element to set
     * @return the new tuple with the element set at the given index
     */
    public Tuple<E> set(int index, E element) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        E[] newArray = Arrays.copyOf(array, array.length);
        newArray[index] = element;
        return new Tuple<>(newArray, false);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        for (E element : this) {
            joiner.add(Objects.toString(element));
        }
        return joiner.toString();
    }

    /**
     * Returns a new tuple with all elements remvoed.
     * 
     * @return the new tuple with all elements remvoed
     */
    public Tuple<E> clear() {
        return Tuple.of();
    }

    @Override
    public Iterator<E> iterator() {
        class TupleIterator implements Iterator<E> {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < array.length;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[i++];
            }
        }

        return new TupleIterator();
    }

}
