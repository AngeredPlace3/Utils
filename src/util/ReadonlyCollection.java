package util;

import java.util.function.Predicate;

public interface ReadonlyCollection<T> extends Iterable<T> {

    int count();

    default boolean isEmpty() {
        return count() == 0;
    }

    default boolean matchesAny(Predicate<T> predicate) {
        for (T item : this) {
            if (predicate.test(item)) {
                return true;
            }
        }
        return false;
    }

    default boolean matchesAll(Predicate<T> predicate) {
        for (T item : this) {
            if (!predicate.test(item)) {
                return false;
            }
        }
        return true;
    }

}