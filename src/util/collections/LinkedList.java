package util.collections;

import java.util.Iterator;

public class LinkedList<T> extends AbstractList<T> {
    private class Node {
        T value;
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = new Node();
        tail = new Node();
        clear();
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = new Node();
        node.value = value;
        node.next = getNode(index);
        node.prev = node.next.prev;
        node.prev.next = node;
        node.next.prev = node;
        size++;
    }

    @Override
    public T set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        T oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.value;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).value;
    }

    @Override
    public int size() {
        return size;
    }

    private Node getNode(int index) {
        if (index > size / 2) {
            Node current = tail.prev;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        } else {
            Node current = head;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
            return current;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            Node current = head.next;

            @Override
            public boolean hasNext() {
                return current != tail;
            }

            @Override
            public T next() {
                T result = current.value;
                current = current.next;
                return result;
            }

        };
    }
}
