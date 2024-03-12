package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing 3 values.
 * 
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 */
public class Triple<A, B, C> extends Tuple<Object> {

    /**
     * Constructs a triple with the specified values.
     * 
     * @param first  the first value of the triple
     * @param second the second value of the triple
     * @param third  the third value of the triple
     */
    public Triple(A first, B second, C third) {
        super(first, second, third);
    }

    /**
     * Retrieves the first value of the triple.
     * 
     * @return the first value of the triple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Creates a new triple with the specified first value and the original second and third values.
     * 
     * @param <T>   the type of the new first value
     * @param first the new first value
     * @return a new triple with the specified first value and the original second and third values
     */
    public <T> Triple<T, B, C> withFirst(T first) {
        return new Triple<T, B, C>(first, getSecond(), getThird());
    }

    /**
     * Retrieves the second value of the triple.
     * 
     * @return the second value of the triple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Creates a new triple with the specified second value and the original first and third values.
     * 
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new triple with the original first and third values and the specified second value
     */
    public <T> Triple<A, T, C> withSecond(T second) {
        return new Triple<A, T, C>(getFirst(), second, getThird());
    }

    /**
     * Retrieves the third value of the triple.
     * 
     * @return the third value of the triple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Creates a new triple with the specified third value and the original first and second values.
     * 
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new triple with the original first and second values and the specified third value
     */
    public <T> Triple<A, B, T> withThird(T third) {
        return new Triple<A, B, T>(getFirst(), getSecond(), third);
    }
}
