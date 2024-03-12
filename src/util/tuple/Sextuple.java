package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing six values.
 * 
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 * @param <D> the type of the fourth value
 * @param <E> the type of the fifth value
 * @param <F> the type of the sixth value
 */
public class Sextuple<A, B, C, D, E, F> extends Tuple<Object> {

    /**
     * Constructs a sextuple with the specified values.
     * 
     * @param first  the first value of the sextuple
     * @param second the second value of the sextuple
     * @param third  the third value of the sextuple
     * @param fourth the fourth value of the sextuple
     * @param fifth  the fifth value of the sextuple
     * @param sixth  the sixth value of the sextuple
     */
    public Sextuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth, sixth);
    }

    /**
     * Retrieves the first value of the sextuple.
     * 
     * @return the first value of the sextuple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Retrieves the second value of the sextuple.
     * 
     * @return the second value of the sextuple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Retrieves the third value of the sextuple.
     * 
     * @return the third value of the sextuple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Retrieves the fourth value of the sextuple.
     * 
     * @return the fourth value of the sextuple
     */
    @SuppressWarnings("unchecked")
    public D getFourth() {
        return (D) get(3);
    }

    /**
     * Retrieves the fifth value of the sextuple.
     * 
     * @return the fifth value of the sextuple
     */
    @SuppressWarnings("unchecked")
    public E getFifth() {
        return (E) get(4);
    }

    /**
     * Retrieves the sixth value of the sextuple.
     * 
     * @return the sixth value of the sextuple
     */
    @SuppressWarnings("unchecked")
    public F getSixth() {
        return (F) get(5);
    }

    /**
     * Creates a new sextuple with the specified first value and the original second, third, fourth, fifth, and sixth values.
     * 
     * @param <T>   the type of the new first value
     * @param first the new first value
     * @return a new sextuple with the specified first value and the original second, third, fourth, fifth, and sixth values
     */
    public <T> Sextuple<T, B, C, D, E, F> withFirst(T first) {
        return new Sextuple<T, B, C, D, E, F>(first, getSecond(), getThird(), getFourth(), getFifth(), getSixth());
    }

    /**
     * Creates a new sextuple with the specified second value and the original first, third, fourth, fifth, and sixth values.
     * 
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new sextuple with the original first, third, fourth, fifth, and sixth values and the specified second value
     */
    public <T> Sextuple<A, T, C, D, E, F> withSecond(T second) {
        return new Sextuple<A, T, C, D, E, F>(getFirst(), second, getThird(), getFourth(), getFifth(), getSixth());
    }

    /**
     * Creates a new sextuple with the specified third value and the original first, second, fourth, fifth, and sixth values.
     * 
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new sextuple with the original first, second, fourth, fifth, and sixth values and the specified third value
     */
    public <T> Sextuple<A, B, T, D, E, F> withThird(T third) {
        return new Sextuple<A, B, T, D, E, F>(getFirst(), getSecond(), third, getFourth(), getFifth(), getSixth());
    }

    /**
     * Creates a new sextuple with the specified fourth value and the original first, second, third, fifth, and sixth values.
     * 
     * @param <T>     the type of the new fourth value
     * @param fourth  the new fourth value
     * @return a new sextuple with the original first, second, third, fifth, and sixth values and the specified fourth value
     */
    public <T> Sextuple<A, B, C, T, E, F> withFourth(T fourth) {
        return new Sextuple<A, B, C, T, E, F>(getFirst(), getSecond(), getThird(), fourth, getFifth(), getSixth());
    }

    /**
     * Creates a new sextuple with the specified fifth value and the original first, second, third, fourth, and sixth values.
     * 
     * @param <T>    the type of the new fifth value
     * @param fifth  the new fifth value
     * @return a new sextuple with the original first, second, third, fourth, and sixth values and the specified fifth value
     */
    public <T> Sextuple<A, B, C, D, T, F> withFifth(T fifth) {
        return new Sextuple<A, B, C, D, T, F>(getFirst(), getSecond(), getThird(), getFourth(), fifth, getSixth());
    }

    /**
     * Creates a new sextuple with the specified sixth value and the original first, second, third, fourth, and fifth values.
     * 
     * @param <T>    the type of the new sixth value
     * @param sixth  the new sixth value
     * @return a new sextuple with the original first, second, third, fourth, and fifth values and the specified sixth value
     */
    public <T> Sextuple<A, B, C, D, E, T> withSixth(T sixth) {
        return new Sextuple<A, B, C, D, E, T>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), sixth);
    }
}
