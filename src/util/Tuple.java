package util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

import util.tuple.Decuple;
import util.tuple.Nonuple;
import util.tuple.Octuple;
import util.tuple.Pair;
import util.tuple.Quadruple;
import util.tuple.Quintuple;
import util.tuple.Septuple;
import util.tuple.Sextuple;
import util.tuple.Triple;
import util.tuple.Unit;

/**
 * Represents a tuple of elements.
 *
 * @param <E> the type of elements in the tuple
 */
public class Tuple<E> implements ImmutableSequence<E, Tuple<E>> {
    private final E[] elements;

    private static final Tuple<?> EMPTY = new Tuple<>();

    /**
     * Returns an empty tuple.
     * 
     * @param <T> the type of elements in the tuple
     * @return an empty tuple
     */
    @SuppressWarnings("unchecked")
    public static <T> Tuple<T> of() {
        return (Tuple<T>) EMPTY;
    }

    /**
     * Creates a Unit tuple containing the specified value.
     *
     * @param value the value to be contained in the Unit tuple
     * @param <A>   the type of the value and the Unit tuple
     * @return a new Unit tuple containing the specified value
     */
    public static <A> Unit<A> of(A value) {
        return new Unit<>(value);
    }

    /**
     * Creates a Pair tuple containing the specified values.
     *
     * @param first  the first value to be contained in the Pair tuple
     * @param second the second value to be contained in the Pair tuple
     * @param <A>    the type of the first value
     * @param <B>    the type of the second value
     * @return a new Pair tuple containing the specified values
     */
    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }

    /**
     * Creates a Triple tuple containing the specified values.
     *
     * @param first  the first value to be contained in the Triple tuple
     * @param second the second value to be contained in the Triple tuple
     * @param third  the third value to be contained in the Triple tuple
     * @param <A>    the type of the first value
     * @param <B>    the type of the second value
     * @param <C>    the type of the third value
     * @return a new Triple tuple containing the specified values
     */
    public static <A, B, C> Triple<A, B, C> of(A first, B second, C third) {
        return new Triple<>(first, second, third);
    }

    /**
     * Creates a Quadruple tuple containing the specified values.
     *
     * @param first  the first value to be contained in the Quadruple tuple
     * @param second the second value to be contained in the Quadruple tuple
     * @param third  the third value to be contained in the Quadruple tuple
     * @param fourth the fourth value to be contained in the Quadruple tuple
     * @param <A>    the type of the first value
     * @param <B>    the type of the second value
     * @param <C>    the type of the third value
     * @param <D>    the type of the fourth value
     * @return a new Quadruple tuple containing the specified values
     */
    public static <A, B, C, D> Quadruple<A, B, C, D> of(A first, B second, C third, D fourth) {
        return new Quadruple<>(first, second, third, fourth);
    }

    /**
     * Creates a Quintuple tuple containing the specified values.
     *
     * @param first  the first value to be contained in the Quintuple tuple
     * @param second the second value to be contained in the Quintuple tuple
     * @param third  the third value to be contained in the Quintuple tuple
     * @param fourth the fourth value to be contained in the Quintuple tuple
     * @param fifth  the fifth value to be contained in the Quintuple tuple
     * @param <A>    the type of the first value
     * @param <B>    the type of the second value
     * @param <C>    the type of the third value
     * @param <D>    the type of the fourth value
     * @param <E>    the type of the fifth value
     * @return a new Quintuple tuple containing the specified values
     */
    public static <A, B, C, D, E> Quintuple<A, B, C, D, E> of(A first, B second, C third, D fourth, E fifth) {
        return new Quintuple<>(first, second, third, fourth, fifth);
    }

    /**
     * Creates a Sextuple tuple containing the specified values.
     *
     * @param first  the first value to be contained in the Sextuple tuple
     * @param second the second value to be contained in the Sextuple tuple
     * @param third  the third value to be contained in the Sextuple tuple
     * @param fourth the fourth value to be contained in the Sextuple tuple
     * @param fifth  the fifth value to be contained in the Sextuple tuple
     * @param sixth  the sixth value to be contained in the Sextuple tuple
     * @param <A>    the type of the first value
     * @param <B>    the type of the second value
     * @param <C>    the type of the third value
     * @param <D>    the type of the fourth value
     * @param <E>    the type of the fifth value
     * @param <F>    the type of the sixth value
     * @return a new Sextuple tuple containing the specified values
     */
    public static <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F> of(A first, B second, C third, D fourth, E fifth,
            F sixth) {
        return new Sextuple<>(first, second, third, fourth, fifth, sixth);
    }

    /**
     * Creates a Septuple tuple containing the specified values.
     *
     * @param first   the first value to be contained in the Septuple tuple
     * @param second  the second value to be contained in the Septuple tuple
     * @param third   the third value to be contained in the Septuple tuple
     * @param fourth  the fourth value to be contained in the Septuple tuple
     * @param fifth   the fifth value to be contained in the Septuple tuple
     * @param sixth   the sixth value to be contained in the Septuple tuple
     * @param seventh the seventh value to be contained in the Septuple tuple
     * @param <A>     the type of the first value
     * @param <B>     the type of the second value
     * @param <C>     the type of the third value
     * @param <D>     the type of the fourth value
     * @param <E>     the type of the fifth value
     * @param <F>     the type of the sixth value
     * @param <G>     the type of the seventh value
     * @return a new Septuple tuple containing the specified values
     */
    public static <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G> of(A first, B second, C third, D fourth, E fifth,
            F sixth, G seventh) {
        return new Septuple<>(first, second, third, fourth, fifth, sixth, seventh);
    }

    /**
     * Creates an Octuple tuple containing the specified values.
     *
     * @param first   the first value to be contained in the Octuple tuple
     * @param second  the second value to be contained in the Octuple tuple
     * @param third   the third value to be contained in the Octuple tuple
     * @param fourth  the fourth value to be contained in the Octuple tuple
     * @param fifth   the fifth value to be contained in the Octuple tuple
     * @param sixth   the sixth value to be contained in the Octuple tuple
     * @param seventh the seventh value to be contained in the Octuple tuple
     * @param eighth  the eighth value to be contained in the Octuple tuple
     * @param <A>     the type of the first value
     * @param <B>     the type of the second value
     * @param <C>     the type of the third value
     * @param <D>     the type of the fourth value
     * @param <E>     the type of the fifth value
     * @param <F>     the type of the sixth value
     * @param <G>     the type of the seventh value
     * @param <H>     the type of the eighth value
     * @return a new Octuple tuple containing the specified values
     */
    public static <A, B, C, D, E, F, G, H> Octuple<A, B, C, D, E, F, G, H> of(A first, B second, C third, D fourth,
            E fifth, F sixth, G seventh, H eighth) {
        return new Octuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    /**
     * Creates a Nonuple tuple containing the specified values.
     *
     * @param first   the first value to be contained in the Nonuple tuple
     * @param second  the second value to be contained in the Nonuple tuple
     * @param third   the third value to be contained in the Nonuple tuple
     * @param fourth  the fourth value to be contained in the Nonuple tuple
     * @param fifth   the fifth value to be contained in the Nonuple tuple
     * @param sixth   the sixth value to be contained in the Nonuple tuple
     * @param seventh the seventh value to be contained in the Nonuple tuple
     * @param eighth  the eighth value to be contained in the Nonuple tuple
     * @param ninth   the ninth value to be contained in the Nonuple tuple
     * @param <A>     the type of the first value
     * @param <B>     the type of the second value
     * @param <C>     the type of the third value
     * @param <D>     the type of the fourth value
     * @param <E>     the type of the fifth value
     * @param <F>     the type of the sixth value
     * @param <G>     the type of the seventh value
     * @param <H>     the type of the eighth value
     * @param <I>     the type of the ninth value
     * @return a new Nonuple tuple containing the specified values
     */
    public static <A, B, C, D, E, F, G, H, I> Nonuple<A, B, C, D, E, F, G, H, I> of(A first, B second, C third,
            D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        return new Nonuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    /**
     * Creates a Tuple containing the specified elements.
     *
     * @param elements the elements to be contained in the Tuple
     * @param <T>      the type of elements in the Tuple
     * @return a new Tuple containing the specified elements
     */
    @SuppressWarnings("unchecked")
    public static <T> Tuple<T> of(T... elements) {
        return new Tuple<>(elements);
    }

    /**
     * Creates a Decuple tuple containing the specified values.
     *
     * @param first   the first value to be contained in the Decuple tuple
     * @param second  the second value to be contained in the Decuple tuple
     * @param third   the third value to be contained in the Decuple tuple
     * @param fourth  the fourth value to be contained in the Decuple tuple
     * @param fifth   the fifth value to be contained in the Decuple tuple
     * @param sixth   the sixth value to be contained in the Decuple tuple
     * @param seventh the seventh value to be contained in the Decuple tuple
     * @param eighth  the eighth value to be contained in the Decuple tuple
     * @param ninth   the ninth value to be contained in the Decuple tuple
     * @param tenth   the tenth value to be contained in the Decuple tuple
     * @param <A>     the type of the first value
     * @param <B>     the type of the second value
     * @param <C>     the type of the third value
     * @param <D>     the type of the fourth value
     * @param <E>     the type of the fifth value
     * @param <F>     the type of the sixth value
     * @param <G>     the type of the seventh value
     * @param <H>     the type of the eighth value
     * @param <I>     the type of the ninth value
     * @param <J>     the type of the tenth value
     * @return a new Decuple tuple containing the specified values
     */
    public static <A, B, C, D, E, F, G, H, I, J> Decuple<A, B, C, D, E, F, G, H, I, J> of(A first, B second, C third,
            D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        return new Decuple<>(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Constructs a tuple with the specified elements.
     * 
     * @param elements the elements to be included in the tuple
     */
    @SuppressWarnings("unchecked")
    public Tuple(E... elements) {
        this(elements, true);
    }

    /**
     * Constructs an empty tuple.
     */
    public Tuple() {
        this(null, false);
    }

    /**
     * Constructs a tuple containing the elements of the given collection.
     * The order of elements in the tuple will be the same as the iteration order of
     * the collection.
     *
     * @param elements the collection whose elements are to be placed into this
     *                 tuple
     */
    @SuppressWarnings("unchecked")
    public Tuple(Collection<E, ?> elements) {
        this.elements = (E[]) elements.toArray();
    }

    /**
     * Constructs a tuple containing the elements of the given iterator.
     * The elements are collected into a deque before constructing the tuple.
     *
     * @param elements the iterator providing the elements to be placed into this
     *                 tuple
     */
    public Tuple(Iterator<E> elements) {
        this(new Deque<>(elements));
    }

    /**
     * Constructs a tuple containing the elements of the given iterable.
     * The elements are collected into a deque before constructing the tuple.
     *
     * @param elements the iterable providing the elements to be placed into this
     *                 tuple
     */
    public Tuple(Iterable<E> elements) {
        this(elements.iterator());
    }

    /**
     * Constructs a tuple with the specified elements, optionally copying them.
     * 
     * @param elements the elements to be included in the tuple
     * @param copy     true to copy the elements, false otherwise
     */
    private Tuple(E[] elements, boolean copy) {
        if (copy && elements != null) {
            this.elements = elements.clone();
        } else {
            this.elements = elements;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, getSize());
        return elements[index];
    }

    @Override
    public Tuple<E> slice(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        Objects.checkFromToIndex(fromIndex, toIndex, getSize());
        return new Tuple<>(Arrays.copyOfRange(elements, fromIndex, toIndex), false);
    }

    @Override
    public Tuple<E> reversed(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        Objects.checkFromToIndex(fromIndex, toIndex, getSize());
        @SuppressWarnings("unchecked")
        E[] reversedElements = (E[]) new Object[toIndex - fromIndex];
        for (int i = toIndex - 1, j = 0; i >= fromIndex; i--, j++) {
            reversedElements[j] = elements[i];
        }
        return new Tuple<>(reversedElements, false);
    }

    @Override
    public Tuple<E> sorted(Comparator<? super E> comparator, int fromIndex, int toIndex)
            throws IndexOutOfBoundsException {
        Objects.checkFromToIndex(fromIndex, toIndex, getSize());
        if (fromIndex == toIndex)
            return this;
        E[] sortedElements = Arrays.copyOfRange(elements, fromIndex, toIndex);
        Arrays.sort(sortedElements, comparator);
        return new Tuple<>(sortedElements, false);
    }

    @Override
    public Tuple<E> cleared() {
        return of();
    }

    @Override
    public int getSize() {
        return elements == null ? 0 : elements.length;
    }

    @Override
    public boolean contains(E element) {
        for (E e : this) {
            if (Objects.equals(e, element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Tuple<E> copy() {
        return new Tuple<>(elements);
    }

    @Override
    public Tuple<E> insert(int index, E element) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, getSize() + 1);

        @SuppressWarnings("unchecked")
        E[] newElements = (E[]) new Object[getSize() + 1];

        for (int i = 0; i < index; i++) {
            newElements[i] = elements[i];
        }
        newElements[index] = element;
        for (int i = index; i < getSize(); i++) {
            newElements[i + 1] = elements[i];
        }
        return new Tuple<>(newElements, false);
    }

    @Override
    public Tuple<E> insertAll(int index, Iterator<? extends E> elements) throws IndexOutOfBoundsException {
        return insertAll(index, new Deque<>(elements));
    }

    @Override
    public Tuple<E> insertAll(int index, Collection<? extends E, ?> elements) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, getSize() + 1);

        @SuppressWarnings("unchecked")
        E[] newElements = (E[]) new Object[getSize() + elements.getSize()];
        Iterator<? extends E> other = elements.iterator();

        for (int i = 0; i < index; i++) {
            newElements[i] = this.elements[i];
        }
        for (int i = 0; i < elements.getSize() && other.hasNext(); i++) {
            newElements[index + i] = other.next();
        }
        for (int i = index; i < getSize(); i++) {
            newElements[i + elements.getSize()] = this.elements[i];
        }
        return new Tuple<>(newElements, false);
    }

    @Override
    public Tuple<E> removeAll(Predicate<E> predicate) {
        int countToRemove = 0;
        for (E element : elements) {
            if (predicate.test(element)) {
                countToRemove++;
            }
        }

        if (countToRemove == 0) {
            return this;
        }

        @SuppressWarnings("unchecked")
        E[] newElements = (E[]) new Object[getSize() - countToRemove];
        int newIndex = 0;

        for (E element : elements) {
            if (!predicate.test(element)) {
                newElements[newIndex] = element;
                newIndex++;
            }
        }

        return new Tuple<>(newElements, false);
    }

    @Override
    public Tuple<E> delete(int index) {
        Objects.checkIndex(index, getSize());
        @SuppressWarnings("unchecked")
        E[] newElements = (E[]) new Object[getSize() - 1];
        int newIndex = 0;
        for (int i = 0; i < elements.length; i++) {
            if (i != index) {
                newElements[newIndex] = elements[i];
                newIndex++;
            }
        }
        return new Tuple<>(newElements, false);
    }

    @Override
    public Tuple<E> set(int index, E element) {
        Objects.checkIndex(index, getSize());
        E[] setElements = elements.clone();
        setElements[index] = element;
        return new Tuple<>(setElements, false);
    }

    /**
     * Returns a string representation of this tuple.
     * 
     * @return a string representation of this tuple
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        forEach((e) -> joiner.add(Objects.toString(e)));
        return joiner.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this tuple.
     * 
     * @param obj the reference object with which to compare
     * @return true if this tuple is the same as the obj argument, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tuple<?>) {
            return false;
        }
        Tuple<?> other = (Tuple<?>) obj;
        return Arrays.equals(elements, other.elements);
    }

    /**
     * Returns the hash code value for this tuple.
     * 
     * @return the hash code value for this tuple
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
