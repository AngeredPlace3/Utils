package util.collections;

/**
 * An implementation of the {@link List} interface backed by linked nodes.
 * <p>
 * A linked list provides constant time insertion and removal of elements at the
 * start and end of the list.
 * </p>
 * 
 * @param <E> the type of elements in this list
 */
public final class LinkedList<E> extends AbstractList<E> implements List<E> {
    private static class Node<E> {
        E value;
        Node<E> next, previous;
    }

    /**
     * Create a new {@link LinkedList} with the given elements.
     *
     * @param <E>      the type of elements
     * @param elements the elements
     * @return a new {@link LinkedList}
     */
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E... elements) {
        LinkedList<E> list = new LinkedList<>();
        for (E element : elements) {
            list.add(element);
        }
        return list;
    }

    private final Node<E> head, tail;
    private int size;

    /**
     * Create an empty {@link LinkedList}.
     */
    public LinkedList() {
        this(new Node<>(), new Node<>(), 0);
        head.next = tail;
        tail.previous = head;
    }

    /**
     * Create a new {@link LinkedList} with the given iterable.
     * 
     * @param iterable the iterable
     */
    public LinkedList(Iterable<E> iterable) {
        this();
        for (E element : iterable) {
            add(element);
        }
    }

    private LinkedList(Node<E> head, Node<E> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.previous = head;
        size = 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return getNode(index).value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = new Node<>();
        node.value = element;
        node.next = getNode(index);
        node.previous = node.next.previous;
        node.previous.next = node;
        node.next.previous = node;
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNode(index);
        node.previous.next = node.next;
        node.next.previous = node.previous;
        size--;
        return node.value;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E old = node.value;
        node.value = element;
        return old;
    }

    private Node<E> getNode(int index) {
        if (index > size >> 1) {
            Node<E> current = tail;
            for (int i = size - 1; i >= index; i--) {
                current = current.previous;
            }
            return current;
        } else {
            Node<E> current = head;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
            return current;
        }
    }

}
