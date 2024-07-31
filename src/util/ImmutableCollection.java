package util;

public interface ImmutableCollection<T> extends ReadonlyCollection<T> {
    ImmutableCollection<T> clear();
}
