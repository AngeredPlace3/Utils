package util.tuple;

import util.Tuple;

/**
 * Represents a tuple containing a single value.
 * 
 * @param <A> the type of the value contained in the unit
 */
public class Unit<A> extends Tuple<Object> {

    /**
     * Constructs a unit with the specified value.
     * 
     * @param value the value to be contained in the unit
     */
    public Unit(A value) {
        super(value);
    }

    /**
     * Retrieves the value contained in the unit.
     * 
     * @return the value contained in the unit
     */
    @SuppressWarnings("unchecked")
    public A getValue() {
        return (A) get(0);
    }

    /**
     * Creates a new unit with the specified value.
     * 
     * @param <T>   the type of the new value
     * @param value the value to be contained in the new unit
     * @return a new unit containing the specified value
     */
    public <T> Unit<T> withValue(T value) {
        return new Unit<>(value);
    }
}
