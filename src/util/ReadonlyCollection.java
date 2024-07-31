package util;

public interface ReadonlyCollection<T> extends Iterable<T> {
    int count();
    default boolean isEmpty() {
        return count() == 0;
    }
}
