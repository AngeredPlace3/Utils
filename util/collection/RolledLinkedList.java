package util.collection;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class RolledLinkedList<T> extends List<T> {

    private class Node {
        Node next, previous;
        T[] values;
        int size;

        @SuppressWarnings("unchecked")
        Node() {
            values = (T[]) new Object[nodeCapacity];
            size = 0;
        }

        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(", ", "[", "]");
            for (int i = 0; i < size; i++) {
                joiner.add(values[i].toString());
            }
            return joiner.toString();
        }

        void insert(int index, T value) {

            if (index == 0 && size == values.length) {
                if (previous == null) {
                    previous = new Node();
                    previous.next = this;
                }
                previous.insert(0, value);
                if (head == this)
                    head = previous;
                return;
            }

            if (index > size && next != null) {
                next.insert(index - size, value);
                return;
            }

            if (size == values.length) {
                if (next == null) {
                    next = new Node();
                    next.previous = this;
                }
            }

            shiftRight(index);
            values[index] = value;
            size++;
        }

        void shiftRight(int index) {
            if (size == values.length) {
                if (next == null) {
                    next = new Node();
                    next.previous = this;
                }
                next.shiftRight(0);
                next.values[0] = values[values.length - 1];
                next.size++;
                size--;
            }
            for (int i = Math.min(size - 1, values.length - 2); i >= index; i--) {
                values[i + 1] = values[i];
            }
        }

        T remove(int index) {
            if (index >= size && next != null) {
                return next.remove(index - size);
            }

            T value = values[index];
            for (int i = index; i < size - 1; i++) {
                values[i] = values[i + 1];
            }

            size--;

            if (size == 0 && next != null) {
                if (head == this) {
                    head = next;
                } else if (previous != null) {
                    previous.next = next;
                }
                if (next != null) {
                    next.previous = previous;
                }
            }
            return value;
        }

    }

    private Node head;
    private int size;
    private int nodeCapacity;

    private static final int DEFAULT_NODE_CAPACITY = 10;

    public RolledLinkedList(int nodeCapacity) {
        this.nodeCapacity = nodeCapacity;
        head = new Node();
        size = 0;
    }

    public RolledLinkedList() {
        this(DEFAULT_NODE_CAPACITY);
    }

    @Override
    public void set(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }

    }

    @Override
    public void insert(int index, T value) throws IndexOutOfBoundsException {
        head.insert(index, value);
        size++;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        T value = head.remove(index);
        size--;
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    public String toDebugString() {
        StringJoiner joiner = new StringJoiner(" -> ", "[", "]");
        Node node = head;
        while (node != null) {
            StringJoiner nodeJoiner = new StringJoiner(", ", "[", "]");
            for (int i = 0; i < node.size; i++) {
                nodeJoiner.add(Objects.toString(node.values[i]));
            }
            joiner.add(nodeJoiner.toString());
            node = node.next;
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        RolledLinkedList<Integer> list = new RolledLinkedList<>();

        for (int i = 1; i <= 20; i++) {
            list.prepend(i);
            System.out.println(list.toDebugString() + " " + list.getSize());
        }

        for (int i = 11; i <= 20; i++) {
            list.insert(5, i * 100);
            System.out.println(list.toDebugString() + " " + list.getSize());
        }

        System.out.println(list);

        for (int i = 1; i <= 20; i++) {
            list.remove(5);
            System.out.println(list.toDebugString() + " " + list.getSize());
        }

        System.out.println(list);
    }

    @Override
    public Iterator<T> iterator() {
        class RolledLinkedListIterator implements Iterator<T> {

            private Node current = head;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return current.next != null || index < current.size;
            }

            @Override
            public T next() {
                T value = current.values[index++];
                if (index == current.size && current.next != null) {
                    current = current.next;
                    index = 0;
                }
                return value;
            }
        }

        return new RolledLinkedListIterator();
    }

}
