package util.collections;

import java.util.Arrays;

/**
 * An implementation of the {@link List} interface backed by an array.
 * <p>
 * An array list provides constant time random access to elements.
 * </p>
 * 
 * @param <E> the type of elements in this list
 */
public final class ArrayList<E> extends AbstractList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private E[] array;
	private int size;

	/**
	 * Create an array list with the specified initial capacity.
	 * 
	 * @param initialCapacity the initial capacity
	 */
	public ArrayList(int initialCapacity) {
		if (initialCapacity <= 0) {
			throw new IllegalArgumentException();
		}
		ensureCapacity(initialCapacity);
		size = 0;
	}

	/**
	 * Create an array list with the default initial capacity of 10.
	 */
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		ensureCapacity(size + 1);
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = element;
		size++;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E old = array[index];
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;
		return old;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E old = array[index];
		array[index] = element;
		return old;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public void clear() {
		size = 0;
		Arrays.fill(array, null);
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Ensure the capacity of this array.
	 * 
	 * @param minCapacity the minimum capacity
	 */
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
		if (array == null) {
			array = (E[]) new Object[minCapacity];
		} else if (minCapacity > array.length) {
			// * 1.5
			int newCapactiy = Math.max(minCapacity, array.length + (array.length >> 1));
			array = Arrays.copyOf(array, newCapactiy);
		}
	}

	/**
	 * Returns the capacity of this array.
	 * 
	 * @return the capacity of this array
	 */
	public int getCapacity() {
		return array.length;
	}
}
