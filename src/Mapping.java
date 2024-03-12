import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;

/**
 * Mapping
 */
public class Mapping<T, U> implements Iterator<U> {

    private Function<T, U> function;

    private Iterator<T> iterator;

    public Mapping(Function<T, U> function, Iterator<T> iterator) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(iterator);
        this.function = function;
        this.iterator = iterator;
    }

    public Mapping(Function<T, U> function, Iterable<T> iterable) {
        this(function, Objects.requireNonNull(iterable).iterator());
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public U next() {
        return function.apply(iterator.next());
    }

}