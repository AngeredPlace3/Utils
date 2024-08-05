package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class LinkedList<E> extends AbstractList<E> {

    private class Node {
        Node next, prev;
        E data;
    }

    private Node head, tail;
    private int size;

    public LinkedList() {
        head = new Node();
        tail = new Node();
        clear();
    }

    @Override
    public void add(int index, E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public E set(int index, E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        class LinkedListIterator implements Iterator<E> {

            private Node current = head.next;

            @Override
            public boolean hasNext() {
                return current != tail;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        }

        return new LinkedListIterator();
    }

}
