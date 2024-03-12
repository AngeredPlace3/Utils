package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing five values.
 * 
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 * @param <D> the type of the fourth value
 * @param <E> the type of the fifth value
 */
public class Quintuple<A, B, C, D, E> extends Tuple<Object> {

    /**
     * Constructs a quintuple with the specified values.
     * 
     * @param first  the first value of the quintuple
     * @param second the second value of the quintuple
     * @param third  the third value of the quintuple
     * @param fourth the fourth value of the quintuple
     * @param fifth  the fifth value of the quintuple
     */
    public Quintuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth, fifth);
    }

    /**
     * Retrieves the first value of the quintuple.
     * 
     * @return the first value of the quintuple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Retrieves the second value of the quintuple.
     * 
     * @return the second value of the quintuple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Retrieves the third value of the quintuple.
     * 
     * @return the third value of the quintuple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Retrieves the fourth value of the quintuple.
     * 
     * @return the fourth value of the quintuple
     */
    @SuppressWarnings("unchecked")
    public D getFourth() {
        return (D) get(3);
    }

    /**
     * Retrieves the fifth value of the quintuple.
     * 
     * @return the fifth value of the quintuple
     */
    @SuppressWarnings("unchecked")
    public E getFifth() {
        return (E) get(4);
    }

    /**
     * Creates a new quintuple with the specified first value and the original second, third, fourth, and fifth values.
     * 
     * @param <T>   the type of the new first value
     * @param first the new first value
     * @return a new quintuple with the specified first value and the original second, third, fourth, and fifth values
     */
    public <T> Quintuple<T, B, C, D, E> withFirst(T first) {
        return new Quintuple<T, B, C, D, E>(first, getSecond(), getThird(), getFourth(), getFifth());
    }

    /**
     * Creates a new quintuple with the specified second value and the original first, third, fourth, and fifth values.
     * 
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new quintuple with the original first, third, fourth, and fifth values and the specified second value
     */
    public <T> Quintuple<A, T, C, D, E> withSecond(T second) {
        return new Quintuple<A, T, C, D, E>(getFirst(), second, getThird(), getFourth(), getFifth());
    }

    /**
     * Creates a new quintuple with the specified third value and the original first, second, fourth, and fifth values.
     * 
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new quintuple with the original first, second, fourth, and fifth values and the specified third value
     */
    public <T> Quintuple<A, B, T, D, E> withThird(T third) {
        return new Quintuple<A, B, T, D, E>(getFirst(), getSecond(), third, getFourth(), getFifth());
    }

    /**
     * Creates a new quintuple with the specified fourth value and the original first, second, third, and fifth values.
     * 
     * @param <T>     the type of the new fourth value
     * @param fourth  the new fourth value
     * @return a new quintuple with the original first, second, third, and fifth values and the specified fourth value
     */
    public <T> Quintuple<A, B, C, T, E> withFourth(T fourth) {
        return new Quintuple<A, B, C, T, E>(getFirst(), getSecond(), getThird(), fourth, getFifth());
    }

    /**
     * Creates a new quintuple with the specified fifth value and the original first, second, third, and fourth values.
     * 
     * @param <T>    the type of the new fifth value
     * @param fifth  the new fifth value
     * @return a new quintuple with the original first, second, third, and fourth values and the specified fifth value
     */
    public <T> Quintuple<A, B, C, D, T> withFifth(T fifth) {
        return new Quintuple<A, B, C, D, T>(getFirst(), getSecond(), getThird(), getFourth(), fifth);
    }
}
