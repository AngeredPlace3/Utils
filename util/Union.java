package util;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Union
 */
public final class Union<T, U> {

    public static <T, U> Union<T, U> ofLeft(T value) {
        return new Union<>(value, true);
    }

    public static <T, U> Union<T, U> ofRight(U value) {
        return new Union<>(value, false);
    }

    private final Object value;
    private final boolean isLeft;

    private Union(Object value, boolean isLeft) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value = value;
        this.isLeft = isLeft;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return !isLeft;
    }

    @SuppressWarnings("unchecked")
    public Optional<T> getLeft() {
        if (!isLeft) {
            return Optional.empty();
        }
        return Optional.of((T) value);
    }

    @SuppressWarnings("unchecked")
    public Optional<U> getRight() {
        if (isLeft) {
            return Optional.empty();
        }
        return Optional.of((U) value);
    }

    @Override
    public String toString() {
        return String.format("Union [value=%s]", value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(value, obj);
    }

    @SuppressWarnings("unchecked")
    public <V> Union<V, U> mapLeft(Function<T, V> mapper) {
        if (isLeft) {
            return new Union<>(getLeft().map(mapper), true);
        }
        return (Union<V, U>) this;
    }

    @SuppressWarnings("unchecked")
    public <V> Union<V, U> flatMapLeft(Function<T, Union<V, U>> mapper) {
        if (isLeft) {
            return mapper.apply((T) value);
        }
        return (Union<V, U>) this;
    }

    @SuppressWarnings("unchecked")
    public <V> Union<T, V> mapRight(Function<U, V> mapper) {
        if (!isLeft) {
            return new Union<>(getRight().map(mapper), false);

        }
        return (Union<T, V>) this;
    }

    @SuppressWarnings("unchecked")
    public <V> Union<T, V> flatMapRight(Function<U, Union<T, V>> mapper) {
        if (!isLeft) {
            return mapper.apply((U) value);
        }
        return (Union<T, V>) this;
    }

    @SuppressWarnings("unchecked")
    public <A, B> Union<A, B> map(Function<T, A> leftMapper, Function<U, B> rightMapper) {
        if (isLeft) {
            return new Union<>(leftMapper.apply((T) value), true);
        }
        return new Union<>(rightMapper.apply((U) value), false);
    }

    @SuppressWarnings("unchecked")
    public <A, B> Union<A, B> flatMap(Function<T, Union<A, B>> leftMapper, Function<U, Union<A, B>> rightMapper) {
        if (isLeft) {
            return leftMapper.apply((T) value);
        }
        return rightMapper.apply((U) value);
    }

    @SuppressWarnings("unchecked")
    public void ifLeft(Consumer<T> action) {
        if (isLeft) {
            action.accept((T) value);
        }
    }

    @SuppressWarnings("unchecked")
    public void ifLeftOrElse(Consumer<T> leftAction, Consumer<U> rightAction) {
        if (isLeft) {
            leftAction.accept((T) value);
        } else {
            rightAction.accept((U) value);
        }
    }

    public void ifRightOrElse(Consumer<U> rightAction, Consumer<T> leftAction) {
        ifLeftOrElse(leftAction, rightAction);
    }

    @SuppressWarnings("unchecked")
    public void ifRight(Consumer<? super U> action) {
        if (!isLeft) {
            action.accept((U) value);
        }
    }

}