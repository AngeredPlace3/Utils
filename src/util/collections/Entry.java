package util.collections;

import java.util.Objects;

public final class Entry<K, V> {
    private final K key;
    private final V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Entry))
            return false;
        Entry<?, ?> other = (Entry<?, ?>) obj;
        return Objects.equals(key, other.key) && Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return String.format("Entry [key=%s, value=%s]", key, value);
    }

}
