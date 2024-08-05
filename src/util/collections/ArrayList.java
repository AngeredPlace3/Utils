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
public final class ArrayList<E> extends AbstractList<E> implements List<E>, DynamicArray {
	private static final int DEFAULT_CAPACITY = 10;
	private E[] array;
	private int size;

	/**
	 * Create an {@link ArrayList} with the specified elements.
	 * 
	 * @param <E>      the type of elements
	 * @param elements the elements
	 * @return a new {@link ArrayList}
	 */
	@SuppressWarnings("unchecked")
	public static <E> ArrayList<E> of(E... elements) {
		ArrayList<E> list = new ArrayList<>(elements.length);
		for (E element : elements) {
			list.add(element);
		}
		return list;
	}

	/**
	 * Create an {@link ArrayList} with the specified initial capacity.
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
	 * Create an {@link ArrayList} with the specified iterable.
	 * 
	 * @param iterable the iterable
	 */
	public ArrayList(Iterable<E> iterable) {
		if (iterable instanceof ReadOnlyCollection<E> collection) {
			ensureCapacity(collection.size());
		} else {
			ensureCapacity(DEFAULT_CAPACITY);
		}
		for (E element : iterable) {
			addLast(element);
		}
	}

	/**
	 * Create an {@link ArrayList} with the default initial capacity of 10.
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
		Arrays.fill(array, null);
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Ensures that the list has at least the given capacity.
	 * 
	 * @param minCapacity the minimum capacity
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void ensureCapacity(int minCapacity) {
		if (array == null) {
			array = (E[]) new Object[Math.max(minCapacity, 1)];
		} else if (minCapacity > array.length) {
			// * 1.5
			int newCapactiy = Math.max(minCapacity, array.length + (array.length >> 1));
			E[] newArray = (E[]) new Object[newCapactiy];
			System.arraycopy(array, 0, newArray, 0, size);
			array = newArray;
		}
	}

	/**
	 * Returns the current capacity of this list.
	 * 
	 * @return the current capacity
	 */
	@Override
	public int getCapacity() {
		if (array == null) {
			return 0;
		}
		return array.length;
	}
}
