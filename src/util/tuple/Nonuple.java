package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing nine values.
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
 */
public class Nonuple<A, B, C, D, E, F, G, H, I> extends Tuple<Object> {

    /**
     * Constructs a nonuple with the specified values.
     *
     * @param first   the first value of the nonuple
     * @param second  the second value of the nonuple
     * @param third   the third value of the nonuple
     * @param fourth  the fourth value of the nonuple
     * @param fifth   the fifth value of the nonuple
     * @param sixth   the sixth value of the nonuple
     * @param seventh the seventh value of the nonuple
     * @param eighth  the eighth value of the nonuple
     * @param ninth   the ninth value of the nonuple
     */
    public Nonuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth, I ninth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    /**
     * Retrieves the first value of the nonuple.
     *
     * @return the first value of the nonuple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Retrieves the second value of the nonuple.
     *
     * @return the second value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Retrieves the third value of the nonuple.
     *
     * @return the third value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Retrieves the fourth value of the nonuple.
     *
     * @return the fourth value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public D getFourth() {
        return (D) get(3);
    }

    /**
     * Retrieves the fifth value of the nonuple.
     *
     * @return the fifth value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public E getFifth() {
        return (E) get(4);
    }

    /**
     * Retrieves the sixth value of the nonuple.
     *
     * @return the sixth value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public F getSixth() {
        return (F) get(5);
    }

    /**
     * Retrieves the seventh value of the nonuple.
     *
     * @return the seventh value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public G getSeventh() {
        return (G) get(6);
    }

    /**
     * Retrieves the eighth value of the nonuple.
     *
     * @return the eighth value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public H getEighth() {
        return (H) get(7);
    }

    /**
     * Retrieves the ninth value of the nonuple.
     *
     * @return the ninth value of the nonuple
     */
    @SuppressWarnings("unchecked")
    public I getNinth() {
        return (I) get(8);
    }

    // Methods for creating a new Nonuple with a specific value replaced

    /**
     * Creates a new nonuple with the specified first value and the original second, third, fourth, fifth, sixth, seventh, eighth, and ninth values.
     *
     * @param <T>    the type of the new first value
     * @param first  the new first value
     * @return a new nonuple with the specified first value and the original second, third, fourth, fifth, sixth, seventh, eighth, and ninth values
     */
    public <T> Nonuple<T, B, C, D, E, F, G, H, I> withFirst(T first) {
        return new Nonuple<>(first, getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), getNinth());
    }

    /**
     * Creates a new nonuple with the specified second value and the original first, third, fourth, fifth, sixth, seventh, eighth, and ninth values.
     *
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new nonuple with the original first, third, fourth, fifth, sixth, seventh, eighth, and ninth values and the specified second value
     */
    public <T> Nonuple<A, T, C, D, E, F, G, H, I> withSecond(T second) {
        return new Nonuple<>(getFirst(), second, getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), getNinth());
    }

    /**
     * Creates a new nonuple with the specified third value and the original first, second, fourth, fifth, sixth, seventh, eighth, and ninth values.
     *
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new nonuple with the original first, second, fourth, fifth, sixth, seventh, eighth, and ninth values and the specified third value
     */
    public <T> Nonuple<A, B, T, D, E, F, G, H, I> withThird(T third) {
        return new Nonuple<>(getFirst(), getSecond(), third, getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), getNinth());
    }

    /**
     * Creates a new nonuple with the specified fourth value and the original first, second, third, fifth, sixth, seventh, eighth, and ninth values.
     *
     * @param <T>     the type of the new fourth value
     * @param fourth  the new fourth value
     * @return a new nonuple with the original first, second, third, fifth, sixth, seventh, eighth, and ninth values and the specified fourth value
     */
    public <T> Nonuple<A, B, C, T, E, F, G, H, I> withFourth(T fourth) {
        return new Nonuple<>(getFirst(), getSecond(), getThird(), fourth, getFifth(), getSixth(), getSeventh(), getEighth(), getNinth());
    }

    /**
     * Creates a new nonuple with the specified fifth value and the original first, second, third, fourth, sixth, seventh, eighth, and ninth values.
     *
     * @param <T>    the type of the new fifth value
     * @param fifth  the new fifth value
     * @return a new nonuple with the original first, second, third, fourth, sixth, seventh, eighth, and ninth values and the specified fifth value
     */
    public <T> Nonuple<A, B, C, D, T, F, G, H, I> withFifth(T fifth) {
        return new Nonuple<>(getFirst(), getSecond(), getThird(), getFourth(), fifth, getSixth(), getSeventh(), getEighth(), getNinth());
    }

    /**
     * Creates a new nonuple with the specified sixth value and the original first, second, third, fourth, fifth, seventh, eighth, and ninth values.
     *
     * @param <T>    the type of the new sixth value
     * @param sixth  the new sixth value
     * @return a new nonuple with the original first, second, third, fourth, fifth, seventh, eighth, and ninth values and the specified sixth value
     */
    public <T> Nonuple<A, B, C, D, E, T, G, H, I> withSixth(T sixth) {
        return new Nonuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), sixth, getSeventh(), getEighth(), getNinth());
    }

    /**
     * Creates a new nonuple with the specified seventh value and the original first, second, third, fourth, fifth, sixth, eighth, and ninth values.
     *
     * @param <T>     the type of the new seventh value
     * @param seventh the new seventh value
     * @return a new nonuple with the original first, second, third, fourth, fifth, sixth, eighth, and ninth values and the specified seventh value
     */
    public <T> Nonuple<A, B, C, D, E, F, T, H, I> withSeventh(T seventh) {
        return new Nonuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), seventh, getEighth(), getNinth());
    }

    /**
     * Creates a new nonuple with the specified eighth value and the original first, second, third, fourth, fifth, sixth, seventh, and ninth values.
     *
     * @param <T>     the type of the new eighth value
     * @param eighth  the new eighth value
     * @return a new nonuple with the original first, second, third, fourth, fifth, sixth, seventh, and ninth values and the specified eighth value
     */
    public <T> Nonuple<A, B, C, D, E, F, G, T, I> withEighth(T eighth) {
        return new Nonuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), eighth, getNinth());
    }

    /**
     * Creates a new nonuple with the specified ninth value and the original first, second, third, fourth, fifth, sixth, seventh, and eighth values.
     *
     * @param <T>     the type of the new ninth value
     * @param ninth   the new ninth value
     * @return a new nonuple with the original first, second, third, fourth, fifth, sixth, seventh, and eighth values and the specified ninth value
     */
    public <T> Nonuple<A, B, C, D, E, F, G, H, T> withNinth(T ninth) {
        return new Nonuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth(), ninth);
    }
}
