package util.collections;

public interface DynamicArray {
    /**
     * Returns the current capacity of the array.
     * 
     * @return the current capacity
     */
    int getCapacity();

    /**
     * Ensures that the array has at least the given capacity.
     * 
     * @param capacity the minimum capacity
     */
    void ensureCapacity(int capacity);
}
