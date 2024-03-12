import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class Tuple<E> implements ImmutableSequence<E, Tuple<E>> {
    private final E[] elements;

    private static final Tuple<?> EMPTY = new Tuple<>(null, false);

    @SuppressWarnings("unchecked")
    public static <T> Tuple<T> of() {
        return (Tuple<T>) EMPTY;
    }

    @SuppressWarnings("unchecked")
    public Tuple(E... elements) {
        this(elements, true);
    }

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

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        forEach((e) -> joiner.add(Objects.toString(e)));
        return joiner.toString();
    }
}
