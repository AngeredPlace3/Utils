package util.collections;

import java.util.NoSuchElementException;

interface FirstOut<E> {

    E getFirst() throws NoSuchElementException;

    interface Mutable<E> extends FirstOut<E> {
        E removeFirst();
    }
}