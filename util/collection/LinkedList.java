package util.collection;

import java.util.Iterator;

public class LinkedList<T> extends List<T> {

    private class Node {
        T value;
        Node next, previous;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.append("a");
        list.append("c");
        list.insert(1, "b");
        System.out.println(list + " " + list.isEmpty());

        list.remove(1);
        System.out.println(list + " " + list.isEmpty());

        list.clear();
        System.out.println(list + " " + list.isEmpty());

        list.remove(0);
    }

    @SuppressWarnings("unchecked")
    public static <T> LinkedList<T> of(T... values) {
        LinkedList<T> list = new LinkedList<>();
        for (T value : values) {
            list.append(value);
        }
        return list;
    }

    public static <T> LinkedList<T> of(Iterable<T> values) {
        LinkedList<T> list = new LinkedList<>();
        list.appendAll(values);
        return list;
    }

    private Node head, tail;

    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        return getNode(index).value;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        getNode(index).value = value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d]", index, size));
        }
        Node node = new Node();
        node.value = value;

        if (size == 0) { // empty list
            head = node;
            tail = node;
        } else if (index == 0) { // insert at head
            if (head != null) {
                node.next = head;
                head.previous = node;
            }
            head = node;
        } else if (index == size) { // insert at tail
            if (tail != null) {
                node.previous = tail;
                tail.next = node;
            }
            tail = node;
        } else { // insert in middle
            Node previous = getNode(index - 1);
            node.previous = previous;
            node.next = previous.next;
            previous.next = node;
            if (node.next != null) {
                node.next.previous = node;
            }
        }

        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds of [0, %d)", index, size));
        }
        Node node = getNode(index);
        T value = node.value;
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            tail = node.previous;
        }
        size--;
        return value;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        class LinkedListIterator implements Iterator<T> {

            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
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

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size / 2) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
            return node;
        }
    }

}
