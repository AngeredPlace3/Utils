import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Objects;

/**
 * A generic interface representing a collection of elements.
 *
 * <p>
 * A collection is a group of elements, possibly of different types, that can be
 * iterated over, checked for containment, copied, and serialized.
 * </p>
 * 
 * @param <E> the type of elements in the collection
 * @param <T> the type of the implementing class
 *
 * @see Container
 * @see Iterable
 * @see Copyable
 * @see Serializable
 */
public interface Collection<E, T extends Collection<E, T>>
        extends Container<E>, Iterable<E>, Copyable<T>, Serializable {

    /**
     * Returns the size of the collection.
     *
     * @return the number of elements in the collection
     */
    int getSize();

    /**
     * Checks if the collection is empty.
     *
     * @return {@code true} if the collection contains no elements, {@code false}
     *         otherwise
     */
    default boolean isEmpty() {
        return getSize() <= 0;
    }

    /**
     * Returns an array containing all of the elements in this collection in proper
     * order. The returned array is safe to modify independently of this
     * collection.
     *
     * @param arr the array into which the elements of this collection are to be
     *            stored, if it is big enough; otherwise, a new array of the same
     *            runtime type is allocated for this purpose
     * @return an array containing the elements of this collection
     * @throws ArrayStoreException  if the runtime type of any element in this
     *                              collection is not assignable to the runtime
     *                              type of the specified array
     * @throws NullPointerException if the specified array is null
     */
    default E[] toArray(E[] arr) {
        Objects.requireNonNull(arr);
        if (arr.length < getSize()) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) Array.newInstance(arr.getClass().getComponentType(), getSize());
            arr = newArray;
        }
        Iterator<E> elements = iterator();
        for (int i = 0; i < arr.length && elements.hasNext(); i++) {
            arr[i] = elements.next();
        }
        if (arr.length > getSize()) {
            arr[getSize()] = null;
        }
        return arr;
    }

    /**
     * Returns an array containing all of the elements in this collection in proper
     * order. The returned array is safe to modify independently of this
     * collection.
     *
     * @return an array containing all of the elements in this collection
     */
    default Object[] toArray() {
        int size = getSize();
        Object[] array = new Object[size];
        Iterator<E> elements = iterator();
        for (int i = 0; i < array.length && elements.hasNext(); i++) {
            array[i] = elements.next();
        }
        return array;
    }
}
