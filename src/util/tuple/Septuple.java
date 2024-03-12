package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing seven values.
 * 
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 * @param <D> the type of the fourth value
 * @param <E> the type of the fifth value
 * @param <F> the type of the sixth value
 * @param <G> the type of the seventh value
 */
public class Septuple<A, B, C, D, E, F, G> extends Tuple<Object> {

    /**
     * Constructs a septuple with the specified values.
     * 
     * @param first   the first value of the septuple
     * @param second  the second value of the septuple
     * @param third   the third value of the septuple
     * @param fourth  the fourth value of the septuple
     * @param fifth   the fifth value of the septuple
     * @param sixth   the sixth value of the septuple
     * @param seventh the seventh value of the septuple
     */
    public Septuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh) {
        super(first, second, third, fourth, fifth, sixth, seventh);
    }

    /**
     * Retrieves the first value of the septuple.
     * 
     * @return the first value of the septuple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Retrieves the second value of the septuple.
     * 
     * @return the second value of the septuple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Retrieves the third value of the septuple.
     * 
     * @return the third value of the septuple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Retrieves the fourth value of the septuple.
     * 
     * @return the fourth value of the septuple
     */
    @SuppressWarnings("unchecked")
    public D getFourth() {
        return (D) get(3);
    }

    /**
     * Retrieves the fifth value of the septuple.
     * 
     * @return the fifth value of the septuple
     */
    @SuppressWarnings("unchecked")
    public E getFifth() {
        return (E) get(4);
    }

    /**
     * Retrieves the sixth value of the septuple.
     * 
     * @return the sixth value of the septuple
     */
    @SuppressWarnings("unchecked")
    public F getSixth() {
        return (F) get(5);
    }

    /**
     * Retrieves the seventh value of the septuple.
     * 
     * @return the seventh value of the septuple
     */
    @SuppressWarnings("unchecked")
    public G getSeventh() {
        return (G) get(6);
    }

    /**
     * Creates a new septuple with the specified first value and the original second, third, fourth, fifth, sixth, and seventh values.
     * 
     * @param <T>    the type of the new first value
     * @param first  the new first value
     * @return a new septuple with the specified first value and the original second, third, fourth, fifth, sixth, and seventh values
     */
    public <T> Septuple<T, B, C, D, E, F, G> withFirst(T first) {
        return new Septuple<T, B, C, D, E, F, G>(first, getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh());
    }

    /**
     * Creates a new septuple with the specified second value and the original first, third, fourth, fifth, sixth, and seventh values.
     * 
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new septuple with the original first, third, fourth, fifth, sixth, and seventh values and the specified second value
     */
    public <T> Septuple<A, T, C, D, E, F, G> withSecond(T second) {
        return new Septuple<A, T, C, D, E, F, G>(getFirst(), second, getThird(), getFourth(), getFifth(), getSixth(), getSeventh());
    }

    /**
     * Creates a new septuple with the specified third value and the original first, second, fourth, fifth, sixth, and seventh values.
     * 
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new septuple with the original first, second, fourth, fifth, sixth, and seventh values and the specified third value
     */
    public <T> Septuple<A, B, T, D, E, F, G> withThird(T third) {
        return new Septuple<A, B, T, D, E, F, G>(getFirst(), getSecond(), third, getFourth(), getFifth(), getSixth(), getSeventh());
    }

    /**
     * Creates a new septuple with the specified fourth value and the original first, second, third, fifth, sixth, and seventh values.
     * 
     * @param <T>     the type of the new fourth value
     * @param fourth  the new fourth value
     * @return a new septuple with the original first, second, third, fifth, sixth, and seventh values and the specified fourth value
     */
    public <T> Septuple<A, B, C, T, E, F, G> withFourth(T fourth) {
        return new Septuple<A, B, C, T, E, F, G>(getFirst(), getSecond(), getThird(), fourth, getFifth(), getSixth(), getSeventh());
    }

    /**
     * Creates a new septuple with the specified fifth value and the original first, second, third, fourth, sixth, and seventh values.
     * 
     * @param <T>    the type of the new fifth value
     * @param fifth  the new fifth value
     * @return a new septuple with the original first, second, third, fourth, sixth, and seventh values and the specified fifth value
     */
    public <T> Septuple<A, B, C, D, T, F, G> withFifth(T fifth) {
        return new Septuple<A, B, C, D, T, F, G>(getFirst(), getSecond(), getThird(), getFourth(), fifth, getSixth(), getSeventh());
    }

    /**
     * Creates a new septuple with the specified sixth value and the original first, second, third, fourth, fifth, and seventh values.
     * 
     * @param <T>    the type of the new sixth value
     * @param sixth  the new sixth value
     * @return a new septuple with the original first, second, third, fourth, fifth, and seventh values and the specified sixth value
     */
    public <T> Septuple<A, B, C, D, E, T, G> withSixth(T sixth) {
        return new Septuple<A, B, C, D, E, T, G>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), sixth, getSeventh());
    }

    /**
     * Creates a new septuple with the specified seventh value and the original first, second, third, fourth, fifth, and sixth values.
     * 
     * @param <T>     the type of the new seventh value
     * @param seventh the new seventh value
     * @return a new septuple with the original first, second, third, fourth, fifth, and sixth values and the specified seventh value
     */
    public <T> Septuple<A, B, C, D, E, F, T> withSeventh(T seventh) {
        return new Septuple<A, B, C, D, E, F, T>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), seventh);
    }
}
