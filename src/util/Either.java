package util;

import java.util.Objects;
import java.util.Optional;

public class Either<T, U> {
    private Object value;
    private boolean isLeft;

    private Either(Object value, boolean isLeft) {
        Objects.requireNonNull(value);
        this.value = value;
        this.isLeft = isLeft;
    }

    public static <T, U> Either<T, U> left(T value) {
        return new Either<>(value, true);
    }

    public static <T, U> Either<T, U> right(U value) {
        return new Either<>(value, false);
    }

    @SuppressWarnings("unchecked")
    public Optional<T> left() {
        if (isLeft) {
            return Optional.of((T) value);
        } else {
            return Optional.empty();
        }
    }

    @SuppressWarnings("unchecked")
    public Optional<U> right() {
        if (!isLeft) {
            return Optional.of((U) value);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return Objects.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(value, obj);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
