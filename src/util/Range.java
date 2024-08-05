package util;

import java.util.Iterator;

import util.collections.List;

/**
 * The {@code Range} class represents a range of integers, defined by a from,
 * to, and step value.
 * It implements the {@code List<Integer>} interface, providing indexed access
 * to the range elements.
 * <p>
 * A {@code Range} object is immutable once created and supports iteration, size
 * calculation, and element access by index.
 * </p>
 */
public final class Range implements List<Integer> {

    private final int from, to, step;
    private final int size;

    /**
     * Creates a {@code Range} with a step of 1.
     *
     * @param from the starting value of the range (inclusive)
     * @param to   the ending value of the range (exclusive)
     * @return a new {@code Range} instance
     */
    public static Range of(int from, int to) {
        return new Range(from, to, 1);
    }

    /**
     * Creates a {@code Range} with the specified step.
     *
     * @param from the starting value of the range (inclusive)
     * @param to   the ending value of the range (exclusive)
     * @param step the step value by which to increment or decrement
     * @return a new {@code Range} instance
     */
    public static Range of(int from, int to, int step) {
        return new Range(from, to, step);
    }

    /**
     * Constructs a {@code Range} with the specified start, stop, and step values.
     * <p>
     * If {@code to} is less than {@code from} and {@code step} is positive, step is
     * inverted. If {@code to} is greater than {@code from} and {@code step} is
     * negative, step is inverted.
     * </p>
     *
     * @param from the starting value of the range (inclusive)
     * @param to   the ending value of the range (exclusive)
     * @param step the step value by which to increment or decrement 
     * @throws IllegalArgumentException if {@code step} is zero
     * 
     */
    public Range(int from, int to, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("step cannot be zero");
        }
        // Automatically invert step if direction doesn't match range
        if (to < from && step > 0) {
            step = -step;
        }
        if (to > from && step < 0) {
            step = -step;
        }
        this.from = from;
        this.to = to;
        this.step = step;
        this.size = (int) Math.abs(Math.ceil((to - from) / (float) step));
    }

    /**
     * Constructs a {@code Range} with the specified start and stop values.
     * The step value is determined based on the relationship between {@code from}
     * and {@code to}.
     *
     * @param from the starting value of the range (inclusive)
     * @param to   the ending value of the range (exclusive)
     */
    public Range(int from, int to) {
        this(from, to, 1);
    }

    /**
     * Returns a string representation of the {@code Range} object.
     *
     * @return a string in the format "Range [start=START, stop=STOP, step=STEP]"
     */
    @Override
    public String toString() {
        return String.format("Range [start=%s, stop=%s, step=%s]", from, to, step);
    }

    /**
     * Returns the starting value of the range.
     *
     * @return the start value
     */
    public int getFrom() {
        return from;
    }

    /**
     * Returns the ending value of the range.
     *
     * @return the stop value
     */
    public int getTo() {
        return to;
    }

    /**
     * Returns the step value of the range.
     *
     * @return the step value
     */
    public int getStep() {
        return step;
    }

    /**
     * Returns an iterator over elements of type {@code Integer}.
     * The iterator will produce integers from {@code from} (inclusive) to
     * {@code to} (exclusive), incrementing or decrementing by {@code step} on
     * each iteration.
     *
     * @return an {@code Iterator<Integer>} to iterate over the range
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int current = from;

            @Override
            public boolean hasNext() {
                if (step > 0) {
                    return current < to;
                } else {
                    return current > to;
                }
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new IllegalStateException();
                }
                int result = current;
                current += step;
                return result;
            }
        };
    }

    /**
     * Returns the number of elements in the range.
     *
     * @return the size of the range
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified position in this range.
     *
     * @param index index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
     *                                   index >= size())
     */
    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return from + index * step;
    }

}
