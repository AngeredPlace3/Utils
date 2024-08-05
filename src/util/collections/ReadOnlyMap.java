package util.collections;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

/**
 * Represents a read-only map of keys and values.
 * 
 * @param <K> the type of keys in this map
 * @param <V> the type of values in this map
 */
public interface ReadOnlyMap<K, V> extends ReadOnlyCollection<Entry<K, V>> {

    /**
     * Returns the value associated with the given key.
     * 
     * @param key the key
     * @return the value associated with the given key
     * @throws NoSuchElementException if the map does not contain the given key
     */
    V get(K key) throws NoSuchElementException;

    /**
     * Returns the value associated with the given key, or the given default
     * value if the map does not contain the given key.
     *
     * @param key          the key
     * @param defaultValue the default value
     * @return the value associated with the given key
     */
    default V getOrDefault(K key, V defaultValue) {
        return containsKey(key) ? get(key) : defaultValue;
    }

    /**
     * Returns the value associated with the given key, or the given default
     * value supplier if the map does not contain the given key.
     *
     * @param key             the key
     * @param defaultSupplier the default value supplier
     * @return the value associated with the given key
     */
    default V getOr(K key, Supplier<V> defaultSupplier) {
        return containsKey(key) ? get(key) : defaultSupplier.get();
    }

    /**
     * Returns whether this map contains the given key.
     * 
     * @param key the key
     * @return {@code true} if this map contains the given key, {@code false}
     *         otherwise
     */
    default boolean containsKey(K key) {
        for (Entry<K, V> entry : this) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether this map contains the given value.
     * 
     * @param value the value
     * @return {@code true} if this map contains the given value, {@code false}
     *         otherwise
     */
    default boolean containsValue(V value) {
        for (Entry<K, V> entry : this) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
