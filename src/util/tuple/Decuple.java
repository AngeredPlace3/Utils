package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing ten values.
 *
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 * @param <D> the type of the fourth value
 * @param <E> the type of the fifth value
 * @param <F> the type of the sixth value
 * @param <G> the type of the seventh value
 * @param <H> the type of the eighth value
 * @param <I> the type of the ninth value
 * @param <J> the type of the tenth value
 */
public class Decuple<A, B, C, D, E, F, G, H, I, J> extends Tuple<Object> {

    /**
     * Constructs a decuple with the specified values.
     *
     * @param first   the first value of the decuple
     * @param second  the second value of the decuple
     * @param third   the third value of the decuple
     * @param fourth  the fourth value of the decuple
     * @param fifth   the fifth value of the decuple
     * @param sixth   the sixth value of the decuple
     * @param seventh the seventh value of the decuple
     * @param eighth  the eighth value of the decuple
     * @param ninth   the ninth value of the decuple
     * @param tenth   the tenth value of the decuple
     */
    public Decuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Retrieves the first value of the decuple.
     *
     * @return the first value of the decuple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Retrieves the second value of the decuple.
     *
     * @return the second value of the decuple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Retrieves the third value of the decuple.
     *
     * @return the third value of the decuple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Retrieves the fourth value of the decuple.
     *
     * @return the fourth value of the decuple
     */
    @SuppressWarnings("unchecked")
    public D getFourth() {
        return (D) get(3);
    }

    /**
     * Retrieves the fifth value of the decuple.
     *
     * @return the fifth value of the decuple
     */
    @SuppressWarnings("unchecked")
    public E getFifth() {
        return (E) get(4);
    }

    /**
     * Retrieves the sixth value of the decuple.
     *
     * @return the sixth value of the decuple
     */
    @SuppressWarnings("unchecked")
    public F getSixth() {
        return (F) get(5);
    }

    /**
     * Retrieves the seventh value of the decuple.
     *
     * @return the seventh value of the decuple
     */
    @SuppressWarnings("unchecked")
    public G getSeventh() {
        return (G) get(6);
    }

    /**
     * Retrieves the eighth value of the decuple.
     *
     * @return the eighth value of the decuple
     */
    @SuppressWarnings("unchecked")
    public H getEighth() {
        return (H) get(7);
    }

    /**
     * Retrieves the ninth value of the decuple.
     *
     * @return the ninth value of the decuple
     */
    @SuppressWarnings("unchecked")
    public I getNinth() {
        return (I) get(8);
    }

    /**
     * Retrieves the tenth value of the decuple.
     *
     * @return the tenth value of the decuple
     */
    @SuppressWarnings("unchecked")
    public J getTenth() {
        return (J) get(9);
    }

    // Methods for creating a new Decuple with a specific value replaced

    /**
     * Creates a new decuple with the specified first value and the original second, third, fourth, fifth, sixth, seventh, eighth, ninth, and tenth values.
     *
     * @param <T>    the type of the new first value
     * @param first  the new first value
     * @return a new decuple with the specified first value and the original second, third, fourth, fifth, sixth, seventh, eighth, ninth, and tenth values
     */
    public <T> Decuple<T, B, C, D, E, F, G, H, I, J> withFirst(T first) {
        return new Decuple<>(first, getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified second value and the original first, third, fourth, fifth, sixth, seventh, eighth, ninth, and tenth values.
     *
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new decuple with the original first, third, fourth, fifth, sixth, seventh, eighth, ninth, and tenth values and the specified second value
     */
    public <T> Decuple<A, T, C, D, E, F, G, H, I, J> withSecond(T second) {
        return new Decuple<>(getFirst(), second, getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified third value and the original first, second, fourth, fifth, sixth, seventh, eighth, ninth, and tenth values.
     *
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new decuple with the original first, second, fourth, fifth, sixth, seventh, eighth, ninth, and tenth values and the specified third value
     */
    public <T> Decuple<A, B, T, D, E, F, G, H, I, J> withThird(T third) {
        return new Decuple<>(getFirst(), getSecond(), third, getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified fourth value and the original first, second, third, fifth, sixth, seventh, eighth, ninth, and tenth values.
     *
     * @param <T>    the type of the new fourth value
     * @param fourth the new fourth value
     * @return a new decuple with the original first, second, third, fifth, sixth, seventh, eighth, ninth, and tenth values and the specified fourth value
     */
    public <T> Decuple<A, B, C, T, E, F, G, H, I, J> withFourth(T fourth) {
        return new Decuple<>(getFirst(), getSecond(), getThird(), fourth, getFifth(), getSixth(), getSeventh(), getEighth(), getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified fifth value and the original first, second, third, fourth, sixth, seventh, eighth, ninth, and tenth values.
     *
     * @param <T>    the type of the new fifth value
     * @param fifth  the new fifth value
     * @return a new decuple with the original first, second, third, fourth, sixth, seventh, eighth, ninth, and tenth values and the specified fifth value
     */
    public <T> Decuple<A, B, C, D, T, F, G, H, I, J> withFifth(T fifth) {
        return new Decuple<>(getFirst(), getSecond(), getThird(), getFourth(), fifth, getSixth(), getSeventh(), getEighth(), getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified sixth value and the original first, second, third, fourth, fifth, seventh, eighth, ninth, and tenth values.
     *
     * @param <T>    the type of the new sixth value
     * @param sixth  the new sixth value
     * @return a new decuple with the original first, second, third, fourth, fifth, seventh, eighth, ninth, and tenth values and the specified sixth value
     */
    public <T> Decuple<A, B, C, D, E, T, G, H, I, J> withSixth(T sixth) {
        return new Decuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), sixth, getSeventh(), getEighth(), getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified seventh value and the original first, second, third, fourth, fifth, sixth, eighth, ninth, and tenth values.
     *
     * @param <T>     the type of the new seventh value
     * @param seventh the new seventh value
     * @return a new decuple with the original first, second, third, fourth, fifth, sixth, eighth, ninth, and tenth values and the specified seventh value
     */
    public <T> Decuple<A, B, C, D, E, F, T, H, I, J> withSeventh(T seventh) {
        return new Decuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), seventh, getEighth(), getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified eighth value and the original first, second, third, fourth, fifth, sixth, seventh, ninth, and tenth values.
     *
     * @param <T>     the type of the new eighth value
     * @param eighth  the new eighth value
     * @return a new decuple with the original first, second, third, fourth, fifth, sixth, seventh, ninth, and tenth values and the specified eighth value
     */
    public <T> Decuple<A, B, C, D, E, F, G, T, I, J> withEighth(T eighth) {
        return new Decuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), eighth, getNinth(), getTenth());
    }

    /**
     * Creates a new decuple with the specified ninth value and the original first, second, third, fourth, fifth, sixth, seventh, eighth, and tenth values.
     *
     * @param <T>     the type of the new ninth value
     * @param ninth   the new ninth value
     * @return a new decuple with the original first, second, third, fourth, fifth, sixth, seventh, eighth, and tenth values and the specified ninth value
     */
    public <T> Decuple<A, B, C, D, E, F, G, H, T, J> withNinth(T ninth) {
        return new Decuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), ninth, getTenth());
    }

    /**
     * Creates a new decuple with the specified tenth value and the original first, second, third, fourth, fifth, sixth, seventh, eighth, and ninth values.
     *
     * @param <T>     the type of the new tenth value
     * @param tenth   the new tenth value
     * @return a new decuple with the original first, second, third, fourth, fifth, sixth, seventh, eighth, and ninth values and the specified tenth value
     */
    public <T> Decuple<A, B, C, D, E, F, G, H, I, T> withTenth(T tenth) {
        return new Decuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), getNinth(), tenth);
    }
}
