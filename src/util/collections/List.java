package util.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * An interface that represents a list (also known as a sequence) of elements.
 * 
 * @param <E> the type of elements in this list
 */
public interface List<E> extends Collection<E>, Deque<E>, Stack<E>, Queue<E> {

    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
     *                                   index >= size())
     */
    E get(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the first element in this list.
     * 
     * @return the first element in this list
     */
    @Override
    default E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    /**
     * Returns the last element in this list.
     * 
     * @return the last element in this list
     */
    @Override
    default E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size() - 1);
    }

    /**
     * Returns an iterator over elements in this list.
     * 
     * @return an {@code Iterator<E>} to iterate over the elements in this list
     */
    @Override
    default Iterator<E> iterator() {

        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }

        };
    }

    /**
     * A subinterface of {@code List} that represents a mutable list of elements.
     * This interface provides methods for modifying the list.*
     * 
     * @param <E> the type of elements in this mutable list
     */
    interface Mutable<E> extends List<E>, Collection.Mutable<E>, Deque.Mutable<E>, Stack.Mutable<E>, Queue.Mutable<E> {
        /**
         * Inserts the specified element at the specified position in this list.
         * 
         * @param index the index at which the specified element is to be inserted
         * @param value the element to be inserted
         */
        void insert(int index, E value);

        /**
         * Appends the specified element to the end of this list.
         * 
         * @param value the element to be appended
         */
        default void append(E value) {
            insert(size(), value);
        }

        /**
         * Prepends the specified element to the start of this list.
         * 
         * @param value the element to be prepended
         */
        default void prepend(E value) {
            insert(0, value);
        }

        /**
         * Adds the specified element to the end of this list. This is equivalent
         * to {@code append(value)}.
         * 
         * @param value the element to be added
         * @return always {@code true}
         */
        @Override
        default boolean add(E value) {
            insert(size(), value);
            return true;
        }

        /**
         * Sets the element at the specified position in this list.
         * 
         * @param index the index of the element to set
         * @param value the new value
         * @return the old value
         */
        E set(int index, E value);

        /**
         * Removes the element at the specified position in this list.
         * 
         * @param index the index of the element to remove
         * @return the removed element
         */
        E remove(int index);

        /**
         * Removes the first element in this list.
         * 
         * @return the removed element
         * @throws NoSuchElementException if this list is empty
         */
        default E removeFirst() throws NoSuchElementException {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return remove(0);
        }

        /**
         * Removes the last element in this list.
         * 
         * @return the removed element
         * @throws NoSuchElementException if this list is empty
         */
        default E removeLast() throws NoSuchElementException {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return remove(size() - 1);
        }

        /**
         * Adds the specified element to the start of this list. This is equivalent
         * to {@code prepend(element)}.
         *
         * @param element the element to add
         */
        @Override
        default void addFirst(E element) {
            prepend(element);
        }

        /**
         * Adds the specified element to the end of this list. This is equivalent
         * to {@code append(element)}.
         *
         * @param element the element to add
         */
        @Override
        default void addLast(E element) {
            append(element);
        }

        @Override
        default boolean retainIf(Predicate<? super E> predicate) {
            boolean changed = false;
            for (int i = 0; i < size(); i++) {
                if (!predicate.test(get(i))) {
                    remove(i);
                    i--;
                    changed = true;
                }
            }
            return changed;
        }

        @Override
        default boolean remove(E value) {
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(value)) {
                    remove(i);
                    return true;
                }
            }
            return false;
        }
    }

}
