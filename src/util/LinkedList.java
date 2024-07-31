package util;

import java.util.Iterator;

public class LinkedList<T> extends List<T> {

    private class Node {
        T value;
        Node next;
        Node previous;
    }

    private int size = 0;
    private Node head;
    private Node tail;

    private LinkedList(int size, LinkedList<T>.Node head, LinkedList<T>.Node tail) {
        this.size = size;
        this.head = head;
        this.tail = tail;
    }

    public LinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.previous = this.head;
        size = 0;
    }

    @Override
    public void set(int index, T item) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        getNodeAt(index).value = item;
    }

    @Override
    public void insert(int index, T item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d]", index, size));
        }

        Node n = new Node();
        n.value = item;
        n.next = getNodeAt(index);
        n.previous = n.next.previous;
        n.previous.next = n;
        n.next.previous = n;
        size++;
    }

    @Override
    public void insertAll(int index, Iterable<T> items) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d]", index, size));
        }
        Node after = getNodeAt(index);
        for (T item : items) {
            Node n = new Node();
            n.value = item;
            n.next = after;
            n.previous = after.previous;
            n.previous.next = n;
            n.next.previous = n;
            size++;
        }
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }

        Node n = getNodeAt(index);

        n.previous.next = n.next;
        n.next.previous = n.previous;
        size--;

        return n.value;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        return getNodeAt(index).value;
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.previous = head;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {

        class LinkedListIterator implements Iterator<T> {

            private Node current = head.next;

            @Override
            public boolean hasNext() {
                return current != tail;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        }

        return new LinkedListIterator();
    }

    private Node getNodeAt(int index) {
        if (index > size / 2) {
            Node n = tail;
            for (int i = size - 1; i >= index; i--) {
                n = n.previous;
            }
            return n;
        } else {
            Node n = head;
            for (int i = 0; i <= index; i++) {
                n = n.next;
            }
            return n;
        }
    }

    @Override
    public LinkedList<T> sub(int start, int end) {
        if (start < 0 || end > size || start > end) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d]", start, end));
        }
        return new LinkedList<>(end - start, getNodeAt(start - 1), getNodeAt(end));
    }

}
