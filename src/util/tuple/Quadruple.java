package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing four values.
 * 
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 * @param <D> the type of the fourth value
 */
public class Quadruple<A, B, C, D> extends Tuple<Object> {

    /**
     * Constructs a quadruple with the specified values.
     * 
     * @param first  the first value of the quadruple
     * @param second the second value of the quadruple
     * @param third  the third value of the quadruple
     * @param fourth the fourth value of the quadruple
     */
    public Quadruple(A first, B second, C third, D fourth) {
        super(first, second, third, fourth);
    }

    /**
     * Retrieves the first value of the quadruple.
     * 
     * @return the first value of the quadruple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Creates a new quadruple with the specified first value and the original second, third, and fourth values.
     * 
     * @param <T>   the type of the new first value
     * @param first the new first value
     * @return a new quadruple with the specified first value and the original second, third, and fourth values
     */
    public <T> Quadruple<T, B, C, D> withFirst(T first) {
        return new Quadruple<T, B, C, D>(first, getSecond(), getThird(), getFourth());
    }

    /**
     * Retrieves the second value of the quadruple.
     * 
     * @return the second value of the quadruple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Creates a new quadruple with the specified second value and the original first, third, and fourth values.
     * 
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new quadruple with the original first, third, and fourth values and the specified second value
     */
    public <T> Quadruple<A, T, C, D> withSecond(T second) {
        return new Quadruple<A, T, C, D>(getFirst(), second, getThird(), getFourth());
    }

    /**
     * Retrieves the third value of the quadruple.
     * 
     * @return the third value of the quadruple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Creates a new quadruple with the specified third value and the original first, second, and fourth values.
     * 
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new quadruple with the original first, second, and fourth values and the specified third value
     */
    public <T> Quadruple<A, B, T, D> withThird(T third) {
        return new Quadruple<A, B, T, D>(getFirst(), getSecond(), third, getFourth());
    }

    /**
     * Retrieves the fourth value of the quadruple.
     * 
     * @return the fourth value of the quadruple
     */
    @SuppressWarnings("unchecked")
    public D getFourth() {
        return (D) get(3);
    }

    /**
     * Creates a new quadruple with the specified fourth value and the original first, second, and third values.
     * 
     * @param <T>     the type of the new fourth value
     * @param fourth  the new fourth value
     * @return a new quadruple with the original first, second, and third values and the specified fourth value
     */
    public <T> Quadruple<A, B, C, T> withFourth(T fourth) {
        return new Quadruple<A, B, C, T>(getFirst(), getSecond(), getThird(), fourth);
    }
}
