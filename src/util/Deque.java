package util;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class Deque<E> implements MutableSequence<E, Deque<E>> {

    private class Node {
        E value;
        Node next;
        Node previous;

        public Node(E value) {
            super();
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        super();
        clear();
    }

    public Deque(Iterator<E> elements) {
        this();
        appendAll(elements);
    }

    @SuppressWarnings("unchecked")
    public Deque(E... elements) {
        this();
        for (E element : elements) {
            append(element);
        }
    }

    public Deque(Iterable<E> elements) {
        this();
        appendAll(elements);
    }

    public Deque(Collection<E, ?> elements) {
        this();
        appendAll(elements);
    }

    private Node getNodeAtIndex(int index) {
        Objects.checkIndex(index, getSize());
        Node current;
        if (index < getSize() / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = getSize() - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return getNodeAtIndex(index).value;
    }

    @Override
    public Deque<E> slice(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        Objects.checkFromToIndex(fromIndex, toIndex, size);

        Deque<E> slicedDeque = new Deque<>();
        Node current = getNodeAtIndex(fromIndex);

        // Iterate through the deque from the starting index to the ending index
        for (int i = fromIndex; i < toIndex; i++) {
            slicedDeque.append(current.value);
            current = current.next;
        }

        return slicedDeque;
    }

    @Override
    public Deque<E> reversed(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        return new Deque<E>(reverseIterator());
    }

    @Override
    public Deque<E> sorted(Comparator<? super E> comparator, int fromIndex, int toIndex)
            throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sorted'");
    }

    @Override
    public Deque<E> cleared() {
        return new Deque<>();
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(E element) {
        Node current = head;

        // Iterate through the deque to find the element
        while (current != null) {
            if (Objects.equals(current.value, element)) {
                return true; // Element found
            }
            current = current.next;
        }

        return false; // Element not found
    }

    @Override
    public Deque<E> copy() {
        Deque<E> copiedDeque = new Deque<>();
        Node current = head;

        // Iterate through the original deque and append each element to the copied
        // deque
        while (current != null) {
            copiedDeque.append(current.value);
            current = current.next;
        }

        return copiedDeque;
    }

    @Override
    public void insert(int index, E element) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, getSize() + 1);

        if (index == 0) {
            prepend(element);
        } else if (index == size) {
            append(element);
        } else {
            Node current = getNodeAtIndex(index);
            Node newNode = new Node(element);
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }
    }

    @Override
    public void prepend(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void append(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void insertAll(int index, Iterator<? extends E> elements) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, getSize() + 1);

        // Get the node at the specified index
        Node nextNode = (index == size) ? null : getNodeAtIndex(index);
        Node previousNode = (nextNode == null) ? tail : nextNode.previous;

        // Insert elements one by one
        while (elements.hasNext()) {
            E element = elements.next();
            Node newNode = new Node(element);

            // Connect the new node with the existing nodes
            if (previousNode != null) {
                previousNode.next = newNode;
            } else {
                // Update head if inserting at the beginning
                head = newNode;
            }

            newNode.previous = previousNode;
            newNode.next = nextNode;

            if (nextNode != null) {
                nextNode.previous = newNode;
            } else {
                // Update tail if inserting at the end
                tail = newNode;
            }

            previousNode = newNode;
            size++;
        }
    }

    @Override
    public boolean removeAll(Predicate<E> predicate) {
        boolean removed = false;
        Node current = head;

        // Iterate through the deque
        while (current != null) {
            Node next = current.next;

            // Check if the current node's value satisfies the predicate
            if (predicate.test(current.value)) {
                // Remove the current node
                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next; // Update head if deleting the first node
                }

                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous; // Update tail if deleting the last node
                }

                size--;
                removed = true;
            }

            current = next;
        }

        return removed;
    }

    @Override
    public E delete(int index) {
        Objects.checkIndex(index, size);

        Node nodeToDelete = getNodeAtIndex(index);

        // Update previous node's next reference
        if (nodeToDelete.previous != null) {
            nodeToDelete.previous.next = nodeToDelete.next;
        } else {
            // Update head if deleting the first node
            head = nodeToDelete.next;
        }

        // Update next node's previous reference
        if (nodeToDelete.next != null) {
            nodeToDelete.next.previous = nodeToDelete.previous;
        } else {
            // Update tail if deleting the last node
            tail = nodeToDelete.previous;
        }

        size--;

        return nodeToDelete.value;
    }

    @Override
    public void set(int index, E element) {
        getNodeAtIndex(index).value = element;
    }

    @Override
    public void sort(Comparator<? super E> comparator) {
        // TODO: Use a heap lol
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

    @Override
    public void reverse() {
        if (isEmpty() || size == 1) {
            return;
        }

        Node temp = null;
        Node current = head;

        // Swap previous and next references for each node
        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }

        // Swap head and tail references
        temp = head;
        head = tail;
        tail = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public Iterator<E> reverseIterator() {
        return new Iterator<E>() {
            private Node current = tail;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                E value = current.value;
                current = current.previous;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        forEach(e -> joiner.add(Objects.toString(e)));
        return joiner.toString();
    }

    public static void main(String[] args) {

        
        System.out.println(new Deque<>(new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index <= 100;
            }

            @Override
            public Object next() {
                return 2 * (index++);
            }

        }));
    }

}
