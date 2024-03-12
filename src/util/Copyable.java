package util;
/**
 * A generic interface for objects that support copying, allowing them to create
 * copies of themselves.
 *
 * @param <T> the type of the implementing class
 */
public interface Copyable<T extends Copyable<T>> {

    /**
     * Creates a copy of this object.
     *
     * @return a new instance of the implementing type containing the same data
     */
    T copy();
}
