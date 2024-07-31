package util;

import java.util.Objects;

public class LinkedList<T> extends List<T> {

    private class Node {
        T item;
        Node next, previous;
    }

    public LinkedList() {
        clear();
    }

    private Node head = new Node(), tail = new Node();
    private int size = 0;

    private LinkedList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node node = getNode(index);
        return node.item;
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public void insert(T item, int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size + 1);
        size++;
        Node node = new Node();
        node.item = item;
        Node previous = getNode(index);
        node.next = previous;
        node.previous = previous.previous;
        previous.previous.next = node;
        previous.previous = node;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size);
        size--;
        Node node = getNode(index);
        node.previous.next = node.next;
        node.next.previous = node.previous;
        return node.item;
    }

    @Override
    public T set(int index, T item) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size);
        Node node = getNode(index);
        T old = node.item;
        node.item = item;
        return old;
    }

    private Node getNode(int index) {
        if (index > size / 2) {
            Node current = tail;
            for (int i = size - 1; i >= index && current.previous != null; i--) {
                current = current.previous;
            }
            return current;
        } else {
            Node current = head;
            for (int i = 0; i <= index && current.next != null; i++) {
                current = current.next;
            }
            return current;
        }
    }

    @Override
    public LinkedList<T> sub(int from, int to) throws IndexOutOfBoundsException {
        Objects.checkFromToIndex(from, to, size);
        return new LinkedList<>(getNode(from - 1), getNode(to), to - from);
    }

}
