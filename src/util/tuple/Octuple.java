package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing eight values.
 *
 * @param <A> the type of the first value
 * @param <B> the type of the second value
 * @param <C> the type of the third value
 * @param <D> the type of the fourth value
 * @param <E> the type of the fifth value
 * @param <F> the type of the sixth value
 * @param <G> the type of the seventh value
 * @param <H> the type of the eighth value
 */
public class Octuple<A, B, C, D, E, F, G, H> extends Tuple<Object> {

    /**
     * Constructs an octuple with the specified values.
     *
     * @param first   the first value of the octuple
     * @param second  the second value of the octuple
     * @param third   the third value of the octuple
     * @param fourth  the fourth value of the octuple
     * @param fifth   the fifth value of the octuple
     * @param sixth   the sixth value of the octuple
     * @param seventh the seventh value of the octuple
     * @param eighth  the eighth value of the octuple
     */
    public Octuple(A first, B second, C third, D fourth, E fifth, F sixth, G seventh, H eighth) {
        super(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    /**
     * Retrieves the first value of the octuple.
     *
     * @return the first value of the octuple
     */
    @SuppressWarnings("unchecked")
    @Override
    public A getFirst() {
        return (A) get(0);
    }

    /**
     * Retrieves the second value of the octuple.
     *
     * @return the second value of the octuple
     */
    @SuppressWarnings("unchecked")
    public B getSecond() {
        return (B) get(1);
    }

    /**
     * Retrieves the third value of the octuple.
     *
     * @return the third value of the octuple
     */
    @SuppressWarnings("unchecked")
    public C getThird() {
        return (C) get(2);
    }

    /**
     * Retrieves the fourth value of the octuple.
     *
     * @return the fourth value of the octuple
     */
    @SuppressWarnings("unchecked")
    public D getFourth() {
        return (D) get(3);
    }

    /**
     * Retrieves the fifth value of the octuple.
     *
     * @return the fifth value of the octuple
     */
    @SuppressWarnings("unchecked")
    public E getFifth() {
        return (E) get(4);
    }

    /**
     * Retrieves the sixth value of the octuple.
     *
     * @return the sixth value of the octuple
     */
    @SuppressWarnings("unchecked")
    public F getSixth() {
        return (F) get(5);
    }

    /**
     * Retrieves the seventh value of the octuple.
     *
     * @return the seventh value of the octuple
     */
    @SuppressWarnings("unchecked")
    public G getSeventh() {
        return (G) get(6);
    }

    /**
     * Retrieves the eighth value of the octuple.
     *
     * @return the eighth value of the octuple
     */
    @SuppressWarnings("unchecked")
    public H getEighth() {
        return (H) get(7);
    }

    /**
     * Creates a new octuple with the specified first value and the original second, third, fourth, fifth, sixth, seventh, and eighth values.
     *
     * @param <T>    the type of the new first value
     * @param first  the new first value
     * @return a new octuple with the specified first value and the original second, third, fourth, fifth, sixth, seventh, and eighth values
     */
    public <T> Octuple<T, B, C, D, E, F, G, H> withFirst(T first) {
        return new Octuple<>(first, getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth());
    }

    /**
     * Creates a new octuple with the specified second value and the original first, third, fourth, fifth, sixth, seventh, and eighth values.
     *
     * @param <T>    the type of the new second value
     * @param second the new second value
     * @return a new octuple with the original first, third, fourth, fifth, sixth, seventh, and eighth values and the specified second value
     */
    public <T> Octuple<A, T, C, D, E, F, G, H> withSecond(T second) {
        return new Octuple<>(getFirst(), second, getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), getEighth());
    }

    /**
     * Creates a new octuple with the specified third value and the original first, second, fourth, fifth, sixth, seventh, and eighth values.
     *
     * @param <T>    the type of the new third value
     * @param third  the new third value
     * @return a new octuple with the original first, second, fourth, fifth, sixth, seventh, and eighth values and the specified third value
     */
    public <T> Octuple<A, B, T, D, E, F, G, H> withThird(T third) {
        return new Octuple<>(getFirst(), getSecond(), third, getFourth(), getFifth(), getSixth(), getSeventh(), getEighth());
    }

    /**
     * Creates a new octuple with the specified fourth value and the original first, second, third, fifth, sixth, seventh, and eighth values.
     *
     * @param <T>     the type of the new fourth value
     * @param fourth  the new fourth value
     * @return a new octuple with the original first, second, third, fifth, sixth, seventh, and eighth values and the specified fourth value
     */
    public <T> Octuple<A, B, C, T, E, F, G, H> withFourth(T fourth) {
        return new Octuple<>(getFirst(), getSecond(), getThird(), fourth, getFifth(), getSixth(), getSeventh(), getEighth());
    }

    /**
     * Creates a new octuple with the specified fifth value and the original first, second, third, fourth, sixth, seventh, and eighth values.
     *
     * @param <T>    the type of the new fifth value
     * @param fifth  the new fifth value
     * @return a new octuple with the original first, second, third, fourth, sixth, seventh, and eighth values and the specified fifth value
     */
    public <T> Octuple<A, B, C, D, T, F, G, H> withFifth(T fifth) {
        return new Octuple<>(getFirst(), getSecond(), getThird(), getFourth(), fifth, getSixth(), getSeventh(), getEighth());
    }

    /**
     * Creates a new octuple with the specified sixth value and the original first, second, third, fourth, fifth, seventh, and eighth values.
     *
     * @param <T>    the type of the new sixth value
     * @param sixth  the new sixth value
     * @return a new octuple with the original first, second, third, fourth, fifth, seventh, and eighth values and the specified sixth value
     */
    public <T> Octuple<A, B, C, D, E, T, G, H> withSixth(T sixth) {
        return new Octuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), sixth, getSeventh(), getEighth());
    }

    /**
     * Creates a new octuple with the specified seventh value and the original first, second, third, fourth, fifth, sixth, and eighth values.
     *
     * @param <T>     the type of the new seventh value
     * @param seventh the new seventh value
     * @return a new octuple with the original first, second, third, fourth, fifth, sixth, and eighth values and the specified seventh value
     */
    public <T> Octuple<A, B, C, D, E, F, T, H> withSeventh(T seventh) {
        return new Octuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), seventh, getEighth());
    }

    /**
     * Creates a new octuple with the specified eighth value and the original first, second, third, fourth, fifth, sixth, and seventh values.
     *
     * @param <T>     the type of the new eighth value
     * @param eighth  the new eighth value
     * @return a new octuple with the original first, second, third, fourth, fifth, sixth, and seventh values and the specified eighth value
     */
    public <T> Octuple<A, B, C, D, E, F, G, T> withEighth(T eighth) {
        return new Octuple<>(getFirst(), getSecond(), getThird(), getFourth(), getFifth(), getSixth(), getSeventh(), eighth);
    }
}
