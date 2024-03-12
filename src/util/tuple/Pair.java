
package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing two values.
 * 
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 */
public class Pair<A, B> extends Tuple<Object> {

    /**
     * Constructs a pair with the specified first and second values.
     * 
     * @param first  the first value of the pair
     * @param second the second value of the pair
     */
    public Pair(A first, B second) {
        super(first, second);
    }

    /**
     * Retrieves the first value of the pair.
     * 
     * @return the first value of the pair
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Creates a new pair with the specified first value and the original second value.
     * 
     * @param <T>   the type of the new first value
     * @param first the new first value
     * @return a new pair with the specified first value and the original second value
     */
    public <T> Pair<T, B> withFirst(T first) {
        return new Pair<T, B>(first, getSecond());
    }

    /**
     * Retrieves the second value of the pair.
     * 
     * @return the second value of the pair
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Creates a new pair with the specified second value and the original first value.
     * 
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new pair with the original first value and the specified second value
     */
    public <T> Pair<A, T> withSecond(T second) {
        return new Pair<A, T>(getFirst(), second);
    }
}
