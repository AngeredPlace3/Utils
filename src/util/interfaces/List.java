package util.interfaces;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Represents a list, also known as a sequence, of elements.
 *
 * @param <E> the type of elements in this list
 */
public interface List<E> extends ReadOnlyList<E>, Deque<E>, Collection<E> {
    /**
     * Adds an element at the specified position in this list.
     * 
     * @param index   the index at which the specified element is to be
     * @param element the element to be added
     */
    void add(int index, E element);

    /**
     * Adds an element to the end of this list.
     * 
     * @param element the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     */
    @Override
    default boolean add(E element) {
        addLast(element);
        return true;
    }

    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index the index of the element to remove
     * @return the element that was removed from the list
     */
    E remove(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   the index of the element to replace
     * @param element the element to be stored at the specified position
     * @return the element previously at the specified position
     */
    E set(int index, E element);

    /**
     * Adds an element to the end of this list.
     * 
     * @param element the element to add
     */
    @Override
    default void enqueue(E element) {
        addLast(element);
    }

    /**
     * Removes and returns the first element of this list.
     * 
     * @return the first element of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    default E dequeue() throws NoSuchElementException {
        return removeFirst();
    }

    /**
     * Adds an element to the start of this list.
     * 
     * @param element the element to add
     */
    @Override
    default void push(E element) {
        addFirst(element);
    }

    /**
     * Removes and returns the first element of this list.
     * 
     * @return the first element of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    default E pop() throws NoSuchElementException {
        return removeFirst();
    }

    /**
     * Adds an element to the start of this list.
     * 
     * @param element the element to add
     */
    @Override
    default void addFirst(E element) {
        add(0, element);
    }

    /**
     * Adds an element to the end of this list.
     * 
     * @param element the element to add
     */
    @Override
    default void addLast(E element) {
        add(size(), element);
    }

    /**
     * Removes and returns the first element of this list.
     * 
     * @return the first element of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    default E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(0);
    }

    /**
     * Removes and returns the last element of this list.
     * 
     * @return the last element of this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    default E removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(size() - 1);
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    default void clear() {
        while (!isEmpty()) {
            removeLast();
        }
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present.
     * 
     * @param element the element to remove
     * @return {@code true} if this list contained the specified element,
     *         {@code false} otherwise
     */
    @Override
    default boolean remove(E element) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(get(i), element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

}
